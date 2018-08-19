package com.ubs.opsit.interviews.wordfrequency;

import com.ubs.opsit.interviews.wordfrequency.utils.FrequencyHelper;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.stream.Collectors;

public class WordFrequencyImpl implements WordFrequency{
    private ConcurrentMap<String, AtomicInteger> wordFrequencyCache = new ConcurrentHashMap<>();
    private final String SEPARATOR = " ";

    @Override
    public Map<String, Integer> countOccurrencesOfWordsWithin(String stringToEvaluate) throws IllegalArgumentException{
        if(stringToEvaluate == null || stringToEvaluate.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty!");
        }

        Arrays.stream(stringToEvaluate.split(SEPARATOR))
                .map(FrequencyHelper::ignoreNonPrintableOrPunctuationCharacters)
                .filter(word -> !word.isEmpty())
                .forEach(
                        word -> {
                            wordFrequencyCache.putIfAbsent(word, new AtomicInteger(0));
                            wordFrequencyCache.get(word).incrementAndGet();
                        }
                );

        return wordFrequencyCache.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get()));
    }
}

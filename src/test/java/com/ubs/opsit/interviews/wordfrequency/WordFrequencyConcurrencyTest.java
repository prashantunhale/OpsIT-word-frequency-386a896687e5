package com.ubs.opsit.interviews.wordfrequency;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

class FrequencyTask implements Callable<Map<String, Integer>> {
    private final WordFrequency frequency;
    private final String input;

    public FrequencyTask(WordFrequency frequency, String input){
        this.frequency = frequency;
        this.input = input;
    }

    @Override
    public Map<String, Integer> call() {
        return frequency.countOccurrencesOfWordsWithin(this.input);
    }
}

public class WordFrequencyConcurrencyTest {
    WordFrequency frequency = new WordFrequencyImpl();
    final String INPUT = "the man in the moon";
    final int TOTAL_THREADS = 10;
    final int NO_OF_LOOPS = 1_000_000;


    @Test
    public void concurrencyTest(){
        List<Future<Map<String, Integer>>> futuresList = new ArrayList<>();
        Map<String, Integer> output = null;
        ExecutorService executor = Executors.newFixedThreadPool(TOTAL_THREADS);
        for (int i = 0; i < NO_OF_LOOPS; i++){
            Future<Map<String, Integer>> result = executor.submit(new FrequencyTask(frequency, INPUT));

            futuresList.add(result);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
            output = futuresList.get(999_999).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull("Output is not null", output);

        Assert.assertNotNull("'the' word count does not exist in output", output.get("the"));
        Assert.assertEquals(2_000_000, (int) output.get("the"));
        Assert.assertNotNull("'moon' word count does not exist in output", output.get("moon"));
        Assert.assertEquals(1_000_000, (int) output.get("moon"));
        Assert.assertNotNull("'in' word count does not exist in output", output.get("in"));
        Assert.assertEquals(1_000_000, (int) output.get("in"));
        Assert.assertNotNull("'man' word count does not exist in output", output.get("man"));
        Assert.assertEquals(1_000_000, (int) output.get("man"));
    }
}

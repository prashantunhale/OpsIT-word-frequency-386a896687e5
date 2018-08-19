package com.ubs.opsit.interviews.wordfrequency.utils;

public class FrequencyHelper {

    //Ignore any characters which is non-printable (any control/whitespace/) or punctuation
    public static String ignoreNonPrintableOrPunctuationCharacters(String word){
        return word != null ? word.replaceAll("[^A-Za-z0-9]","") : word;
    }

}

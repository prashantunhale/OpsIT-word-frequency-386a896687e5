package com.ubs.opsit.interviews.wordfrequency.utils;

import org.junit.Assert;
import org.junit.Test;

public class FrequencyHelperTest {

    @Test
    public void testNullInput(){
        String result = FrequencyHelper.ignoreNonPrintableOrPunctuationCharacters(null);
        Assert.assertNull("Result is not null", result);
    }

    @Test
    public void testEmptyInput(){
        String result = FrequencyHelper.ignoreNonPrintableOrPunctuationCharacters("");
        Assert.assertTrue("Result is not empty", result.isEmpty());
    }

    @Test
    public void testNonPrintableInput(){
        String result = FrequencyHelper.ignoreNonPrintableOrPunctuationCharacters("@!.@%!abc");
        Assert.assertEquals("Result should be abc", "abc", result);
    }

    @Test
    public void testPrintableInput(){
        String result = FrequencyHelper.ignoreNonPrintableOrPunctuationCharacters("abc");
        Assert.assertEquals("Result should be abc", "abc", result);
    }

    @Test
    public void testDigitsInput(){
        String result = FrequencyHelper.ignoreNonPrintableOrPunctuationCharacters("123");
        Assert.assertEquals("Result should be 123", "123", result);
    }
}

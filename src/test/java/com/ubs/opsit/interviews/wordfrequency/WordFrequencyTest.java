package com.ubs.opsit.interviews.wordfrequency;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Map;

public class WordFrequencyTest {

    WordFrequency frequency;

    @Before
    public void beforeTest(){
        frequency = new WordFrequencyImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        frequency.countOccurrencesOfWordsWithin(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyInput() {
        frequency.countOccurrencesOfWordsWithin("");
    }

    @Test
    public void testDigitInput() {
        Map<String, Integer> output = frequency.countOccurrencesOfWordsWithin("12 43 395");

        Assert.assertNotNull("Output is null", output);

        Assert.assertNotNull("'12' word count does not exist in output", output.get("12"));
        Assert.assertEquals(1, (int) output.get("12"));
        Assert.assertNotNull("'43' word count does not exist in output", output.get("43"));
        Assert.assertEquals(1, (int) output.get("43"));
        Assert.assertNotNull("'395' word count does not exist in output", output.get("395"));
        Assert.assertEquals(1, (int) output.get("395"));
    }

    @Test
    public void testNonCharacterInput() {
        Map<String, Integer> output = frequency.countOccurrencesOfWordsWithin("!@$ @!$ ~!)@");

        Assert.assertNotNull("Output is null", output);

        Assert.assertTrue("Output is not empty", output.isEmpty());
    }

    @Test
    public void testValidInputOnce() {
        Map<String, Integer> output = frequency.countOccurrencesOfWordsWithin("the man in the moon");

        Assert.assertNotNull("Output is not null", output);

        Assert.assertNotNull("'the' word count does not exist in output", output.get("the"));
        Assert.assertEquals(2, (int) output.get("the"));
        Assert.assertNotNull("'moon' word count does not exist in output", output.get("moon"));
        Assert.assertEquals(1, (int) output.get("moon"));
        Assert.assertNotNull("'in' word count does not exist in output", output.get("in"));
        Assert.assertEquals(1, (int) output.get("in"));
        Assert.assertNotNull("'man' word count does not exist in output", output.get("man"));
        Assert.assertEquals(1, (int) output.get("man"));

    }

    @Test
    public void testValidInputTwice() {
        frequency.countOccurrencesOfWordsWithin("the man in the moon");
        Map<String, Integer> output = frequency.countOccurrencesOfWordsWithin("the man in the moon");

        Assert.assertNotNull("Output is null", output);

        Assert.assertNotNull("'the' word count does not exist in output", output.get("the"));
        Assert.assertEquals(4, (int) output.get("the"));
        Assert.assertNotNull("'moon' word count does not exist in output", output.get("moon"));
        Assert.assertEquals(2, (int) output.get("moon"));
        Assert.assertNotNull("'in' word count does not exist in output", output.get("in"));
        Assert.assertEquals(2, (int) output.get("in"));
        Assert.assertNotNull("'man' word count does not exist in output", output.get("man"));
        Assert.assertEquals(2, (int) output.get("man"));
    }
}

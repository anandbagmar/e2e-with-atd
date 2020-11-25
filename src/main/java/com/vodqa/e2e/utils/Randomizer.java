package com.vodqa.e2e.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {
    public static String randomize(String randomizeTestData) {
        String randomizedValue = randomizeTestData;
        try {
            Long.parseLong(randomizeTestData);
            randomizedValue = RandomStringUtils.randomNumeric(10);
        } catch (NumberFormatException nfe) {
            randomizedValue = "e2e_" + RandomStringUtils.randomAlphanumeric(10) + ".com";
        }
        return randomizedValue;
    }
}

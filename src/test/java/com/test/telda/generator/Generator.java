package com.test.telda.generator;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Generator {
    private final Random random;

    public short generateId() {
        return (short) Math.abs(random.nextInt() % 100);
    }

    public String generateName() {
        return random.ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String generateAbbreviatedName() {
        return random.ints(97, 123)
                .limit(3)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().toUpperCase();
    }
}

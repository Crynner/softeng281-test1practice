package com.crynner;

import java.util.ArrayList;

class Phoneme {

    public Phoneme(char symbol, long durationMs, double intensity, boolean isVowel) {
    }

    public char getSymbol() {
        return '\0';
    }

    public long getDuration() {
        return -1;
    }

    public double getIntensity() {
        return -1.0;
    }

    public boolean isVowel() {
        return false;
    }

    public boolean isLong() {
        return false;
    }

    public void amplify(double factor) {
    }
}

class VowelDetector {

    public VowelDetector() {
    }

    public void addPhoneme(Phoneme p) {
    }

    public int getVowelCount() {
        return -1;
    }

    public double getAverageIntensity() {
        return -1.0;
    }

    public char getLongestVowel() {
        return '\0';
    }

    public void removeShortSounds(long minDuration) {
    }

    @Override
    public String toString() {
        return "";
    }
}

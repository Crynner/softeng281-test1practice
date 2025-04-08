package com.crynner;

import java.util.List;
import java.util.ArrayList;

class Phoneme {
    private char symbol;
    private long duration;
    private double intensity;
    private boolean vowel;

    public Phoneme(char symbol, long durationMs, double intensity, boolean isVowel) {
        this.symbol = symbol;
        this.duration = durationMs;
        this.intensity = intensity;
        this.vowel = isVowel;
    }

    public char getSymbol() {
        return symbol;
    }

    public long getDuration() {
        return duration;
    }

    public double getIntensity() {
        return intensity;
    }

    public boolean isVowel() {
        return vowel;
    }

    public boolean isLong() {
        return duration > 250;
    }

    public void amplify(double factor) {
        intensity *= factor;
        if (intensity > 1.0) {
            intensity = 1.0;
        } else if (intensity < 0.0) {
            intensity = 0.0;
        }
    }
}

class VowelDetector {
    List<Phoneme> sounds = new ArrayList<>();
    List<Phoneme> vowels = new ArrayList<>();

    public void addPhoneme(Phoneme p) {
        sounds.add(p);
        if (p.isVowel()) {
            vowels.add(p);
        }
    }

    public int getVowelCount() {
        return vowels.size();
    }

    public double getAverageIntensity() {
        double totalIntensity = 0;
        for (Phoneme sound : sounds) {
            totalIntensity += sound.getIntensity();
        }
        if (sounds.size() != 0) {
            return totalIntensity / sounds.size();
        }
        return totalIntensity;
    }

    public char getLongestVowel() {
        Phoneme longestVowel = null;
        for (Phoneme vowel : vowels) {
            if (longestVowel == null) { // for first iteration, there is no comparison
                longestVowel = vowel;
                continue;
            }
            if (vowel.getDuration() > longestVowel.getDuration()) {
                longestVowel = vowel;
            }
        }
        return longestVowel == null ? '-' : longestVowel.getSymbol();
    }

    public void removeShortSounds(long minDuration) {
        List<Phoneme> toRemove = new ArrayList<>();
        for (Phoneme sound : sounds) {
            if (sound.getDuration() < minDuration) {
                toRemove.add(sound);
            }
        }
        // deleting later to prevent ConcurrentModificationException
        for (Phoneme removal : toRemove) {
            sounds.remove(removal);
            vowels.remove(removal);
        }
    }

    @Override
    public String toString() {
        String totalString = "";
        for (Phoneme sound : sounds) {
            totalString += String.format("Symbol: %s, Duration: %dms, Intensity: %.2f\n",
                sound.getSymbol(), sound.getDuration(), sound.getIntensity());
        }
        return totalString;
    }
}

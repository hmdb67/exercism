package io.exercism.piglatin;

import java.util.ArrayList;
import java.util.List;

class PigLatinTranslator {

    String translate(String wordToTranslate) {
        List<String> phrase = new ArrayList<>();

        String[] sentence = wordToTranslate.split(" ");

        for (String word : sentence) {
            String bodyOfWord = translateWord(word);
            phrase.add(bodyOfWord);
        }

        return String.join(" ", phrase);
    }

    private String translateWord(String word) {
        String posFix = "ay";

        if (wordStartsWithVowelSound(word)) {
            return word + posFix;
        }

        int stringDividerPosition = getStringDividerPosition(word);
        String bodyOfWord = word.substring(stringDividerPosition);
        String preFixWord = word.substring(0, stringDividerPosition);
        return bodyOfWord + preFixWord + posFix;
    }

    private int getStringDividerPosition(String word) {
        if (beginsWithConsonantCluster(word)) {
            if (word.startsWith("thr") || word.startsWith("sch")) {
                return 3;
            } else {
                return 2;
            }
        } else {
            int preFixPosition = word.indexOf("qu");
            if (preFixPosition == 0) {
                return 2;
            } else if (preFixPosition == 1) {
                return 3;
            } else {
                return 1;
            }
        }

    }

    private boolean beginsWithConsonantCluster(String word) {
        return word.startsWith("ch") ||
            word.startsWith("th") ||
            word.startsWith("sch") ||
            word.startsWith("rh");
    }

    private boolean wordStartsWithVowelSound(String wordToTranslate) {
        return wordToTranslate.startsWith("xr") || wordToTranslate.startsWith("yt") || wordToTranslate.startsWith("a") || wordToTranslate.startsWith("e") || wordToTranslate.startsWith("i") || wordToTranslate.startsWith("o") || wordToTranslate.startsWith("u");
    }

}

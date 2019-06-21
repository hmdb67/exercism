package io.exercism.piglatin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @Before
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordBeginningWithA() {
        assertEquals("appleay", pigLatinTranslator.translate("apple"));
    }

    @Test
    public void testWordBeginningWithE() {
        assertEquals("earay", pigLatinTranslator.translate("ear"));
    }

    @Test
    public void testWordBeginningWithI() {
        assertEquals("iglooay", pigLatinTranslator.translate("igloo"));
    }

    @Test
    public void testWordBeginningWithO() {
        assertEquals("objectay", pigLatinTranslator.translate("object"));
    }

    @Test
    public void testWordBeginningWithU() {
        assertEquals("underay", pigLatinTranslator.translate("under"));
    }

    @Test
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertEquals("equalay", pigLatinTranslator.translate("equal"));
    }


    @Test
    public void testWordBeginningWithP() {
        assertEquals("igpay", pigLatinTranslator.translate("pig"));
    }

    @Test
    public void testWordBeginningWithK() {
        assertEquals("oalakay", pigLatinTranslator.translate("koala"));
    }

    @Test
    public void testHector() {
        assertEquals("ectorhay", pigLatinTranslator.translate("hector"));
    }

    @Test
    public void testWordBeginningWithX() {
        assertEquals("enonxay",
            pigLatinTranslator.translate("xenon"));
    }

    @Test
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertEquals("atqay", pigLatinTranslator.translate("qat"));
    }

    @Test
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("airchay", pigLatinTranslator.translate("chair"));
    }

    @Test
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("eenquay", pigLatinTranslator.translate("queen"));
    }

    @Test
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("aresquay", pigLatinTranslator.translate("square"));
    }

    @Test
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("erapythay", pigLatinTranslator.translate("therapy"));
    }

    @Test
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("ushthray", pigLatinTranslator.translate("thrush"));
    }

    @Test
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("oolschay", pigLatinTranslator.translate("school"));
    } // school -> ool - sch - ay ->oolschay

    @Test
    public void testYtTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("yttriaay", pigLatinTranslator.translate("yttria"));
    } // yttria -> yttria + ay

    @Test
    public void testXrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("xrayay", pigLatinTranslator.translate("xray"));
    } //xray -> xray + ay

    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("ellowyay", pigLatinTranslator.translate("yellow"));
    }

    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertEquals("ythmrhay", pigLatinTranslator.translate("rhythm"));
    } // rhythm - ythm + rh + ay

    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        assertEquals("ymay", pigLatinTranslator.translate("my"));
    }

    @Test
    public void testAWholePhrase() {
        assertEquals("ickquay astfay unray", pigLatinTranslator.translate("quick fast run"));
    }

    @Test
    public void testNewPhrase() {
        assertEquals("ymay amenay isay imkay", pigLatinTranslator.translate("my name is kim"));
    }


}

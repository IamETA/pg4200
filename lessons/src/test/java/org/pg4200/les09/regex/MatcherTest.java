package org.pg4200.les09.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by arcuri82 on 07-May-18.
 */
public class MatcherTest {


    @Test
    public void testSingleLetter(){

        Matcher matcher = new Matcher("a");

        assertFalse(matcher.match(""));
        assertFalse(matcher.match("b"));
        assertFalse(matcher.match("ab"));

        assertTrue(matcher.match("a"));
    }

    @Test
    public void testOr(){

        Matcher matcher = new Matcher("(a|b)");

        assertFalse(matcher.match(""));
        assertFalse(matcher.match("ab"));
        assertFalse(matcher.match("c"));

        assertTrue(matcher.match("a"));
        assertTrue(matcher.match("b"));
    }

    @Test
    public void testOrWithFollowing(){

        Matcher matcher = new Matcher("(a|b)c");

        assertFalse(matcher.match("ab"));
        assertFalse(matcher.match("c"));

        assertTrue(matcher.match("ac"));
        assertTrue(matcher.match("bc"));
        assertFalse(matcher.match(""));
    }

    @Test
    public void testStar(){

        Matcher matcher = new Matcher("a*");

        assertFalse(matcher.match("b"));
        assertFalse(matcher.match("ba"));

        assertTrue(matcher.match(""));
        assertTrue(matcher.match("a"));
        assertTrue(matcher.match("aa"));
        assertTrue(matcher.match("aaa"));
    }

    @Test
    public void testStarWithFollowing(){

        Matcher matcher = new Matcher("a*b");

        assertFalse(matcher.match(""));
        assertFalse(matcher.match("c"));

        assertTrue(matcher.match("b"));
        assertTrue(matcher.match("ab"));
        assertTrue(matcher.match("aab"));
        assertTrue(matcher.match("aaab"));
    }

    @Test
    public void testAnySingle(){

        Matcher matcher = new Matcher(".");

        assertFalse(matcher.match(""));
        assertFalse(matcher.match("ab"));

        assertTrue(matcher.match("a"));
        assertTrue(matcher.match("b"));
        assertTrue(matcher.match("."));
    }

    @Test
    public void testAll() {

        Matcher matcher = new Matcher(".*");

        assertTrue(matcher.match(""));
        assertTrue(matcher.match("."));
        assertTrue(matcher.match("a"));
        assertTrue(matcher.match("ab"));
    }

    @Test
    public void testHasLetter() {

        Matcher matcher = new Matcher(".*a.*");

        assertFalse(matcher.match(""));
        assertFalse(matcher.match("b"));
        assertFalse(matcher.match("bc"));

        assertTrue(matcher.match("a"));
        assertTrue(matcher.match("ab"));
        assertTrue(matcher.match("ca"));
        assertTrue(matcher.match("cab"));
    }

    @Test
    public void testExampleFromBook(){

        Matcher matcher = new Matcher(".*(a*b|ac)d.*");

        assertFalse(matcher.match("ac"));
        assertFalse(matcher.match("ad"));
        assertFalse(matcher.match("aaa"));
        assertFalse(matcher.match("add"));
        assertFalse(matcher.match("bcd"));
        assertFalse(matcher.match("babaaa"));
        assertFalse(matcher.match("babbaaa"));

        assertTrue(matcher.match("abd"));
        assertTrue(matcher.match("abccbd"));
    }
}
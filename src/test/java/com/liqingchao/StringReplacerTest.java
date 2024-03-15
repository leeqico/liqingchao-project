package com.liqingchao;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqingchao
 * @date 2024-03-15
 */
public class StringReplacerTest {

    private static final Logger log = LoggerFactory.getLogger(StringReplacerTest.class);

    /**
     * Example:
     * ccc -> b
     * bbb -> a
     *
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     */
    @Test
    public void test() {
        String actualValue = StringReplacer.process("abcccbad");
        String expectedValue = "d";
        log.info("The expected value is {}, The actual value is {}", expectedValue, actualValue);
        Assert.assertEquals(expectedValue,actualValue);
    }

}

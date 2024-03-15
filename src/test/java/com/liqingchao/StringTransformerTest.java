package com.liqingchao;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqingchao
 * @date 2024-03-15
 */
public class StringTransformerTest {

    private static final Logger log = LoggerFactory.getLogger(StringTransformerTest.class);

    /**
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
    @Test
    public void test() {
        String actualValue = StringTransformer.process("aabcccbbad");
        String expectedValue = "d";
        log.info("The expected value is {}, The actual value is {}", expectedValue, actualValue);
        Assert.assertEquals(expectedValue,actualValue);
    }

}

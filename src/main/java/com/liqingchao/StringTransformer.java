package com.liqingchao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqingchao
 * @date 2024-03-15
 */
public class StringTransformer {

    private static final Logger log = LoggerFactory.getLogger(StringReplacer.class);

    public static String process(String input) {
        log.info("Input: {}", input);
        String output = input;
        log.info("Output: ");
        // Repeat the process until no more than 2 identical characters are sitting beside each other
        while (hasMoreThanThreeConsecutiveChars(output)) {
            output = removeConsecutiveDuplicates(output, 3);
            log.info("-> {}", output);
        }
        if (output.equals(input)) {
            log.info("-> {}", output);
        }
        return output;
    }

    private static boolean hasMoreThanThreeConsecutiveChars(String str) {
        boolean hasMoreThanThreeConsecutiveChars = false;
        int length = str.length();
        if (length < 3) {
            return hasMoreThanThreeConsecutiveChars;
        }
        for (int i = 1; i < length - 1; i++) {
            if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i + 1)) {
                // Found more than three consecutive identical characters
                hasMoreThanThreeConsecutiveChars = true;
            }
        }return hasMoreThanThreeConsecutiveChars;
    }

    private static String removeConsecutiveDuplicates(String str, int maxConsecutive) {
        String result = null;
        char previousChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char charAti = str.charAt(i);
            if (charAti == previousChar) {
                count++;
            } else {
                previousChar = str.charAt(i);
                count = 1;
            }
            //If the number of repeated letters reaches the specified number, the string of repeated characters is deleted and the latest string is returned
            if (count >= maxConsecutive && str.charAt(i+1) != previousChar) {
                String substring1 = str.substring(0, i - count + 1);
                String substring2 = str.substring(i+1);
                result = substring1 + substring2;
            }
        }

        return result;
    }
}
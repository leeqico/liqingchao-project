package com.liqingchao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqingchao
 * @date 2024-03-15
 */
public class StringReplacer {

    private static final Logger log = LoggerFactory.getLogger(StringReplacer.class);

    /**
     * All letters from a-z
     */
    private static final String allChar = "abcdefghijklmnopqrstuvwxyz";

    /**
     *
     * @param input Input parameters
     * @return Output
     */
    public static String process(String input) {
        log.info("Input: " + input);
        String output = input;
        log.info("Output: ");
        // Repeat the process until no more than 2 identical characters are sitting beside each other
        while (hasMoreThanThreeConsecutiveChars(output)) {
            output = replaceConsecutiveDuplicates(output, 3);
            log.info("-> {}", output);
        }
        if (output.equals(input)) {
            log.info("-> {}", output);
        }
        return output;
    }

    /**
     *
     * @param str Input parameters
     * @return
     */
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

    /**
     *
     * @param str Input parameters
     * @param maxConsecutive max consecutive
     * @return
     */
    private static String replaceConsecutiveDuplicates(String str, int maxConsecutive) {
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
            //When the number of consecutive repeated letters reaches the specified number, the previous letter of the letter is retrieved to replace the string of repeated characters
            if (count >= maxConsecutive && str.charAt(i+1) != previousChar) {
                String substring1 = str.substring(0, i - count + 1);
                String substring2 = "";
                String substring3 = str.substring(i+1);

                for (int j = 1; j < allChar.length(); j++) {
                    char c = allChar.charAt(j);
                    if (previousChar == c) {
                        int q = Math.max(j - 1, 0);
                        substring2 = String.valueOf(allChar.charAt(q));
                    }
                }
                result = substring1 + substring2 + substring3;
            }
        }

        return result;
    }
}
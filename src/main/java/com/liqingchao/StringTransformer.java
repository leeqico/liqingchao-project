package com.liqingchao;

public class StringTransformer {

    public static void main(String[] args) {
        String input = "aabcccbbad";
        System.out.println("Input: " + input);
        String output = input;
        System.out.println("Output: ");
        while (hasMoreThanThreeConsecutiveChars(output)) {
            output = removeConsecutiveDuplicates(output, 3);
            System.out.println("-> " + output);
        }
    }

    public static void process(String input) {
        System.out.println("Input: " + input);
        String output = input;
        System.out.println("Output: ");
        while (hasMoreThanThreeConsecutiveChars(output)) {
            output = removeConsecutiveDuplicates(output, 3);
            System.out.println("-> " + output);
        }
    }

    private static boolean hasMoreThanThreeConsecutiveChars(String str) {
        boolean hasMoreThanThreeConsecutiveChars = false;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i + 1)) {
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
            if (count >= maxConsecutive && str.charAt(i+1) != previousChar) {
                String substring1 = str.substring(0, i - count + 1);
                String substring2 = str.substring(i+1);
                result = substring1 + substring2;
            }
        }

        return result;
    }
}
package ru.sbrf.efs_notification_ksh_dummy.core.random;

import java.util.Random;

public class RandomGenerator {
    public static final String RUSSIAN_UPPER_CASE_LETTERS_STRING = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧЩЪЫЬЭЮЯ";
    public static final char[] RUSSIAN_UPPER_CASE_LETTERS = RUSSIAN_UPPER_CASE_LETTERS_STRING.toCharArray();
    public static final String ENGLISH_UPPER_CASE_LETTERS_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final char[] ENGLISH_UPPER_CASE_LETTERS = ENGLISH_UPPER_CASE_LETTERS_STRING.toCharArray();
    public static final String RUSSIAN_LOWER_CASE_LETTERS_STRING = "абвгдеёжзийклмнопрстуфхцчщъыьэюя";
    public static final char[] RUSSIAN_LOWER_CASE_LETTERS = RUSSIAN_LOWER_CASE_LETTERS_STRING.toCharArray();
    public static final String ENGLISH_LOWER_CASE_LETTERS_STRING = "abcdefghijklmnopqrstuvwxyz";
    public static final char[] ENGLISH_LOWER_CASE_LETTERS = ENGLISH_LOWER_CASE_LETTERS_STRING.toCharArray();
    public static final String NUMBERS_STRING = "0123456789";
    public static final char[] NUMBERS = NUMBERS_STRING.toCharArray();
    public static final char[] NOT_ZERO_NUMBERS = "123456789".toCharArray();
    public static final String ALPHANUMERIC_LETTERS_STRING = ENGLISH_UPPER_CASE_LETTERS_STRING + ENGLISH_LOWER_CASE_LETTERS_STRING + NUMBERS_STRING;

    public static final Random RANDOM = new Random();

    public static char[] randomCharArray(int length, String alphabet) {
        char[] chars = alphabet.toCharArray();
        return randomCharArray(length, chars);
    }

    public static char[] randomCharArray(int length, char[] alphabet) {
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomCharFromArray(alphabet);
        }
        return result;
    }

    public static String randomNumberByDigitsCount(int digitsCount) {
        char[] firstDigit = randomCharArray(1, NOT_ZERO_NUMBERS);
        int digitsCountWithoutFirstOne = digitsCount - 1;
        char[] otherDigits = randomCharArray(digitsCountWithoutFirstOne, NUMBERS);
        char[] resultDigitsArray = concatenateArrays(firstDigit, otherDigits);
        return new String(resultDigitsArray);
    }

    static char[] concatenateArrays(char[] first, char[] second) {
        char[] result = new char[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    static char randomCharFromArray(char[] chars){
        return chars[RANDOM.nextInt(chars.length)];
    }
}

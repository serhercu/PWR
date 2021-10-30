package lab12;

import java.util.LinkedList;

public class KMP implements IStringMatcher {

    static int[] computeLongestMatches(String pat, int patternLength)
    {
        int[] result = new int[patternLength];
        for (int i = 1, len = 0; i < patternLength; ) {
            if (pat.charAt(i) == pat.charAt(len)) {
                result[i++] = ++len;
            }
            else {
                if (len > 0)
                {
                    len = result[len - 1];
                }
                else
                {
                    i++;
                }
            }
        }
        return result;
    }

    @Override
    public LinkedList<Integer> validShifts(String pattern, String text) {
        // TODO Auto-generated method stub
        LinkedList<Integer> result = new LinkedList<>();

        if (text == null || pattern == null) {
            return result;
        }
        int patternLength = pattern.length();
        int textLength = text.length();
        int i = 0;
        int j = 0;
        if (patternLength > textLength) {
            return result;
        }
        int[] matches = computeLongestMatches(pattern, patternLength);
        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                result.add(i - j);
                j = matches[j - 1];
            }
            else {
                if (i < textLength && pattern.charAt(j) != text.charAt(i)) {

                    if (j != 0) {
                        j = matches[j - 1];
                    }

                    else {
                        i = i + 1;
                    }

                }
            }

        }
        return result;
    }
}

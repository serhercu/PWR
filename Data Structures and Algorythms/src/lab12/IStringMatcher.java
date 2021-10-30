package lab12;

import java.util.LinkedList;

public interface IStringMatcher {
    LinkedList<Integer> validShifts(String pattern, String text);
}
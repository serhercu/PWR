package lab12;

import java.util.LinkedList;

public class Automaton implements IStringMatcher {
    private static final int CHARS_COUNT = 256;

    private static int getNextState(char[] pat, int patLength, int state, int c) {
        if (state < patLength && c == pat[state]) {
            return state + 1;
        }
        int i;
        for (int nextState = state; nextState > 0; nextState--)
        {
            if (pat[nextState - 1] == c)
            {
                for (i = 0; i < nextState - 1; i++)
                {
                    if (pat[i] != pat[state - nextState + 1 + i])
                    {
                        break;
                    }
                }
                if (i == nextState - 1)
                {
                    return nextState;
                }
            }
        }
        return 0;
    }

    private static void computeSetOfStates(char[] pat, int patLength, int[][] setOfStates)
    {
        for (int state = 0; state <= patLength; ++state)
        {
            for (int c = 0; c < CHARS_COUNT; ++c)
            {
                setOfStates[state][c] = getNextState(pat, patLength, state, c);
            }
        }
    }
    @Override
    public LinkedList<Integer> validShifts(String pattern, String text) {
        //TODO
        LinkedList<Integer> result = new LinkedList<>();
        char[] pat = pattern.toCharArray();
        char[] txt = text.toCharArray();
        int patLength = pat.length;
        int textLength = txt.length;
        int[][] setOfStates = new int[patLength + 1][CHARS_COUNT];
        computeSetOfStates(pat, patLength, setOfStates);
        int i, state = 0;
        for (i = 0; i < textLength; i++)
        {
            state = setOfStates[state][txt[i]];
            if (state == patLength)
            {
                result.add((i - patLength + 1));
            }
        }
        return result;
    }
}

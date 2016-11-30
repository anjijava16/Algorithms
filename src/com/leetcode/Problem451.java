package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By FrequencyGiven a string,
 * sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Created by sunilpatil on 11/29/16.
 */
public class Problem451 {
    public String frequencySort(String s) {
        if (s.length() == 0)
            return s;
        char[] inputCharArray = s.toCharArray();

        //Calculate frequency of characters
        int[] frequencyCounter = new int[256];
        for (char c : inputCharArray)
            frequencyCounter[c] = frequencyCounter[c] + 1;

        PriorityQueue<CharFrequency> priorityQueue = new PriorityQueue<>(inputCharArray.length, new Comparator<CharFrequency>() {
            @Override
            public int compare(CharFrequency o1, CharFrequency o2) {
                if (o1.frequency > o2.frequency)
                    return -1;
                return 0;
            }
        });
        //Insert non empty char frequency into priority queue
        for (int i = 0; i < frequencyCounter.length; i++) {
            if (frequencyCounter[i] != 0) {
                priorityQueue.add(new CharFrequency((char) i, frequencyCounter[i]));
            }
        }
        //Pull one element at a time from PriorityQueue and add that to String
        StringBuffer returnStr = new StringBuffer();
        while (!priorityQueue.isEmpty()) {
            CharFrequency charFrequency = priorityQueue.poll();
            for (int i = 0; i < charFrequency.frequency; i++) {
                returnStr.append(charFrequency.c);
            }
        }
        return returnStr.toString();
    }

    public static final class CharFrequency {
        char c;
        int frequency;

        public CharFrequency(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }
}

package com.leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * Created by sunilpatil on 11/29/16.
 */
public class Problem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topKList = new ArrayList<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (Integer i : nums) {
            if (frequency.containsKey(i)) {
                int currentCount = frequency.get(i);
                frequency.put(i, ++currentCount);
            } else {
                frequency.put(i, 1);
            }
        }
        PriorityQueue pq = new PriorityQueue(frequency.size(), new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                IntFrequency first = (IntFrequency) o1;
                IntFrequency second = (IntFrequency) o2;
                if (first.count > second.count)
                    return -1;
                return 1;
            }
        });
        Iterator<Integer> frequencyIt = frequency.keySet().iterator();
        while (frequencyIt.hasNext()) {
            Integer key = frequencyIt.next();
            pq.add(new IntFrequency(key, frequency.get(key)));
        }
        for (int i = 0; i < k; i++)
            topKList.add(((IntFrequency) pq.poll()).i);

        return topKList;
    }

    private static class IntFrequency implements Comparator<IntFrequency> {
        int i;
        int count;

        public IntFrequency(int i, int count) {
            this.i = i;
            this.count = count;
        }

        @Override
        public int compare(IntFrequency o1, IntFrequency o2) {
            if (o1.count < o2.count)
                return -1;
            return 1;
        }
    }
}

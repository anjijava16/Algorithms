package com.leetcode.contest2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunilpatil on 12/3/16.
 */
public class Problem434 {


    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(s);

        int counter = 1;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Counter " + counter);
        return counter;
    }


}

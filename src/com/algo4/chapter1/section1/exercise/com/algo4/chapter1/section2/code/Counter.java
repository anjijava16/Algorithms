package com.algo4.chapter1.section1.exercise.com.algo4.chapter1.section2.code;

/**
 * Created by sunilpatil on 8/31/16.
 */
public class Counter {
    String counterName;
    int count;
    public Counter(String id){
        this.counterName =id;
    }

    public void increment(){
        count++;
    }
    public int tally(){
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counterName='" + counterName + '\'' +
                ", count=" + count +
                '}';
    }
}

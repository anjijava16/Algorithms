package com.coursera.ada1.week6;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/7/16.
 */
public class BloomFilterTest {
    BloomFilter bloomFilter;

    @Before
    public void setup() {
        bloomFilter = new BloomFilter(199);
    }

    @Test
    public void testSimple() {
        bloomFilter.insert("Sunil");
        bloomFilter.insert("Leena");
        bloomFilter.insert("Jiya");
        bloomFilter.insert("Navya");

        assert bloomFilter.contains("Sunil") == true;
        assert bloomFilter.contains("John") == false;

        assert bloomFilter.contains("sdfsdf") == false;
    }


}

package com.coursera.ada1.week6;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.BitSet;

/**
 * Created by sunilpatil on 12/7/16.
 */
public class BloomFilter {

    private static MessageDigest md5 = null;
    private static MessageDigest sha1 = null;
    private static MessageDigest sha2 = null;
    BitSet bitSet;
    MessageDigest md;

    public BloomFilter(int size) {
        bitSet = new BitSet(size);

    }

    public void insert(String s) {
        bitSet.set(getHash(s, "MD5"), true);
        bitSet.set(getHash(s, "SHA"), true);
        bitSet.set(getHash(s, "SHA-256"), true);
        System.out.println("S " + getHash(s, "MD5") + " " + getHash(s, "SHA") + " " + getHash(s, "SHA-256"));
    }

    public boolean contains(String s) {
        System.out.println("S " + getHash(s, "MD5") + " " + getHash(s, "SHA") + " " + getHash(s, "SHA-256"));

        if (bitSet.get(getHash(s, "MD5")) && bitSet.get(getHash(s, "SHA")) && bitSet.get(getHash(s, "SHA-256")))
            return true;
        return false;
    }

    private int getHash(String input, String hash) {
        int returnValue = 0;
        if (md5 == null) {
            try {
                md5 = MessageDigest.getInstance("MD5");
                sha1 = MessageDigest.getInstance("SHA");
                sha2 = MessageDigest.getInstance("SHA-256");
            } catch (Exception ex) {
                System.out.println("Error getting instance of MessageDigest");
            }
        }
        switch (hash) {
            case "MD5":
                md5.update(input.getBytes());
                returnValue = new BigInteger(md5.digest()).intValue();
                break;
            case "SHA":
                sha1.update(input.getBytes());
                returnValue = new BigInteger(sha1.digest()).intValue();
                break;
            case "SHA-256":
                sha2.update(input.getBytes());
                returnValue = new BigInteger(sha2.digest()).intValue();
                break;
        }
        return Math.abs(returnValue % bitSet.size());
    }
}

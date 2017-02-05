package com.leetcode;

/**
 * Created by sunilpatil on 2/3/17.
 */
public class VersionControl {
    int fBadVersion;

    public VersionControl(int firstBadVersion) {
        fBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        if (version > fBadVersion)
            return true;
        return false;
    }
}

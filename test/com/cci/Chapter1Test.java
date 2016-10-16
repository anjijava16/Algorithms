package com.cci;

import org.junit.Test;

/**
 * Created by sunilpatil on 10/13/16.
 */
public class Chapter1Test {
    Chapter1 chapter1 = new Chapter1();

    @Test
    public void testReverString() {

        assert chapter1.reverseString("Hello").equals("olleH");
        assert chapter1.reverseString("").equals("");
        assert chapter1.reverseString("s").equals("s");
        assert chapter1.reverseString("sa").equals("as");
    }
}

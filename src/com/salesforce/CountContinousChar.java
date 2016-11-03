package com.salesforce;

/**
 * Created by spatil30 on 11/2/2016.
 * You have a string aaabbdcccccf, transform it the following way => a3b2d1c5f1
 ie: aabbaa -> a2b2a2 not a4b2
 */
public class CountContinousChar {
    public static void main(String[] argv){
        CountContinousChar countContinousChar = new CountContinousChar();
        System.out.println(countContinousChar.countContinousChars("aaabbdccccf"));
        System.out.println(countContinousChar.countContinousChars("aaabbdccccf").equals("a3b2d1c4f1"));
        System.out.println(countContinousChar.countContinousChars("aaabbdcccc").equals("a3b2d1c4"));

    }

    public String countContinousChars(String source){
        if(source.length() ==0 )
            return source;
        StringBuilder target = new StringBuilder();
        char[] sourceC = source.toCharArray();
        char currentC = sourceC[0];
        int currentCharCount = 1;
        for(int i = 1; i < sourceC.length ; i++){
            char c = sourceC[i];
      //      System.out.print("Current char " + c);
            if(i == sourceC.length -1) {
                if(c == currentC){
                    currentCharCount++;
                    target.append(currentC);
                    target.append(currentCharCount);
                }else{
                    target.append(currentC);
                    target.append(currentCharCount);
                    target.append(c);
                    target.append(1);
                }
            }else if(c == currentC){
        //        System.out.println(", going to if block ");
                currentCharCount++;
            }else{
                target.append(currentC);
                target.append(currentCharCount);

                currentC = c;
                currentCharCount =1;
            }
        }
        return target.toString();
    }
}

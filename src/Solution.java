import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sunilpatil on 10/6/16.
 */
public class Solution {

    /*    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int noOfWords = scan.nextInt();
            String[] queries = new String[noOfWords + 1];
            for (int i = 0; i < noOfWords + 1; i++)
                queries[i] = scan.nextLine();

            String[] palindromeStrings = new String[noOfWords / 2];
            for (int i = 1; i < noOfWords; i = i + 2) {
                palindromeStrings[i / 2] = queries[i] + queries[i + 1];
            }
            for(int i )
            System.out.println(Arrays.toString(palindromeStrings));
        }

        private boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i > j)
                if (s.charAt(i++) != s.charAt(j--))
                    return false;
            return true;
        }*/
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int noOfWords = scan.nextInt();
        System.out.println("Number of words to read " + noOfWords);
        for (int i = 0; i < noOfWords; i++) {
            scan.nextLine();
            String word = scan.next();
            System.out.println(nextWord(word));
        }
        scan.close();
    }

    private static String nextWord(String word) {

        char[] chars = word.toCharArray();
        HashSet<String> wordComb = new HashSet<>();
        perm(chars, chars.length, wordComb);

        String[] combinationWords = new String[wordComb.size()];
        int counter = 0;
        Iterator<String> wordCombIt = wordComb.iterator();
        while (wordCombIt.hasNext())
            combinationWords[counter++] = wordCombIt.next();


        Arrays.sort(combinationWords);
        for (int i = 0; i < combinationWords.length; i++) {
            if (combinationWords[i].equals(word)) {
                if (i + 1 < combinationWords.length)
                    return combinationWords[i + 1];
            }
        }
        return "no answer";
    }


    /**
     * Method to find out all the permutations of a word
     *
     * @param list
     * @param n
     * @param permList
     */
    private static void perm(char[] list, int n, HashSet<String> permList) {
        if (n == 1) {
            permList.add(new String(list));
        } else {
            for (int i = 0; i < n; i++) {
                perm(list, n - 1, permList);

                int j = (n % 2 == 0) ? i : 0;
                char t = list[n - 1];
                list[n - 1] = list[j];
                list[j] = t;
            }
        }

    }


}

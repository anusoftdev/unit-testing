package com.anusoft.unittesting;

public class StringHelperUtil {

    public static void main(String[] args) {
        StringHelperUtil stringHelperUtil = new StringHelperUtil();
        String s = "  raghu   pati raghav raja ram ";
        //System.out.println(countWordsInString(s));
        //System.out.println(countWordsInStringSimple(s));
        System.out.println(stringHelperUtil.reverseString(s));
        System.out.println(stringHelperUtil.isPalindrome("naman"));
        System.out.println(stringHelperUtil.isPalindrome("shiva"));
    }

    public int countWordsInString(String str) {
        int wCount = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)==' ' && str.charAt(i+1) != ' ') {
                wCount++;
            }
        }
        return wCount;
    }

    public int countWordsInStringSimple(String str) {
        String[] spaces = str.split(" ");
        return spaces.length;
    }

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reverse = "";
        for (int i = str.length()-1; i >= 0 ; i--) {
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }
}

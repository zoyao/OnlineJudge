package com.lintcode;

public class _007630_Hex_Conversion {
    public static void main(String[] args){
        hexConversion(30, 16);
    }

    public static String hexConversion(int n, int k) {
        // write your code here
        if (n == 0)
            return "0";

        String returnStr = new String();
        while(n != 0){
            int tmp = n % k;
            n = n / k;

            String tmpStr = String.valueOf(tmp);
            if(tmp >= 10){
                char tmpChar = (char) (tmp - 10 + 65);
                tmpStr = String.valueOf(tmpChar);
            }
            returnStr = tmpStr + returnStr;
        }
        return returnStr;
    }
}

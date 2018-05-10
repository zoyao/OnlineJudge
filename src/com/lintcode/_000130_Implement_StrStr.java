package com.lintcode;

/*
 * @param source: source string to be scanned.
 * @param target: target string containing the sequence of characters to match
 * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
 */
public class _000130_Implement_StrStr {
    public static void main(String[] args){
        int a = strStr("abcde","e");
        System.out.println(a);
    }

    public static int strStr(String source, String target) {
        // write your code here
        if("".equals(source) && "".equals(target))
            return 0;
        if(source == null || target == null)
            return -1;
        if(target != null && target.equals(source))
            return 0;
        char[] str = source.toCharArray();
        int length = target.length();
        for(int i=0; i<=source.length()-target.length(); i++){
            StringBuffer tmp = new StringBuffer();
            for(int j=i; j<i+length; j++){
                tmp.append(str[j]);
            }
            if(target.equals(tmp.toString()))
                return i;
        }
        return -1;
    }
}

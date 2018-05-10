package com.lintcode;

public class _005940_StrStr_2 {
    public static void main(String[] args){
        int a = strStr2("bacdaabaababa","ababa");
        System.out.println(a);
    }

    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public static int strStr2(String source, String target) {
        // write your code here
        if("".equals(source) && "".equals(target))
            return 0;
        if(source == null || target == null)
            return -1;
        if(target != null && target.equals(source))
            return 0;
        char[] str = source.toCharArray();
        int length = target.length();

        char[] targetStr = target.toCharArray();
        int max = targetStr.length;


        int a=0;
        int b=0;
        while(true){
            if(str[a] == targetStr[b]){
                a++;
                b++;
            }else{
                forI:
                for(int i=1; i<targetStr.length; i++){
                    forJ:
                    if(targetStr[i] == targetStr[0]){
                        int j;
                        for(j=0; j<targetStr.length-i; j++){
                            if(targetStr[j] != targetStr[i+j])
                                continue forI;
                        }
                        b = j;
                        break forI;
                    }
                }
            }
        }

        return -1;
    }
}

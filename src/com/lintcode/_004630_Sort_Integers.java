package com.lintcode;

public class _004630_Sort_Integers {
    public static void main(String[] args){
        int[] A = {3,2,1};
        sortIntegers(A);
    }

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] A) {
        // write your code here
        for(int j=0; j < A.length; j++){
            for(int i=j+1; i < A.length; i++){
                if(A[i] < A[j]){
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
    }
}

package com.lintcode;

public class _04840_Swap_Two_Integers_In_Array {
    public static void main(String[] args){

    }

    public static void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
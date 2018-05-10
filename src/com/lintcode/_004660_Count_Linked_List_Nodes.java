package com.lintcode;

public class _004660_Count_Linked_List_Nodes {
    public static void main(String[] args){

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int countNodes(ListNode head) {
        // write your code here
        if(head == null)
            return 0;
        int i = 1;
        while(head.next != null){
            ++i;
            head = head.next;
        }
        return i;
    }
}

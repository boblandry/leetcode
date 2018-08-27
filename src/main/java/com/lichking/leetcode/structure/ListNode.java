package com.lichking.leetcode.structure;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode build(int[] arr){
        ListNode head = null;
        if(arr == null || arr.length == 0){
            return head;
        }
        ListNode cursor = null;
        for(int i=0;i<arr.length;i++){
            ListNode curr = new ListNode(arr[i]);
            if(i == 0){
                head = curr;
                cursor = curr;
            }else{
                cursor.next = curr;
                cursor = cursor.next;
            }
        }
        return head;
    }

    public static String print(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
package com.lichking.leetcode.solution;

import com.lichking.leetcode.structure.ListNode;

/**
 * team : CORE HR
 * Description:
 *
 * @author: wangrubo
 * @date: 2018/8/27
 * @time: 15:19
 * Copyright (C) 2018 Meituan
 * All rights reserved
 * on Date : 2018/8/27  Time : 15:19
 */
public class ReverseLinkedList {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     *    1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *    输入: 1->2->3->4->5->NULL, m = 2, n = 4
     *    输出: 1->4->3->2->5->NULL
     */

    static class Solution {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == n){
                return head;
            }
            ListNode newHead = head;
            ListNode prefixPoint = null;
            int count = 1;
            while(count < m){
                count++;
                prefixPoint = head;
                head = head.next;
            }
            ListNode reverseSub = null;
            ListNode reverseEnd = null;
            while(count <= n){
                count++;
                ListNode curr = new ListNode(head.val);
                if(reverseSub == null){
                    reverseSub = curr;
                    reverseEnd = curr;
                }else{
                    curr.next = reverseSub;
                    reverseSub = curr;
                }
                head = head.next;
            }
            if(prefixPoint != null){
                prefixPoint.next = reverseSub;
            }else{
                newHead = reverseSub;
            }
            reverseEnd.next = head;
            return newHead;
        }

    }

    public static void main(String[] args){
        ListNode head = ListNode.build(new int[]{1,2,3,4,5,6,7,8,9,10});
        head = new ReverseLinkedList.Solution().reverseBetween(head,4,8);
        System.out.println(ListNode.print(head));
    }

}

package com.lichking.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * team : CORE HR
 * Description:
 *
 * @author: wangrubo
 * @date: 2018/8/28
 * @time: 10:59
 * Copyright (C) 2018 Meituan
 * All rights reserved
 * on Date : 2018/8/28  Time : 10:59
 */
public class ValidSquare {

    /**
     * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
     * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
     * 示例:
     * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     * 输出: True
     * 注意:
     * 所有输入整数都在 [-10000，10000] 范围内。
     * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
     * 输入点没有顺序。
     */

    static class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int d12 = Math.abs(p1[0]-p2[0])*Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1])*Math.abs(p1[1]-p2[1]);
            int d13 = Math.abs(p1[0]-p3[0])*Math.abs(p1[0]-p3[0]) + Math.abs(p1[1]-p3[1])*Math.abs(p1[1]-p3[1]);
            int d14 = Math.abs(p1[0]-p4[0])*Math.abs(p1[0]-p4[0]) + Math.abs(p1[1]-p4[1])*Math.abs(p1[1]-p4[1]);
            int d24 = Math.abs(p2[0]-p4[0])*Math.abs(p2[0]-p4[0]) + Math.abs(p2[1]-p4[1])*Math.abs(p2[1]-p4[1]);
            int d34 = Math.abs(p3[0]-p4[0])*Math.abs(p3[0]-p4[0]) + Math.abs(p3[1]-p4[1])*Math.abs(p3[1]-p4[1]);
            int d23 = Math.abs(p2[0]-p3[0])*Math.abs(p2[0]-p3[0]) + Math.abs(p2[1]-p3[1])*Math.abs(p2[1]-p3[1]);
            if(d12 == 0 || d13 == 0 || d14 == 0 || d24 ==0 || d23 == 0 || d34 == 0){
                return false;
            }
            Set<Integer> set = new HashSet<>();
            set.add(d12);
            set.add(d13);
            set.add(d14);
            set.add(d23);
            set.add(d24);
            set.add(d34);
            if(set.size() != 2){
                return false;
            }
            Integer[] arr = set.toArray(new Integer[0]);
            if(arr[0] > arr[1]){
                return arr[1]*2 == arr[0];
            }else{
                return arr[0]*2 == arr[1];
            }
        }
    }

    public static void main(String[] args){
        int[] p1 = new int[]{0,1};
        int[] p2 = new int[]{0,0};
        int[] p3 = new int[]{1,1};
        int[] p4 = new int[]{1,0};
        boolean valid = new ValidSquare.Solution().validSquare(p1,p2,p3,p4);
        System.out.println(valid);
    }

}

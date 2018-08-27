package com.lichking.leetcode.solution;

/**
 * team : CORE HR
 * Description:
 *
 * @author: wangrubo
 * @date: 2018/8/27
 * @time: 14:44
 * Copyright (C) 2018 Meituan
 * All rights reserved
 * on Date : 2018/8/27  Time : 14:44
 */
public class MaxIslandSquare {

    /**
     * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
     */

    static class Solution {

        private boolean[][] visit;

        public int maxAreaOfIsland(int[][] grid) {
            int maxSquare = 0;
            if(grid.length == 0 || grid[0].length == 0){
                return maxSquare;
            }
            initVisit(grid);
            for(int row = 0; row < grid.length; row++){
                for(int col = 0; col < grid[0].length; col++){
                    int currentSize = findIslandSize(grid,row,col);
                    maxSquare = currentSize > maxSquare ? currentSize : maxSquare;
                }
            }
            return maxSquare;
        }

        private void initVisit(int[][] grid){
            visit = new boolean[grid.length][grid[0].length];
        }

        private int findIslandSize(int[][] grid, int row, int col){
            if(grid[row][col] == 0 || visit[row][col]){
                return 0;
            }
            int size = 1;
            visit[row][col] = true;
            if(row-1 >= 0){
                size += findIslandSize(grid,row-1,col);
            }
            if(row+1 < grid.length){
                size += findIslandSize(grid,row+1,col);
            }
            if(col-1 >= 0){
                size += findIslandSize(grid,row,col-1);
            }
            if(col+1 < grid[0].length){
                size += findIslandSize(grid,row,col+1);
            }
            return size;
        }
    }

    public static void main(String[] args){

        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(new Solution().maxAreaOfIsland(grid));
    }

}

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test_1011 {
    public static void main(String[] args) {
        Solution1 solution1 = new Test_1011().new Solution1();
        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        System.out.println(solution1.maximalNetworkRank(8, roads));
    }
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            Map<Integer, Integer> mp = new HashMap<>();
            int[] count = new int[n];
            for(int i = 0; i < roads.length; i++){
                mp.put(roads[i][0],roads[i][1]);
                for(int j = 0; j < 2; j++){
                    count[roads[i][j]]++;
                }
            }
            int max = 0;
            for(int i = 0; i < count.length; i++){
                for(int j = i+1; j < count.length; j++){
                    int sum = count[i] + count[j];
                    if((mp.containsKey(i) && mp.get(i) == j) ||(mp.containsKey(j) && mp.get(j) == i)){
                        sum -= 1;
                        max = Math.max(sum, max);
                    }
                }
            }
            return max;
        }
    }
    class Solution1 {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] count = new int[n];
            boolean[][] connect = new boolean[n][n];
            for(int i = 0; i < roads.length; i++){
                count[roads[i][0]]++;
                count[roads[i][1]]++;
                connect[roads[i][0]][roads[i][1]] = true;

            }
            int max = 0;
            for(int i = 0; i < count.length; i++){
                for(int j = i+1; j < count.length; j++){
                    int sum = count[i] + count[j];
                    if(connect[i][j] || connect[j][i]){
                        sum -= 1;
                    }
                    max = Math.max(sum, max);
                }
            }
            return max;
        }
    }

}

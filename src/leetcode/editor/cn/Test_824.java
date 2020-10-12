package leetcode.editor.cn;

public class Test_824 {
    public static void main(String[] args) {
        Solution solution = new Test_824().new Solution();
        String s = "aaabbbabbbb";
        int[] cost = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(solution.minCost(s,cost));
    }

    class Solution {
        public int minCost(String s, int[] cost) {
            int res = 0;
            for(int i = 0; i < s.length() - 1; i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    res += Math.min(cost[i],cost[i+1]);
                }
            }
            return res;
        }
    }
}

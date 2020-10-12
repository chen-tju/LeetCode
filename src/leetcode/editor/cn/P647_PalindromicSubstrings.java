//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划 
// 👍 294 👎 0


package leetcode.editor.cn;

//回文子串

public class P647_PalindromicSubstrings{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P647_PalindromicSubstrings().new Solution();
        Solution1 solution1 = new P647_PalindromicSubstrings().new Solution1();
        Solution2 solution2 = new P647_PalindromicSubstrings().new Solution2();
        String s = "abc";
        System.out.println(solution.countSubstrings(s));
        System.out.println(solution1.countSubstrings(s));
        System.out.println(solution2.countSubstrings(s));
    }
    //动态规划方法
    class Solution1{
        public int countSubstrings(String s){
            int len = s.length();
            int res = 0;
            boolean[][] dp = new boolean[len][len];
            for(int j = 0; j < len; j++){
                for(int i = 0; i <= j; i++){
                    if(s.charAt(j) == s.charAt(i) && (j-i < 2 || dp[i+1][j-1])){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
            return res;
        }
    }

    //中心扩展法
    class Solution2{
        public int countSubstrings(String s){
            int len = s.length();
            int res = 0;
            for(int i = 0; i < len * 2 - 1; i++){
                int left = i / 2;
                int right = left + i % 2;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                    res++;
                    left--;
                    right++;
                }
            }
            return res;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        char[] Array = s.toCharArray();
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(valid(Array,i,j)){
                    res++;
                }
            }
        }
        return res;
    }
    private boolean valid(char[] Array, int left, int right){
        while(left < right){
            if(Array[left] != Array[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
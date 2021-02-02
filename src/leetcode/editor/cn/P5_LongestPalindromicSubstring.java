//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2523 👎 0


package leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        Solution1 solution1 = new P5_LongestPalindromicSubstring().new Solution1();
        Solution2 solution2 = new P5_LongestPalindromicSubstring().new Solution2();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
        System.out.println(solution1.longestPalindrome(s));
        System.out.println(solution2.longestPalindrome(s));
    }
    class Solution1{
        public String longestPalindrome(String s){
            int len = s.length();
            if(len < 2){
                return s;
            }
            int max = 1;
            int begin = 0;
            boolean[][] dp = new boolean[len][len];//定义一个dp数组，dp[i][j]表示i到j是否为回文子串
            char[] Array = s.toCharArray();

            for(int i = 0; i < len; i++){
                dp[i][i] = true;
            }

            for(int j = 1; j < len; j++){
                for(int i = 0; i < j; i++){
                    if(Array[i] != Array[j]){
                        dp[i][j] = false;
                    }else{
                        //等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
                        // 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
                        if(j - i < 3){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(j - i + 1 > max && dp[i][j]){
                        max = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin,begin + max);
        }
    }

    class Solution2{
        //遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
        public String longestPalindrome(String s){
            //中心扩展法
            int len = s.length();
            String res = "";
            for(int i = 0; i < len * 2 - 1; i++){
                int left = i / 2;
                int right = left + i % 2;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                    String tmp = s.substring(left,right + 1); // 这里加一要注意
                    if(tmp.length() > res.length()){
                        res = tmp;
                    }
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
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int max = 1;
        int begin = 0;
        char[] Array = s.toCharArray();
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(j - i + 1 > max && valid(Array, i, j)){
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
    //定义一个辅助函数用于判定一个Array数组从left到right是否是一个回文子串
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
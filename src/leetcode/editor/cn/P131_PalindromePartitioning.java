//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 556 👎 0


package leetcode.editor.cn;

//分割回文串

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P131_PalindromePartitioning{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P131_PalindromePartitioning().new Solution();
        List<List<String>> res = solution.partition("aab");
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int r = 0; r < n; r++){
            for(int l = 0; l <= r; l++){
                if(s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(res, path, 0, s, dp);
        return res;
    }

    private void dfs(List<List<String>> res, Deque<String> path, int idx, String s, boolean[][] dp){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(dp[idx][i]){
                path.addLast(s.substring(idx, i+1));
                dfs(res, path, i + 1, s, dp);
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
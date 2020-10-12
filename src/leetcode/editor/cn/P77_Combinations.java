//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 353 👎 0


package leetcode.editor.cn;

//组合     -------回溯法模板题，定义一个dfs辅助函数

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P77_Combinations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P77_Combinations().new Solution();
        List<List<Integer>> res = solution.combine(4,2);
        for(List list : res){
            System.out.println(list);
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n < k){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(n, k, 1, path, res);
        return res;
    }
    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i <= n; i++){
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
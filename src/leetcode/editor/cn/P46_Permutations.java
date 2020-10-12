//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 869 👎 0


package leetcode.editor.cn;

//全排列    -------回溯法模板题

import java.util.ArrayList;
import java.util.List;

public class P46_Permutations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.permute(nums);
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, nums.length, 0, path, used, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);//删除path中最后一个元素，进行回溯
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
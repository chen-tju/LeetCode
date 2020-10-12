//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 150 👎 0


package leetcode.editor.cn;

//递增子序列            ---------DFS

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P491_IncreasingSubsequences{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P491_IncreasingSubsequences().new Solution();
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = solution.findSubsequences(nums);
        System.out.println(res);
    }

    class Solution1{
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums){
            dfs(nums, -1, new ArrayList<>());
            return res;
        }
        private void dfs(int[] nums, int idx, List<Integer> cur){
            if(cur.size() > 1){
                res.add(new ArrayList<>(cur));
            }
            Set<Integer> set = new HashSet<>();
            for(int i = idx + 1; i < nums.length; i++){
                if(set.contains(nums[i])){
                    continue;
                }
                set.add(nums[i]);
                if(idx == -1 || nums[idx] <= nums[i]){
                    cur.add(nums[i]);
                    dfs(nums, i, cur);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//代码不太好懂。。。。害   不看
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null){
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }
    private void dfs(int curIndex, int preValue, int[] nums){
        if(curIndex >= nums.length){//说明遍历到数组末尾了     遍历结束
            if(tmp.size() >= 2){//tmp子序列的长度大于等于2
                res.add(tmp);
            }
            return;
        }
        if(nums[curIndex] >= preValue){//如果数组当前索引的值大于等于之前的值
            tmp.add(nums[curIndex]);//将当前值添加进tmp
            dfs(curIndex + 1, nums[curIndex], nums);//递归调用该函数，继续向下遍历
            tmp.remove(tmp.size() - 1);
        }
        if(nums[curIndex] != preValue){  //不遍历重复元素，从下一个 遍历
            dfs(curIndex + 1, preValue, nums);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
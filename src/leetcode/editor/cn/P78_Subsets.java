//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 773 👎 0


package leetcode.editor.cn;

//子集

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P78_Subsets{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
        Solution1 solution1 = new P78_Subsets().new Solution1();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.subsets(nums);
        for(List list : res){
            System.out.println(list);
        }
    }
    //迭代方法
    class Solution1{
        public List<List<Integer>> subsets(int[] nums){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for(int i = 0; i < nums.length; i++){
                int size = res.size();
                for(int j = 0; j < size; j++){
                    List<Integer> tmp = new ArrayList<>(res.get(j));//这里必须要new一下，新建一个ArrayList对象，否则只是原List的一个地址指向
                    tmp.add(nums[i]);
                    res.add(tmp);
                }
            }
            return res;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//回溯模板
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path, res);
        return res;
    }
    private void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i = begin; i < nums.length; i++){
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
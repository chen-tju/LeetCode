//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 197 👎 0


package leetcode.editor.cn;

//分割数组为连续子序列

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P659_SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P659_SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums = {1,2,3,3,4,4,5,5};
        System.out.println(solution.isPossible(nums));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> minQueMap= new HashMap<>();
        for (int num : nums) {
            if(!minQueMap.containsKey(num)){
                minQueMap.put(num, new PriorityQueue<Integer>());
            }
            if(minQueMap.containsKey(num - 1)){
                int tmp = minQueMap.get(num - 1).poll();
                if(minQueMap.get(num - 1).isEmpty()){
                    minQueMap.remove(num - 1);
                }
                minQueMap.get(num).offer(tmp + 1);
            }else{
                minQueMap.get(num).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = minQueMap.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entries) {
            PriorityQueue<Integer> value = entry.getValue();
            if(value.peek() < 3){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
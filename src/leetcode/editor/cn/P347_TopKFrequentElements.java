//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 477 👎 0


package leetcode.editor.cn;

//前 K 个高频元素    ---------堆，优先队列


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P347_TopKFrequentElements{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P347_TopKFrequentElements().new Solution();
        int[] nums = {1,1,1,2,2,3};
        int[] res = solution.topKFrequent(nums,2);
        for(int num : res){
            System.out.print(num + "、");
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> map.get(v1) - map.get(v2));
        for(Integer key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for(int num : pq){
            res[i++] = num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 754 👎 0


package leetcode.editor.cn;

//滑动窗口最大值

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P239_SlidingWindowMaximum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        Solution_deque solution1 = new P239_SlidingWindowMaximum().new Solution_deque();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = solution1.maxSlidingWindow(nums, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    class Solution_deque{//定义一个双向队列，单调队列存放元素下标
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < k; i++){
                while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = nums[deque.peekFirst()];
            for (int i = k; i < nums.length; i++) {
                while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(i);
                while(deque.peekFirst() <= i - k){
                    deque.pollFirst();
                }
                res[i - k + 1] = nums[deque.peekFirst()];
            }
            return res;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//定义一个优先队列，用大根堆的方式选出k个数字中最大的
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));
        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = pq.peek()[0];
        for(int i = k; i < nums.length; i++){
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] <= i - k){
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 83 👎 0


package leetcode.editor.cn;

//滑动窗口的最大值

import java.sql.SQLOutput;
import java.util.Deque;
import java.util.LinkedList;

public class P剑指_Offer_59_I_HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_59_I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        Solution1 solution1 = new P剑指_Offer_59_I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution1();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int n = 4;
        int[] res = solution.maxSlidingWindow(nums,k);
        int[] res1 = solution1.maxSlidingWindow(nums,n);
        for(int a : res){
            System.out.print(a + "、");
        }
        System.out.println();
        for(int b : res1){
            System.out.print(b + "、");
        }

    }
    class Solution1{
        public int[] maxSlidingWindow(int[] nums, int k){
            if(nums.length == 0 || k == 0){
                return new int[0];
            }
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 1 - k, j = 0; j < nums.length; i++,j++){
                if(i > 0 && deque.peekFirst() == nums[i-1]){
                    deque.removeFirst();
                }
                while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                    deque.removeLast();
                }
                deque.addLast(nums[j]);
                if(i >= 0){
                    res[i] = deque.peekFirst();
                }
            }
            return res;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null ||nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++){
            int max = nums[i];
            for(int j = i; j < i+k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
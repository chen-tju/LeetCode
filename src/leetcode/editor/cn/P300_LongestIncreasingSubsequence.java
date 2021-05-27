//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1622 👎 0


package leetcode.editor.cn;

//最长递增子序列

public class P300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
         // 动态规划
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
        */
        //维护一个tails数组，tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值。
        int[] tails = new int[nums.length];
        int res = 0;
       // 遍历nums数组
        for(int num : nums){
            int left = 0, right = res;
            // 二分法去查找有序的tails数组
            while(left < right){
                int mid = (left + right) >>> 1;
                if(tails[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            // 二分法确定一个左坐标，贪心思想，往里面放进去一个尽可能小的元素，才能保证递增序列尽可能长
            tails[left] = num;
            // 如果tails中的元素都小于当前num，则把num拼接到最后面---并将res指针右移一位
            if(res == right){
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

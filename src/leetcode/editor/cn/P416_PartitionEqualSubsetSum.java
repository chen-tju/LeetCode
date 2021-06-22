//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 562 👎 0


package leetcode.editor.cn;

//分割等和子集

public class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        int[] nums = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[target] != 0;
    }
//    public boolean canPartition(int[] nums) {
//        int len = nums.length;
//        if(len == 0){
//            return false;
//        }
//        int sum = 0;
//        for(int num : nums){
//            sum += num;
//        }
//        if(sum % 2 == 1){
//            return false;
//        }
//        int target = sum / 2;
//        boolean [][]dp = new boolean[len][target + 1];
//        //从nums数组中这len个数，判断是否可以组成target
//        //然后 01 判断是否选用第i个数字
//
//        //dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
//        // 是否存在一种选取方案使得被选取的正整数的和等于 j。
//        // 初始时，dp 中的全部元素都是 false。
//        //
//        for(int i = 0; i < len; i++){
//            dp[i][0] = true;
//        }
//        dp[0][nums[0]] = true;
//        for (int i = 1; i < len; i++) {
//            int num = nums[i];
//            for (int j = 1; j <= target; j++) {
//                if (j >= num) {
//                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[len - 1][target];
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
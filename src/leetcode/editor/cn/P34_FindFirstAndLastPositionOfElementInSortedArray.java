//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 750 👎 0


package leetcode.editor.cn;

//在排序数组中查找元素的第一个和最后一个位置

public class P34_FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5,7,7,8,8,10};
        int[] res = solution.searchRange(nums, 7);
        for(int a : res){
            System.out.println(a);
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//经典二分
    public int[] searchRange(int[] nums, int target) {
        int left = helper(nums, target);
        int right = helper(nums, target + 1) - 1;
        if(left == nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }
    //定义一个辅助函数，用于查找目标数值的左边界
    private int helper(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
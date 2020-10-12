//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
// 所有偶数位于数组的后半部分。
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 41 👎 0


package leetcode.editor.cn;

//调整数组顺序使奇数位于偶数前面

public class P剑指_Offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] nums = {1,2,3,4};
        int[] res = solution.exchange(nums);
        for(int num : res){
            System.out.print(num + "、");
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//双指针，头尾各一个
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            //如果左指针指向一个奇数，指针后移
            //如果右指针指向一个偶数，指针前移
            while(left < right && nums[left] % 2 == 1){
                left++;
            }
            while(left < right && nums[right] % 2 == 0){
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
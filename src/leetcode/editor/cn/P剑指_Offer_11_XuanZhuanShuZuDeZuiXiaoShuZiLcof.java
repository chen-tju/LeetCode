//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 137 👎 0


package leetcode.editor.cn;

//旋转数组的最小数字

public class P剑指_Offer_11_XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_11_XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        int[] nums = {2,2,2,0,1};
        int[] nums1 = {3,4,5,1,2};
        System.out.println(solution.minArray(nums));
        System.out.println(solution.minArray(nums1));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //很明显，这道题应该二分查找
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while(left < right){   //这里是二分的一个注意点，一般情况下都 <
            int mid = left + (right - left) / 2;
            //然后对于本题来说，要讲中间元素与右元素进行比较
            if(numbers[mid] > numbers[right]){     //如果中间元素大于右边元素的话，就说明反转点在右半边区间
                left = mid + 1;               //必然不是中间元素，所以将左边界设为mid + 1
            }else if(numbers[mid] < numbers[right]){  //如果小于右边元素，说明在左半边区间
                right = mid;    //但是还不能舍去中间元素，所以将右边界设为mid
            }else{
                right--;   //如果相等，则可能存在重复元素，又因为是有序数组反转，所以收缩右边界
            }
        }
        return numbers[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 276 👎 0


package leetcode.editor.cn;

//数组中的逆序对

public class P剑指_Offer_51_ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_51_ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }
    //利用分治思想将整个数组一直二分下去，分别对小问题进行处理，进行排序的过程中进行逆序的计算。递归
    private int merge(int[] arr, int start, int end){
        if(start >= end){
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);
        int[] tmp = new int[end - start + 1];//定义一个临时数组用于存储当前小范围数组的排序结果
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;//前后两段区间分别有序，如果arr[i] <= arr[j]的话，说明右半段区间j左边的都与arr[i]构成逆序对，个数为j-(mid+1)个
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];//将i，j指针指向的数字较小的存储到临时数组tmp
        }
        while(i <= mid){//如果左半边区间元素有剩余，说明左边的数比右半边区间的数都要大，都构成逆序对，共j - (mid+1)个
            count += j - (mid + 1);
            tmp[k++] = arr[i++];
        }
        while(j <= end){//如果右边区间有剩余，说明右边剩余元素大，不构成逆序对，只将这个数放进tmp数组即可
            tmp[k++] = arr[j++];
        }
        System.arraycopy(tmp, 0, arr, start, end - start + 1);//再将tmp数组的数覆盖原来的start到end范围
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
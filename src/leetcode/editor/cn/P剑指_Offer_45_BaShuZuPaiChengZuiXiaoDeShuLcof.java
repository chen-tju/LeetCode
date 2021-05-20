//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 170 👎 0


package leetcode.editor.cn;

//把数组排成最小的数

public class P剑指_Offer_45_BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_45_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        int[] nums = {3,30,34,5,9};
        System.out.println(solution.minNumber(nums));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//快速排序
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        fastSort(strs, 0, strs.length - 1);
        return String.join("", strs);
    }
//     private void fastSort(String[] strs, int l, int r){
//         if(l >= r){
//             return;
//         }
//         int i = l, j = r;
//         while(i < j){
//             while(i < j && (strs[l] + strs[j]).compareTo(strs[j] + strs[l]) <= 0){
//                 j--;
//             }

//             while(i < j && (strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0){
//                 i++;
//             }

//             swap(strs, i, j);
//         }
//         swap(strs, l, i);
//         fastSort(strs, l, i - 1);
//         fastSort(strs, i + 1, r);
//     }

    private void fastSort(String[] strs, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int m = patition(strs, lo, hi);
        fastSort(strs, lo, m - 1);
        fastSort(strs, m + 1, hi);
    }

    private int patition(String[] strs, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(++i <= hi && (strs[i] + strs[lo]).compareTo(strs[lo] + strs[i]) <= 0);
            while(--j >= lo && (strs[lo] + strs[j]).compareTo(strs[j] + strs[lo]) <= 0);
            if(i >= j){
                break;
            }
            swap(strs, i, j);
        }
        swap(strs, lo, j);
        return j;
    }

    private void swap(String[] strs, int i, int j){
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
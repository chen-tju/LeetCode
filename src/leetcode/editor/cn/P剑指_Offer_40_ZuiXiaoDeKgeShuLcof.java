//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 126 👎 0


package leetcode.editor.cn;

//最小的k个数         --------经典题，标准快排+堆

import java.util.Arrays;
import java.util.PriorityQueue;

public class P剑指_Offer_40_ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_40_ZuiXiaoDeKgeShuLcof().new Solution();
        Solution1 solution1 = new P剑指_Offer_40_ZuiXiaoDeKgeShuLcof().new Solution1();
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int[] res = solution1.getLeastNumbers(arr, 5);
        for(int n : res){
            System.out.print(n + "、");
        }
    }
    //堆
    class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if(arr.length == 0 || k == 0){
                return new int[0];
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> (o2 - o1));
            for(int num : arr){
                if(pq.size() < k){
                    pq.add(num);
                }else if(num < pq.peek()){
                    pq.remove();
                    pq.add(num);
                }
            }
            int[] res = new int[k];
            int i = 0;
            for(int tmp : pq){
                res[i++] = tmp;
            }
            return res;
        }
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//标准快排
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length-1, k-1);//
    }
    //k是下标
    private int[] quickSearch(int[] nums,int lo, int hi, int k){
        int m = partition(nums, lo, hi);
        if(m == k){
            return Arrays.copyOf(nums, k+1);// k+1是长度
        }
        return m > k ? quickSearch(nums, lo, m-1, k) : quickSearch(nums, m+1, hi, k);
    }
    //这里是使得返回一个坐标，小的都在左边，大的都在右边
    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(++i <= hi && nums[i] < nums[lo]);
            while(--j >= lo && nums[j] > nums[lo]);
            if(i >= j){
                break;
            }
            //然后交换 i 与 j 所指向的位置
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        //再交换j与开头的位置
        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
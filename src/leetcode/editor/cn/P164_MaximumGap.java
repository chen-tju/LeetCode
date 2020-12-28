//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。 
//
// 如果数组元素个数小于 2，则返回 0。 
//
// 示例 1: 
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 
//
// 示例 2: 
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。 
//
// 说明: 
//
// 
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 
// 
// Related Topics 排序 
// 👍 282 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最大间距
public class P164_MaximumGap{
    public static void main(String[] args) {
        //测试代码
        Solution1 solution = new P164_MaximumGap().new Solution1();
        int[] nums = {3,6,9,1};
        System.out.println(solution.maximumGap(nums));
    }
    class Solution1 {
        public int maximumGap(int[] nums) {
            if(nums.length < 2){
                return 0;
            }
            long exp = 1;
            int[] buf = new int[nums.length];
            int max = Arrays.stream(nums).max().getAsInt();

            while(max >= exp){
                int[] cnt = new int[10];
                for(int i = 0; i < nums.length; i++){
                    int digit = (nums[i] / (int)exp) % 10;
                    cnt[digit]++;
                }
                for(int i = 1; i < 10; i++){
                    cnt[i] += cnt[i-1];
                }
                for(int i = nums.length - 1; i >= 0; i--){
                    int digit = (nums[i] / (int)exp) % 10;
                    buf[cnt[digit] - 1] = nums[i];
                    cnt[digit]--;
                }
                System.arraycopy(buf, 0, nums, 0, nums.length);
                exp *= 10;
            }
            int res = 0;
            for(int i = 1; i < nums.length; i++){
                res = Math.max(res, nums[i] - nums[i-1]);
            }
            return res;
        }
    }



    //力扣代码-
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (max - min) / (nums.length - 1));
        int size = (max - min) / d + 1;

        int[][] bucket = new int[size][2];//定义一个桶，用于存放（桶内的最大值和最小值）
        for(int i = 0; i < size; i++){
            Arrays.fill(bucket[i], -1);
        }
        for(int i = 0; i < nums.length; i++){
            int idx = (nums[i] - min) / d;
            if(bucket[idx][0] == -1){
                bucket[idx][0] = bucket[idx][1] = nums[i];
            }else{
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        int res = 0;
        int pre = -1;
        for(int i = 0; i < size; i++){
            if(bucket[i][0] == -1){
                continue;
            }
            if(pre != -1){
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 134 👎 0


package leetcode.editor.cn;

//数组中的最长山脉

public class P845_LongestMountainInArray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P845_LongestMountainInArray().new Solution();
        int[] A = {2,1,4,7,7,3,2,5};
        System.out.println(solution.longestMountain(A));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] A) {
        int max = 0, i = 1;
        while(i < A.length){
            int in = 0, de = 0;
            while(i < A.length && A[i-1] < A[i]){
                i++;
                in++;
            }
            while(i < A.length && A[i-1] > A[i]){
                i++;
                de++;
            }
            while(i < A.length && A[i] == A[i-1]){
                i++;
            }
            if(in > 0 && de > 0) {
                max = Math.max(max, in + de + 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
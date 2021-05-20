//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 319 👎 0


package leetcode.editor.cn;

//螺旋矩阵 II

public class P59_SpiralMatrixIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P59_SpiralMatrixIi().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1, idx = 1;
        while(idx <= n * n){
            for(int i = l; i <= r; i++){
                res[t][i] = idx++;
            }
            t++;
            for(int i = t; i <= b; i++){
                res[i][r] = idx++;
            }
            r--;
            for(int i = r; i >= l; i--){
                res[b][i] = idx++;
            }
            b--;
            for(int i = b; i >= t; i--){
                res[i][l] = idx++;
            }
            l++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 714 👎 0


package leetcode.editor.cn;

//螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P54_SpiralMatrix().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int k = 0, num = (Math.min(m, n) + 1) / 2;

        while(k < num){
            for(int i = k; i < n - k; i++){
                res.add(matrix[k][i]);
            }
            for(int i = k + 1; i < m - k; i++){
                res.add(matrix[i][n - 1 - k]);
            }
            for(int i = n - 1 - k - 1; i >= k && m - 1 - k != k; i--){
                res.add(matrix[m - 1 - k][i]);
            }
            for(int i = m - 1 - k - 1; i > k && n - 1 - k != k; i--){
                res.add(matrix[i][k]);
            }
            k++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
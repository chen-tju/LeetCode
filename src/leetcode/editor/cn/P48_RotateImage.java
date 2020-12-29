//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 726 👎 0


package leetcode.editor.cn;

//旋转图像

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P48_RotateImage{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P48_RotateImage().new Solution();
    }
    //直接在循环中定义一个一维数组，四个数字之间进行替换
    class Solution2{
        public void rotate(int[][] matrix){
            int n = matrix.length;
            for(int i = 0; i < (n + 1) / 2; i++){
                for(int j = 0; j < n / 2; j++){
                    int[] tmp = new int[4];
                    int row = i, col = j;
                    for(int k = 0; k < 4; k++){
                        tmp[k] = matrix[row][col];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                    for(int k = 0; k < 4; k++){
                        matrix[i][j] = tmp[(k + 3) % 4];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                }
            }
        }

    }

    //直接对数组进行对折，然后对每一行再进行对折
    class Solution1{
        public void rotate(int[][] matrix){
            int n = matrix.length;
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n / 2; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = tmp;
                }
            }
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    //直接对左上角的每个数进行旋转。每四个数进行一个循环赋值，规律比较难写
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n+1) / 2; i++){
            for(int j = 0; j < n / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
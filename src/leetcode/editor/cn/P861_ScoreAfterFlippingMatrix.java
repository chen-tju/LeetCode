//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 146 👎 0


package leetcode.editor.cn;

//翻转矩阵后的得分

public class P861_ScoreAfterFlippingMatrix{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P861_ScoreAfterFlippingMatrix().new Solution();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(solution.matrixScore(A));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//贪心算法
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = m * (1 << (n - 1));

        for(int j = 1; j < n; j++){
            int count = 0;
            for(int i = 0; i < m; i++){
                if(A[i][0] == 1){
                    count += A[i][j];
                }else{
                    count += (1 - A[i][j]);
                }
            }
            int k = Math.max(count, (m - count));
            res += k * (1 << (n - j - 1));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
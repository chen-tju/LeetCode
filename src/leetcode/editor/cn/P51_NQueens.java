//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 637 👎 0


package leetcode.editor.cn;

//N 皇后

import java.util.ArrayList;
import java.util.List;

public class P51_NQueens{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        for(List list : res){
            System.out.println(list);
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    //经典回溯框架
    //因为皇后肯定是一行一个，所以从上到下进行回溯
    private void solve(List<List<String>> res, char[][] chess, int row){
        if(row == chess.length){//如果当前行已经过了chess的边界长度
            res.add(construct(chess));//就将当前数组添加到结果集中
            return;
        }
        for(int col = 0; col < chess.length; col++){
            if(valid(chess, row, col)){
                chess[row][col] = 'Q';
                solve(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    //定义一个辅助函数，用于判断当前坐标是否可以放皇后
    //因为是按照行从上往下进行回溯，这里只需要根据当前坐标的上面的行进行判断
    private boolean valid(char[][] chess, int row, int col){
        for(int i = 0; i < row; i++){
            //如果这一列上有皇后，那么这个坐标不能放皇后
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //判断当前坐标的右上方斜线有没有皇后
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        //判断当前坐标的左上方斜线有没有皇后
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    //定义一个辅助函数，用于将数组转换成list
    //将一个二维的char数组，按行转换成String动态数组list
    private List<String> construct(char[][] chess){
        List<String> path = new ArrayList<>();
        for(int i = 0; i < chess.length; i++){
            path.add(new String(chess[i]));
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
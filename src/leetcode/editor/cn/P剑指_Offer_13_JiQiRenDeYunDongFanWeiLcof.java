//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 143 👎 0


package leetcode.editor.cn;

//机器人的运动范围

import java.util.LinkedList;
import java.util.Queue;

public class P剑指_Offer_13_JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_13_JiQiRenDeYunDongFanWeiLcof().new Solution();
        Solution_DFS solution1 = new P剑指_Offer_13_JiQiRenDeYunDongFanWeiLcof().new Solution_DFS();
        Solution_BFS solution2 = new P剑指_Offer_13_JiQiRenDeYunDongFanWeiLcof().new Solution_BFS();
        System.out.println(solution.movingCount(2,3,1));
        System.out.println(solution1.movingCount(2,3,1));
        System.out.println(solution2.movingCount(2,3,1));

    }
    class Solution_BFS{
        public int movingCount(int m, int n, int k){
            int res = 0;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while(queue.size() > 0){
                int[] tmp = queue.poll();
                int i = tmp[0], j = tmp[1];
                if(i >= m || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]){
                    continue;
                }
                res++;
                visited[i][j] = true;
                queue.add(new int[]{i+1,j});
                queue.add(new int[]{i,j+1});
            }
            return res;
        }
    }
    class Solution_DFS{
        public int movingCount(int m, int n, int k){
            boolean[][] visited = new boolean[m][n];
            return dfs(0,0,m,n,k,visited);
        }
        private int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
            if(i >= m || j >= n || (i%10 + i/10 + j%10 + j/10) > k || visited[i][j]){
                return 0;
            }
            visited[i][j] = true;
            return 1 + dfs(i+1,j,m,n,k,visited) + dfs(i,j+1,m,n,k,visited);
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        int res = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i/10 + i%10 + j/10 + j%10) <= k && ((i-1>=0 && visited[i-1][j] == 1) || (i+1 < m && visited[i+1][j] == 1) || (j-1 >= 0 && visited[i][j-1] == 1) || (j + 1 < n && visited[i][j+1] == 1))){
                    res++;
                    visited[i][j] = 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 165 👎 0


package leetcode.editor.cn;

//最小体力消耗路径

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1631_PathWithMinimumEffort{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1631_PathWithMinimumEffort().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        //新建一个集合，存放各边的权值
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int id = i * cols + j;
                if(i < rows - 1){
                    edges.add(new int[]{id, id + cols, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                if(j < cols - 1){
                    edges.add(new int[]{id, id + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        //根据权值对各边进行排序
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        //new一个并查集，存放每一条路径
        UnionFind uf = new UnionFind(rows * cols);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
            if(uf.find(0) == uf.find(rows * cols - 1)){
                return edge[2];
            }
        }
        return 0;
    }
    class UnionFind{
        int[] parent;
        int count;

        public UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int idx){
            if(idx != parent[idx]){
                parent[idx] = find(parent[idx]);
            }
            return parent[idx];
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
        public int getCount(){
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 422 👎 0


package leetcode.editor.cn;

//省份数量

import java.util.Arrays;

public class P547_NumberOfProvinces{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P547_NumberOfProvinces().new Solution();
        int[][] nums = {{1,0,0,1}, {0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(solution.findCircleNum(nums));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //并查集，我会做
        //只判断二维数组的一半，城市本身和自己是相连的
        int[] parent = new int[isConnected.length];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = i + 1; j < isConnected.length; j++){
                if(isConnected[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                res++;
            }
        }
        return res;
    }

    private void union(int[] parent, int idx1, int idx2){
        parent[find(parent, idx1)] = find(parent, idx2);
    }
//    private int find(int[] parent, int idx){
//        if(parent[idx] != idx){
//            parent[idx] = parent[find(parent, idx)];
//        }
//        return parent[idx];
//    }

    private int find(int[] parent, int idx){
        while(parent[idx] != idx){
//            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。 
//
// 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。 
//
// 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//输出：5
//解释：一种移除 5 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
//2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
//3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
//4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
//5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
//石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。 
//
// 示例 2： 
//
// 
//输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//输出：3
//解释：一种移除 3 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
//2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
//3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
//石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。 
//
// 示例 3： 
//
// 
//输入：stones = [[0,0]]
//输出：0
//解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= xi, yi <= 104 
// 不会有两块石头放在同一个坐标点上 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 183 👎 0


package leetcode.editor.cn;

//移除最多的同行或同列石头

import java.util.ArrayList;
import java.util.List;

public class P947_MostStonesRemovedWithSameRowOrColumn{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P947_MostStonesRemovedWithSameRowOrColumn().new Solution();
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(solution.removeStones(stones));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeStones(int[][] stones) {
        //首先进行建图
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < stones.length; i++){
            edges.add(new ArrayList<Integer>());
            for(int j = 0; j < stones.length; j++){//两次遍历，如果两块石头的横坐标或者纵坐标相等，就将j石头的坐标加进i石头所在的list
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    edges.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[stones.length];
        int count = 0;
        for(int i = 0; i < stones.length; i++){
            if(!visited[i]){
                count++;
                dfs(edges, i,  visited);
            }
        }
        return stones.length - count;
    }
    private void dfs(List<List<Integer>>edges, int x, boolean[] visited){
        visited[x] = true;
        for(int y : edges.get(x)){
            if(!visited[y]){
                dfs(edges, y, visited);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
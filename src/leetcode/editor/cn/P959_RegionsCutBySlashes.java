//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 174 👎 0


package leetcode.editor.cn;

//由斜杠划分区域
//并查集----二维转一维
public class P959_RegionsCutBySlashes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P959_RegionsCutBySlashes().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);

        for(int i = 0; i < n; i++){
            char[] row = grid[i].toCharArray();

            for(int j = 0; j < n; j++){
                char c = row[j];
                int idx = 4 * (i * n + j);
                //组内合并
                if(c == '/'){
                    uf.union(idx, idx + 3);
                    uf.union(idx + 1, idx + 2);
                }else if(c == '\\'){
                    uf.union(idx, idx + 1);
                    uf.union(idx + 2, idx + 3);
                }else{
                    uf.union(idx, idx + 1);
                    uf.union(idx + 1, idx + 2);
                    uf.union(idx + 2, idx + 3);
                }
                //组间合并
                if(j + 1 < n){
                    uf.union(idx, 4 * (i * n + j + 1) + 3);
                }
                if(i + 1 < n){
                    uf.union(idx + 2, 4 * ((i + 1) * n + j));
                }
            }
        }
        return uf.getCount();
    }
    class UnionFind{
        private int[] parent;
        private int count;

        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int idx){
            while(idx != parent[idx]){
                idx = parent[idx];
            }
            return idx;
        }
        private void union(int idx1, int idx2){
            if(find(idx1) == find(idx2)){
                return;
            }
            parent[find(idx1)] = find(idx2);
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
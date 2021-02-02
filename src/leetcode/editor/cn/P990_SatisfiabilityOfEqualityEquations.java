//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
// 
//
// 示例 2： 
//
// 输入：["b==a","a==b"]
//输出：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
// 
//
// 示例 3： 
//
// 输入：["a==b","b==c","a==c"]
//输出：true
// 
//
// 示例 4： 
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
// 
//
// 示例 5： 
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] 和 equations[i][3] 是小写字母 
// equations[i][1] 要么是 '='，要么是 '!' 
// equations[i][2] 是 '=' 
// 
// Related Topics 并查集 图 
// 👍 139 👎 0


package leetcode.editor.cn;

//等式方程的可满足性

public class P990_SatisfiabilityOfEqualityEquations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P990_SatisfiabilityOfEqualityEquations().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//并查集问题
        /***
         * 使用一个数组 parent 存储每个变量的连通分量信息，其中的每个元素表示当前变量所在的连通分量的父节点信息，
         * 如果父节点是自身，说明该变量为所在的连通分量的根节点。一开始所有变量的父节点都是它们自身。
         * 对于合并操作，我们将第一个变量的根节点的父节点指向第二个变量的根节点；
         * 对于查找操作，我们沿着当前变量的父节点一路向上查找，直到找到根节点。
         *
         * */
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];//定义一个数组，用于存放每个变量的联通分量信息
        for(int i = 0; i < 26; i++){//初始化数组，每个变量的父节点都是自身
            parent[i] = i;
        }
        for (String equation : equations) {//根据相等关系，建立一个并查集
            if(equation.charAt(1) == '='){
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                union(parent, idx1, idx2);
            }
        }
        for (String equation : equations) {//不等关系的父节点就返回一个false
            if(equation.charAt(1) == '!') {
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                if (find(parent, idx1) == find(parent, idx2)) {
                    return false;
                }
            }
        }
        return true;
    }
    //定义一个union方法，进行合并操作，将第一个变量的根节点的父节点指向第二个变量的根节点
    private void union(int[] parent, int idx1, int idx2) {
        parent[find(parent, idx1)] = find(parent, idx2);
    }

    //定义一个find方法，进行查找操作，沿着父节点的根节点向上查找，找到根节点
    private int find(int[] parent, int idx){
        while(parent[idx] != idx){//当索引的父节点不等于自身的时候，就迭代向上查询
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，
// 分别表示向北、向南、向东、向西移动一个单位。
//
// 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。 
//
// 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：path = "NES"
//输出：false 
//解释：该路径没有在任何位置相交。 
//
// 示例 2： 
//
// 
//
// 输入：path = "NESWW"
//输出：true
//解释：该路径经过原点两次。 
//
// 
//
// 提示： 
//
// 
// 1 <= path.length <= 10^4 
// path 仅由 {'N', 'S', 'E', 'W} 中的字符组成 
// 
// Related Topics 字符串 
// 👍 12 👎 0


package leetcode.editor.cn;

//判断路径是否相交

import java.util.HashSet;
import java.util.Set;

public class P1496_PathCrossing{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1496_PathCrossing().new Solution();
        String path = "NESWW";
        System.out.println(solution.isPathCrossing(path));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//定义一个HashSet用于存储坐标
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
//        Set<int[]> set = new HashSet<>();
//        set.add(new int[]{x,y});
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for(int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if(c == 'N'){
                y++;
            }
            if(c == 'S'){
                y--;
            }
            if(c == 'E'){
                x++;
            }
            if(c == 'W'){
                x--;
            }
            if(set.contains(x + "," + y)){
                return true;
            }else {
                set.add(x + "," + y);
            }
//            if(set.contains(new int[]{x,y})){
//                return true;
//            }else{
//                set.add(new int[]{x, y});
//            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
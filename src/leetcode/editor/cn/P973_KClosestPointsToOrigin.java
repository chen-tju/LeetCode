//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 175 👎 0


package leetcode.editor.cn;

//最接近原点的 K 个点

import java.util.PriorityQueue;

public class P973_KClosestPointsToOrigin{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P973_KClosestPointsToOrigin().new Solution();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] res = solution.kClosest(points, K);
        for(int[] tmp : res){
            for(int j : tmp){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//前K小问题--使用大根堆，构建一个容量为K的大根堆
    public int[][] kClosest(int[][] points, int K) {
        if(points.length == 0 || K == 0){
            return new int[0][];
        }
        //默认是小根堆，改写为大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((o2,o1) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        for(int[] point : points){
            if(pq.size() < K){
                pq.add(point);
                //否则，判断当前点的距离是否小于堆中的最大距离，若是，则将堆中最大距离poll出，将当前点加入堆中。
            }else if(pq.comparator().compare(point, pq.peek()) > 0){//如果堆顶元素大于point，则替换
                pq.remove();
                pq.add(point);
            }
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        for(int[] tmp : pq){
            res[i++] = tmp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
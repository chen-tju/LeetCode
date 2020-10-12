//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 104 👎 0


package leetcode.editor.cn;

//用两个栈实现队列

import java.util.LinkedList;

public class P剑指_Offer_09_YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {
        //测试代码
        CQueue solution = new P剑指_Offer_09_YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
        //使用LinkedList实现栈，因为栈是后入先出，所以只使用addLast和removeLast
    LinkedList<Integer> stack1, stack2;
    public CQueue() {
        //stack1表示数据栈，使用另一个表示辅助栈
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void appendTail(int value) {
        stack1.addLast(value);
    }
    //思想就是，在删除头元素的时候，将数据栈中的所有元素全部放到辅助栈中，利用先进后出的性质进行删去头元素的实现
    public int deleteHead() {
        //如果辅助栈中有元素，则说明之前的元素还没有删完
        if(!stack2.isEmpty()){
            return stack2.removeLast();
        }
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.addLast(stack1.removeLast());
        }
        return stack2.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 93 👎 0


package leetcode.editor.cn;

//反转链表

public class P剑指_Offer_24_FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_24_FanZhuanLianBiaoLcof().new Solution();
    }

    class Solution1{//递归方法， 相对抽象一些
        public ListNode reverseList(ListNode head){
            if(head ==null || head.next == null){
                return head; //这里是递归的出口
            }
            ListNode p = reverseList(head.next);//从head的下一个节点开始反转
            head.next.next = head;//这里使head的下一个节点指向head，完成这个节点的反转
            head.next = null; //然后再断开head指向head.next的这个环
            return p;//结束本次递归，返回反转的节点
        }
    }

//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.*/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {//迭代方法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
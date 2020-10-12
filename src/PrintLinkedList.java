public class PrintLinkedList {
    public static void main(String[] args){
        int[] x = {1,2,3,4,5,6};
        ListNode list = createLinkedList(x);
        printLinkedList(list);
    }
    //将输入的数组输入到链表中
    private static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {//过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    //将链表结果打印
    private static void printLinkedList(ListNode head){
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}

//Leetcode中链表的定义
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


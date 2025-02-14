package easy;

import base.ListNode;

public class Q019_removeEndNthListNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);//case：[1] 1 返回[]，因此借用虚拟节点
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) { //注意这里是需要slow同步遍历待删除节点前一个
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}

package easy;

import base.ListNode;

/**
 * @author: xcai
 * @date: 2024/05/27
 * @see <a href=''>Conf<a/>
 * <p>
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [2,4,7,8], cnt = 1
 * 输出：8
 */
public class QL140_kNodeFromEnd {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode l1 = head, l2 = head;
        for (int i = 0; i < cnt; i++) {
            l1 = l1.next;
        }
        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
    }
}

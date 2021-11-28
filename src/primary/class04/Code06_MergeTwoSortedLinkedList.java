package primary.class04;

/**
 * @author xt
 * @Desc 两个有序链表的合并
 *
 * 给定两个有序链表的头节点head1和head2，
 * 返回合并之后的大链表，要求依然有序
 * 例子     1 -> 3 -> 3 -> 5 -> 7          2 -> 2 -> 3 -> 3-> 7
 * 返回     1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
 */
// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code06_MergeTwoSortedLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode cur = head;
        while (cur2 != null && cur1 != null) {
            if (cur2.val <= cur1.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 != null ?  cur1 : cur2;
        return head;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        ListNode node = mergeTwoLists(node11, node21);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}

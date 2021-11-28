package primary.class04;

/**
 * @author xt
 * @Desc 两个链表相加
 * <p>
 * 给定两个链表的头节点l和s，
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子     4 -> 3 -> 6        2 -> 5 -> 3
 * 返回     6 -> 8 -> 9
 * 解释     634 + 352 = 986
 */
// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class Code05_AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = listLength(l1);
        int len2 = listLength(l2);
        ListNode l = len1 >= len2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0; // 进位
        int curNum = 0;
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    // 求链表长度
    private int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}

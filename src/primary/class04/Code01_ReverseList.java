package primary.class04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc 单双链表的反转
 *
 * 经典题目
 * 给定一个单链表的头head，完成链表的逆序调整
 * 给定一个双链表的头head，完成链表的逆序调整
 */
public class Code01_ReverseList {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

     public static class DoubleNode {
        private int value;
        private DoubleNode last;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

     }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node testReverseLinkedList(Node head) {
        if (head == null) return null;
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    public static DoubleNode testReverseDoubleLinkedList(DoubleNode head) {
        if (head == null) return null;
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }

    // for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int)(Math.random() * (len + 1));
        if (size == 0) return null;
        size--;
        Node head = new Node((int)(Math.random() * (value + 1)) - (int)(Math.random() * value));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int)(Math.random() * (value + 1)) - (int)(Math.random() * value));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int)(Math.random() * (len + 1));
        if (size == 0) return null;
        size--;
        DoubleNode head = new DoubleNode((int)(Math.random() * (value + 1)) - (int)(Math.random() * value));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int)(Math.random() * (value + 1)) - (int)(Math.random() * value));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        if (origin.size() == 0 && head == null) {
            return true;
        }
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (head.value != origin.get(i)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        if (origin.size() == 0 && head == null) {
            return true;
        }
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (origin.get(i) != head.value) {
                return false;
            }
            end = head;
            head = head.next;

        }
        for (int i = 0; i < origin.size(); i++) {
            if (origin.get(i) != end.value) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxLen = 50;
        int maxValue = 100;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(maxLen, maxValue);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1");
            }

            Node node2 = generateRandomLinkedList(maxLen, maxValue);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = testReverseLinkedList(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2");
            }

            DoubleNode node3 = generateRandomDoubleList(maxLen, maxValue);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3");
            }

            DoubleNode node4 = generateRandomDoubleList(maxLen, maxValue);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = testReverseDoubleLinkedList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4");
            }
        }
        System.out.println("test end!");
    }
}

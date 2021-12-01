package basic.class03;

import java.util.Stack;

/**
 * @author xt
 * @Desc 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * 2）设计的栈类型可以使用现成的栈结构。
 * 最小栈，加入的值比之前大，入栈之前小的值。
 */
public class Code05_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value <= getMin()){
                stackMin.push(value);
            }
            stackData.push(value);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("队列已空，不能拿取数据");
            }
            int ans = stackData.pop();
            if (ans == getMin()) {
                stackMin.pop();
            }
            return ans;
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("队列已空，不能拿取数据");
            }
            return stackMin.peek();
        }
    }
    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value < getMin()){
                stackMin.push(value);
            } else {
                int val = stackMin.peek();
                stackMin.push(val);
            }
            stackData.push(value);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("队列已空，不能拿取数据");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("队列已空，不能拿取数据");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}

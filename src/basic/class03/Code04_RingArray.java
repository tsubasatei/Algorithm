package basic.class03;

/**
 * @author xt
 * @Desc 用数组实现不超过固定大小的队列和栈
 */
public class Code04_RingArray {
    public static class MyQueue {
        public int[] arr;
        public final int limit;
        public int size;
        public int pushi;
        public int polli;

        public MyQueue(int limit) {
            this.limit = limit;
            arr = new int[limit];
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }
}

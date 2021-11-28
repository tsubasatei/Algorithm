package primary.class06;

/**
 * @author xt
 * @Desc 判断两颗树是否结构相同
 */
// 测试链接：https://leetcode.com/problems/same-tree
public class Code05_SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) return false;
        if (p == null && q == null) return true;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        node11.left = node12;
        node11.right = node13;
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        node21.left = node22;
        node21.right = node23;
        System.out.println(isSameTree(node11, node21));
    }
}

package primary.class06;

/**
 * @author xt
 * @Desc 二叉树 先序、中序、后序遍历
 */
public class Code04_TraversalBinaryTree {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        pre(root.left);
        pre(root.right);
    }

    public static void in(TreeNode root) {
        if (root == null) {
            return;
        }
        in(root.left);
        System.out.print(root.value + " ");
        in(root.right);
    }

    public static void pos(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        pos(root.left);
        pos(root.right);
    }

    public static void f(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 先序
        f(root.left);
        // 2. 中序
        f(root.right);
        // 3. 中序
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node1.left.left = node4;
        node1.left.right = node5;
        node1.right.left = node6;
        node1.right.right = node7;

        System.out.println("先序遍历：");
        pre(node1);
        System.out.println();
        System.out.println("中序遍历：");
        in(node1);
        System.out.println();
        System.out.println("后序遍历：");
        pos(node1);
    }
}

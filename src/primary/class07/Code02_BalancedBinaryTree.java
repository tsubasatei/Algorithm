package primary.class07;

/**
 * @author xt
 * @Desc 判断是否是平衡搜索二叉树
 * 平衡二叉树：每一颗子树平衡 且 |左高 – 右高| <= 1
 * 搜索树：左树比节点小，右树比节点大
 * 中序遍历严格递增就是搜索二叉树
 */
// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalancedBinaryTree {

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode root) {
        if (root == null) return new Info(true, 0);
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(rightInfo.height - leftInfo.height) < 2;
        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
//        [1,2,2,3,3,null,null,4,4]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.right = new TreeNode(2);
//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(3);
//        node.left.left.left = new TreeNode(4);
//        node.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(node));
    }
}

package primary.class06;

/**
 * @author xt
 * @Desc  返回一棵树的最大深度
 */
// 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
public class Code07_MaximumDepthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

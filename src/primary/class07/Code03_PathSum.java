package primary.class07;

/**
 * @author xt
 * @Desc 能否组成路径和
 */
// 测试链接：https://leetcode.com/problems/path-sum
public class Code03_PathSum {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

//    public static boolean isSum = false;
//
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        isSum = false;
//        process(root, 0, targetSum);
//        return isSum;
//    }
//
//    public void process(TreeNode root, int preSum, int sum) {
//        if (root.left == null && root.right == null) {
//            if (root.val + preSum == sum) {
//                isSum = true;
//            }
//            return;
//        }
//        // x是非叶节点
//        preSum += root.val;
//        if (root.left != null) {
//            process(root.left, preSum, sum);
//        }
//        if (root.right != null) {
//            process(root.right, preSum, sum);
//        }
//    }

    public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return process(root, sum);
	}

	public static boolean process(TreeNode root, int rest) {
		if (root.left == null && root.right == null) {
			return root.val == rest;
		}
        // 有一个为真即可
		boolean ans = root.left != null ? process(root.left, rest - root.val) : false;
		ans |= root.right != null ? process(root.right, rest - root.val) : false;
		return ans;
	}
}

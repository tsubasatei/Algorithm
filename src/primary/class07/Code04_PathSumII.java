package primary.class07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc  收集达标路径和
 */
// 测试链接：https://leetcode.com/problems/path-sum-ii
public class Code04_PathSumII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, targetSum, ans);
        return ans;
    }

    private void process(TreeNode root, List<Integer> path, int prevSum, int sum, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (root.val + prevSum == sum) {
                path.add(root.val);
                ans.add(0, copyPath(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        prevSum += root.val;
        path.add(root.val);
        if (root.left != null) {
            process(root.left, path, prevSum, sum, ans);
        }
        if (root.right != null) {
            process(root.right, path, prevSum, sum, ans);
        }
        path.remove(path.size() - 1);
    }

    private List<Integer> copyPath(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }
}

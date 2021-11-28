package primary.class06;

import java.util.HashMap;

/**
 * @author xt
 * @Desc 用先序数组和中序数组重建一棵树
 */
//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class Code08_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    private TreeNode f(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) {
        if (L1 > R1) return null;
        TreeNode head = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (inorder[find] != preorder[L1]) {
            find++;
        }
        head.left = f(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1);
        head.right = f(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2);
        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    private TreeNode f(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) return null;
        TreeNode head = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = valueIndexMap.get(preorder[L1]);
        head.left = f(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1, valueIndexMap);
        head.right = f(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2, valueIndexMap);
        return head;
    }
}

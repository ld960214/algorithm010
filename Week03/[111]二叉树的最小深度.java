//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
当 root 节点左右孩子都为空时，返回 1
当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 这道题递归条件里分为三种情况
        // 1. 左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null ) return 1;
        // 2. 如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
         int m1 = minDepth(root.left);
         int m2 = minDepth(root.right);
         // 这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1+m2+1；
        if (root.left == null || root.right == null) return m1+m2+1;

        // 3. 最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1, m2) + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

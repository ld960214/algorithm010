//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


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

// 递归 深度就是左右子树的最大深度加一
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        } else {
            int left_hight = maxDepth(root.left);
            int right_hight = maxDepth(root.right);
            return java.lang.Math.max(left_hight,right_hight) + 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 法一： 递归
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    public void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//        }
//    }
//
//}


// 法二：基于栈的遍历
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); // 左遍历到头了，可以出栈了
            res.add(curr.val); // 加到结果list中
            curr = curr.right; // 然后到又节点
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

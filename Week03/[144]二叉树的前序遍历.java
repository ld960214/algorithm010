//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)



import java.util.ArrayList;
import java.util.List;
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
// 法一： 使用递归
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        helper(root, res);
//        return res;
//    }
//
//    public void helper(TreeNode root, List res) {
//        if (root != null) {
//            res.add(root.val);
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//        }
//
//    }
//}

// 栈  迭代法  口诀： push，向左，pop 向右

class Solution {
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null ) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

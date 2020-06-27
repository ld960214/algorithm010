//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
递归版解题思路：

        参考二叉树的递归遍历方式：先遍历根节点，然后递归遍历左子树，再递归遍历右子树。
        二N叉树的前序遍历就是先遍历根节点，然后依次递归遍历每个子树。
        时间复杂度O（N）,空间复杂度O（N）
 */
//class Solution {
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> preorder(Node root) {
//        if (root == null) {
//            return res;
//        }
//        res.add(root.val);
//        for(Node child: root.children) {
//            preorder(child);
//        }
//
//        return res;
//
//    }
//}

/*
非递归版解题思路：

二叉树的非递归遍历是每次将当前结点右孩子节点和左孩子节点依次压入栈中，注意是先右后左。
然后将出栈节点输出，并且在将其右子节点和左子节点压入栈中。
推广到N叉树，就是将当前结点的孩子节点由右到左依次压入栈中。
然后将出栈节点输出，并且将其孩子节点依次压入栈中。
时间复杂度O（N），空间复杂度O（N）
 */

class Solution {
    public List<Integer> preorder(Node root) {
        // 非递归版
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null)
            return res;
        stack.push(root);
        while ( !stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

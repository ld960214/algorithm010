//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
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

// 法一： 递归
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res  =  new ArrayList<Integer>();
        if(root == null) return res;
        for(Node cur:root.children){
            res.addAll(postorder(cur));
        }
        res.add(root.val);
        return res;
    }
}

// 法二：迭代法


//leetcode submit region end(Prohibit modification and deletion)

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

// 左括号随时可以＋，只要别超过n
// 右括号 必须之前有左括号，且 左个数>右个数
class Solution {
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n, ""); //进行到第0个位置了，一共有左右都不能超过n个位置
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            // filter the invalid s
            result.add(s);
            return;
        }

        // process current logic:left, right

        // drill down
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if(left > right)  {
            _generate(left, right + 1, n,s + ")");
        }

        // reverse states
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
// 从后往前贪心
//class Solution {
//    public boolean canJump(int[] nums) {
//        if (nums == null) {
//            return false;
//        }
//        int endReachable = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] + i >= endReachable) {
//                endReachable = i;
//            }
//        }
//        return endReachable == 0;
//
//    }
//}

// 普通解法
class Solution{
    public boolean canJump(int[] A) {
        int reach = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if(i > reach) {
                return  false;
            }
            reach = Math.max(i + A[i], reach);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

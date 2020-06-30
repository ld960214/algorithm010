//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
// 贪心 反向查找出发位置
// 有多个位置通过跳跃都能够到达最后一个位置，怎么选择？贪心的选择距离最后一个位置最远的那个位置，也就是
// 对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
// 找到最后一步跳跃前所在的位置之后， 我们继续贪心地找倒数第二步跳跃前所在地位置，
// 以此类推，直到找到数组最开始地位置。
class Solution {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) { // 从左到右遍历数组，选择第一个满足条件地位置
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

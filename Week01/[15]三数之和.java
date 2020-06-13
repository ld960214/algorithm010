//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
// a + b = -c(targrt) 先进行排序
// 用双指针进行左右夹逼 k为枚举索引，i,j为两个指针。i指向k后的第一个，j指向最后一个
// 如果i值j值k值和小于零的话，左指针向右移动，如果大于的话，右指针向左移动。等于说明找到了，k就向右挪动
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < nums.length -2; k++) {
            // 大于零的话，表示从开始就不行
            if (nums[k] > 0) break;
            // 没有这一行可能出错[0,0,0,0] 测试结果[[0,0,0][0,0,0]], 期望结果[0,0,0]
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }

            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

//第一种方法：暴力两重循环 第一重循环是k, 第二重循环是n
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public void rotate(int[] nums, int k) {
//        int temp, previous;
//        for (int i = 0; i < k; i++){
//            previous = nums[nums.length - 1];
//            for(int j = 0; j < nums.length; j++) {
//                temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

// 第二种方法： 使用额外的数组，原本数组下标为i的我们把它放到（i+k）% length的位置，然后把新的数组拷贝到原数组中
//class Solution {
//    public void rotate(int[] nums, int k) {
//        int[] a = new int[nums.length];
//        for(int i = 0; i < nums.length; i++)
//            a[(i + k) % nums.length] = nums[i];
//
//        for (int j = 0; j < nums.length; j++) {
//            nums[j] = a[j];
//        }
//
//    }
//}

// 使用反转  假设n = 7且 k = 3
//原始数组                  : 1 2 3 4 5 6 7
//        反转所有数字后             : 7 6 5 4 3 2 1
//        反转前 k 个数字后          : 5 6 7 4 3 2 1
//        反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length; //k 大于数组长度时对数组取余
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
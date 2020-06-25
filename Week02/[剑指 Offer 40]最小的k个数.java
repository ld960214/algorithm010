//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
// sort heap 快排
// 这里的PriorityQueue就是官方实现的堆
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i< arr.length; i++) {
            heap.add(arr[i]);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll(); // 默认是小根堆，poll就是取出最小值，且删除掉最小值
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
// hashmap 记录频次 然后用堆
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        if (nums.length == 0) return null;
        //
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        // 新建最大堆  传入的参数是一个比较器
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((v1,v2) -> v2.getValue() - v1.getValue());
        while (entries.hasNext()){
            queue.offer(entries.next());
        }
        //
        int[] ans = new int[k];
        for (int i=0; i<k; i++){
            Map.Entry<Integer,Integer> currentEntry = queue.poll();
            ans[i] = currentEntry.getKey();
        }

        return ans;

    }
}

//leetcode submit region end(Prohibit modification and deletion)

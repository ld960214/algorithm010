//// 暴力法 遍历每个元素x，并查找是否存在一个值与target-x想等的目标元素
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new List {i,j};
//                }
//            }
//        }
//        return null;
//    }
//}

import java.sql.PreparedStatement;
import java.util.HashMap;

// 利用hash map的方法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result)) {
                return new int[] {map.get(result) , i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

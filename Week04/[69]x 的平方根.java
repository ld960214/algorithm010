//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
// 方法1 二分查找
// y = x ^2, (x > 0): 抛物线，在y轴右侧单调递增；上下界
//class Solution {
//    public int mySqrt(int x) {
//        if (x == 0 || x == 1) {
//            return x;
//        }
//        long left = 1, right = x;
//        long mid = 1;
//        while (left <= right) {
//            mid = left + (right - left) / 2; // 防止相加除以二越界，所以-
//            if (mid * mid > x) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return (int)right;
//    }
//}

// 方法二： 牛顿迭代法

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while(true) {
            double xi = 0.5 * (x0 + C/ x0);
            if(Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

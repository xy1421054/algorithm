package xy.algorithm.leetcode.day_06;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HappyNumber {
    /**
     * 时间复杂度O(x)
     * 空间复杂度O(x).
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(n);
        while (n!=1){
            n=getNext(n);
            if (!hashSet.add(n)){
                return false;
            }

        }
        return true;
    }

    private static int getNext(int n) {
        int totalSum = 0;

        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d *d;
        }
        return totalSum;
    }

    public static void main(String[] args){
        HappyNumber.isHappy(19);
    }
}

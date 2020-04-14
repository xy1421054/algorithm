package xy.algorithm.leetcode.day_01;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoTogether {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stackOne = new Stack<>();
            Stack<Integer> stackTwo = new Stack<>();

            while (l1 != null) {
                stackOne.add(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stackTwo.add(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode head =null;
            while (!stackOne.isEmpty() || !stackTwo.isEmpty() || carry > 0) {
                int sum = carry;
                sum += stackOne.isEmpty()?0:stackOne.pop();
                sum += stackTwo.isEmpty()?0:stackTwo.pop();
                ListNode listNode = new ListNode(sum % 10);
                listNode.next=head;
                head=listNode;
                carry = sum /10;
            }
            return head;
        }

    }


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 2, 7);
        ListNode head0=null;
        for (Integer value : numbers) {
            ListNode node = new ListNode(value);
            node.next=head0;
            head0=node;
        }

        ListNode head1=null;
        List<Integer> num = Arrays.asList(4, 6, 5);
        for (Integer value: num) {
            ListNode node = new ListNode(value);
            node.next=head1;
            head1=node;
        }

        ListNode listNode = new Solution().addTwoNumbers(head0, head1);
    }

}

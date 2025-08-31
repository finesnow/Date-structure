package Solutions;

import java.util.HashMap;

/**
 * @author Administrator
 * @Date 2025/8/27 19:53
 * @package Solutions
 * @Description:
 */
public class Solution {

    /**
     * @discription leetcode01 两数之和 利用map集合的特性，检查target-nums[i]是否存在
     * @author dme
     * @date 2025/8/27 19:53
     * @param nums
     * @param target
     * @return {@code int[]}
     **/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * @discription leetcode02 两数相加 循环法 循环求和
     * @author dme
     * @date 2025/8/27 21:46
     * @param l1
     * @param l2
     * @return {@code Solutions.ListNode}
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0,carry = 0;
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1!=null&&l2!=null)
        {
            sum = l1.val + l2.val + carry;
            if (sum>=10)
            {
                sum = sum%10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = newNode;
            l1  = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1==null? l2:l1;

        if (remain!=null)
        {
            current.next = remain;
            ListNode prefer = null;
            while (remain != null) {
                if (remain.val + carry >= 10) {
                    remain.val = (remain.val + carry) % 10;
                    carry = 1;
                    prefer = remain;
                    remain = remain.next;
                } else {
                    remain.val = remain.val + carry;
                    carry = 0;
                    break;
                }
            }
            if (carry == 1) {
                prefer.next = new ListNode(1, null);
            }
        }
        else if (carry==1){
            current.next = new ListNode(1, null);
        }

        return head.next;
    }

    /**
     * @discription 递归法 每次递归都生成新结点， 让上次的生成的结点指向新结点 返回新结点
     * @author dme
     * @date 2025/8/27 21:46
     * @param l1
     * @param l2
     * @param carry
     * @return {@code Solutions.ListNode}
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2,int carry){

        if (l1==null&&l2!=null){
            return remain(l2,carry);
        }
        else if (l1!=null&&l2==null){
            return remain(l1,carry);
        }
        else if (l1==null&&l2==null)
        {
            if (carry==1){
                return  new ListNode(1,null);
            }
            else {
                return null;
            }
        }
        int sum = l1.val+ l2.val +carry;

        if (sum>=10)
        {
            carry = 1;
            sum = sum%10;
        }
        else {
            carry = 0;
        }
        ListNode newNode  = new ListNode(sum);

        newNode.next =  addTwoNumbers(l1.next,l2.next,carry);

        return  newNode;


    }
    /**
     * @discription 递归法的辅助函数
     * @author dme
     * @date 2025/8/27 21:48
     * @param remains
     * @param carry
     * @return {@code Solutions.ListNode}
     **/
    public ListNode remain(ListNode remains,int carry){
        ListNode prefer= null;
        ListNode start  =remains;
        while (remains!=null)
        {
            if (remains.val+carry==10)
            {
                remains.val = 0;
                carry = 1;
                prefer = remains;
                remains = remains.next;
            }
            else
            {
                remains.val = remains.val+carry;
                carry = 0;
                break;
            }
        }
        if (carry==1){
           prefer.next =  new ListNode(1,null);
        }

        return start;

    }
    /**
     * @discription leetcode03 无重复字符的最长子串
     * @author dme
     * @date 2025/8/27 21:48
     * @param s
     * @return {@code int}
     **/
    public int lengthOfLongestSubstring(String s) {
       char[] array =  s.toCharArray();
       int start = 0;
       int ends = 0;
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
            {
                start = map.get(array[i])+1;
                map.replace(array[i],i);
            }
            else {
                map.put(array[i],i);

            }
            ends++;
        }
        return 0;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
    /**
     * @discription leetcode88 合并两个有序数组 将合并后的结果存入nums1
     * @author dme
     * @date 2025/9/1 20:40
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return {@code }
     **/
    public void mergeTwoArray(int[] nums1, int m, int[] nums2, int n) {
            if (n==0){
                return;
            }
            if(m==0){
                System.arraycopy(nums2,0,nums1,0,n);
                return;
            }
            int i =0,j=0;
            int index = 0;
            while (index<m&&j<n){
                if (nums1[i]>nums2[j]){
                    //后移腾出位置 数组复制的长度应该的等于数组1的剩余长度
                    System.arraycopy(nums1,i,nums1,i+1,m-index);
                    nums1[i] = nums2[j];
                    j++;
                }
                else {
                    index++;
                }
                i++;
            }
            if (index==m){
                while (j<n){
                    nums1[i] = nums2[j];
                    i++;j++;
                }
            }


    }
    /**
     * @discription 移除所有指定值的元素
     * @author dme
     * @date 2025/9/1 21:50
     * @param nums
     * @param val
     * @return {@code int}
     **/
    public int removeElement(int[] nums, int val) {

//        if (nums.length==0)
//        {
//            return 0;
//        }
//        int length = nums.length;
//        int i = 0;
//        for (int j=0; j<nums.length; i++,j++) {
//            if (nums[i] == val)
//            {
//                System.arraycopy(nums,i+1,nums,i,nums.length-i-1);
//                i--;
//            }
//        }
//        return i;
        //双指针 一个负责读 一个负责覆写
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;

    }
    /**
     * @discription 移除重复的元素 将数组的前半部分视为一个新数组 每次发现新元素时，添加到新数组
     * @author dme
     * @date 2025/9/1 21:53
     * @param nums
     * @return {@code int}
     **/
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;

        for (;q<nums.length;q++){
            if (nums[q] !=nums[p])
            {
                p++;
                nums[p] = nums[q];
            }
        }
        return p+1;

    }
    /**
     * @discription 移除重复元素 但是允许重复一次
     * @author dme
     * @date 2025/9/1 22:09 
     * @param nums 
     * @return {@code int}    
     **/
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        int count = 0;
        for (;q<nums.length;q++){
            if (nums[q] !=nums[p])
            {
                p++;
                nums[p] = nums[q];
                count = 0;
            }
            else {
                if (count<1)
                {
                    p++;
                    nums[p] = nums[q];
                }
                count++;
            }

        }
        return p+1;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

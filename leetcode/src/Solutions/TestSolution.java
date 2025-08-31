package Solutions;

/**
 * @author Administrator
 * @Date 2025/8/27 20:24
 * @package Solutions
 * @Description:
 */
public class TestSolution {

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));

//        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))))));
//        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null))));
      ListNode l1 = new ListNode(5,null);
      ListNode l2 = new ListNode(4,null);

        ListNode l3 = new ListNode();
        l3  = new Solution().addTwoNumbers(l1,l2,0);
        while (l3!=null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}

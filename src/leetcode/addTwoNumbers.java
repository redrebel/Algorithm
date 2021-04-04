https://leetcode.com/problems/add-two-numbers/


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumVal = (offset + l1.val + l2.val);
        int offset =  sumVal / 10;
        ListNode tmp = new ListNode((l1.val + l2.val));
        ListNode root = tmp;
        
        l1 = l1.next;
        l2 = l2.next;
            
        while(l1 != null && l2 != null){
            if(l1 == null){
                sumVal = offset + l2.val;
                l2 = l2.next;
            } else if(l2 == null) {
                sumVal = offset + l1.val;
                l1 = l1.next;
            } else {
              sumVal = (offset + l1.val + l2.val);
              l1 = l1.next;
              l2 = l2.next;             
            }
            offset =  sumVal / 10;
            tmp.next = new ListNode(sumVal % 10);   
            tmp = tmp.next;
        }
        
        return root;
    }
}
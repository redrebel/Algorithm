/**
 * https://leetcode.com/problems/reverse-linked-list
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode returnVal = new ListNode();
        returnVal.val = head.val;
        returnVal.next = null;
        
        head = head.next;
        
        while(true){
            ListNode newNode = new ListNode();
            newNode.next = returnVal;
            newNode.val = head.val;
            returnVal = newNode; 
            if(head.next == null)
            {
                break;
            }
            head = head.next;
        }
        return returnVal;
    }
}
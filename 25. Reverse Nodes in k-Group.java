/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int lengthLL(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    ListNode revLL(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode revHead=revLL(head.next);
        head.next.next=head;
        head.next=null;
        return revHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        if(k==1){
            return head;
        }
        if(k>lengthLL(head)){
            return head;
        }
        int temp=k;
        
        ListNode curr=head;
        ListNode curr2=head;
        while(temp!=1){
            curr=curr.next;
            temp--;
        }
        ListNode next=curr.next;
        curr.next=null;
        curr2=revLL(curr2);
        ListNode tempNode=curr2;
        while(tempNode.next!=null){
            tempNode=tempNode.next;
        }
        tempNode.next=reverseKGroup(next,k);
        return curr2;
        
        
    }
}
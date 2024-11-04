package LinkedList.MediumQuestions;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
*/

public class Q19RemoveNthNode {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        // Move secondPtr n spaces ahead
        for (int i = 0; i < n; i++) {
            secondPtr = secondPtr.next;
        }

        // Move both now, until the next of secondPtr is null
        while (secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        // We now have to remove the node next of firstPtr
        firstPtr.next = firstPtr.next.next;

        return dummy.next;
    }
}
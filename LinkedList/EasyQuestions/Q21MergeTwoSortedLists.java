package LinkedList.EasyQuestions;

import LinkedList.EasyQuestions.Q206ReverseLinkedList.ListNode;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of 
the first two lists. Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

public class Q21MergeTwoSortedLists {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //create a temporary node for traversal
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = (list1 != null) ? list1 : list2;//add the residual nodes either from list1 or list2
        return head.next;//return actual head of sorted list
    }

    
}
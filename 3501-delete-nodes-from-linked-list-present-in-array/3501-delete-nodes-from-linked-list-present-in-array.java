/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node to handle cases where head needs to be removed
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev only if current node is not removed
                prev = curr;
            }
            // Move to the next node
            curr = curr.next;
        }

        // Return the modified list starting from dummy.next
        return dummy.next;
    }
}

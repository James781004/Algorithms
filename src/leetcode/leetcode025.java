package leetcode;

public class leetcode025 {

	// Given a linked list, reverse the nodes of a linked list k at a time and
	// return its modified list.
	//
	// k is a positive integer and is less than or equal to the length of the linked
	// list. If the number of nodes is not a multiple of k then left-out nodes in
	// the end should remain as it is.
	//
	// Example:
	//
	// Given this linked list: 1->2->3->4->5
	//
	// For k = 2, you should return: 2->1->4->3->5
	//
	// For k = 3, you should return: 3->2->1->4->5

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	// 1->2->3->4->5 || k = 2
	// count = 0; cur = 1
	// count = 1; cur = 2
	// count = 2; cur = 3 (last) ==> count == k!!!!!
	// reverseKGroup: 3->4->5 || k = 2
	// count = 0; cur = 3
	// count = 1; cur = 4
	// count = 2; cur = 5 (last) ==> count == k!!!!!
	// reverseKGroup: 5->null
	// return head
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int count = 0;
		ListNode cur = head;
		while (cur != null && count != k) {
			cur = cur.next;
			count++;
		}
		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count-- > 0) {
				// reverse ListNode basic!!!
				ListNode temp = head.next;
				head.next = cur;
				cur = head;
				head = temp;
			}

			head = cur;
		}
		return head;
	}

}

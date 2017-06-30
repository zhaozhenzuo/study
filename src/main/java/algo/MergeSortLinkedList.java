package algo;

import java.util.ArrayList;
import java.util.List;

import algo.MergeTwoLinkedList.ListNode;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		MergeSortLinkedList obj = new MergeSortLinkedList();

		ListNode[] nodeArr = new ListNode[2];

		int[] nodes1 = { 1, 1, 2 };
		ListNode l1 = MergeTwoLinkedList.compose(nodes1);
		nodeArr[0] = l1;

		int[] nodes2 = { 1, 1, 2 };
		ListNode l2 = MergeTwoLinkedList.compose(nodes2);
		nodeArr[1] = l2;

		ListNode listNode = obj.mergeKLists(nodeArr);

		MergeTwoLinkedList.show(listNode);

	}

	private List<ListNode> processListNode(ListNode[] lists) {
		List<ListNode> resList = new ArrayList<ListNode>(lists.length);
		if (lists == null || lists.length <= 0) {
			return resList;
		}

		for (ListNode listNode : lists) {
			ListNode tempNode = listNode;
			while (tempNode != null) {
				resList.add(tempNode);
				tempNode = tempNode.next;
			}
		}

		return resList;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length <= 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}

		List<ListNode> resList = this.processListNode(lists);

		if (resList == null || resList.size() <= 0) {
			return null;
		}

		if (resList.size() == 1) {
			return resList.get(0);
		}

		/**
		 * 插入排序<br/>
		 * 3,1,8,2
		 */
		for (int i = 1; i < resList.size(); i++) {
			int j = i - 1;
			ListNode curNodeCompare = resList.get(i);

			while (true) {

				if (j < 0) {
					break;
				}

				if (curNodeCompare.val >= resList.get(j).val) {
					break;
				} else {
					/**
					 * 前一个结点小于当前要比较的结点,将前一个结点后移一位
					 */
					resList.set(j + 1, resList.get(j));
				}

				j--;

			}

			/**
			 * j＋1结点就是要插入的结点<br/>
			 * j+1位置肯定是最后当前要比较的节点要插入的位置
			 */
			resList.set(j + 1, curNodeCompare);
		}

		/**
		 * 排完序后，形成linkedList
		 */
		ListNode preNode = null;
		ListNode head = resList.get(0);

		for (int i = 0; i < resList.size(); i++) {
			ListNode curNode = resList.get(i);
			if (preNode != null) {
				preNode.next = curNode;
			}

			preNode = curNode;
		}

		return head;
	}

}

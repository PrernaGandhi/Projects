package linkedListPractice;

import linkedListPractice.CreatingSinglyLinkedList.Node;

public class SwapNodesForSortedLinkedList {
	
	public void swapNodes(CreatingSinglyLinkedList ll,int n1,int n2){
		if(ll.binarySearch(ll.head,null,n1) == -1 || ll.binarySearch(ll.head,null,n2) == -1){
			System.out.println("Element not found");
			return;
		}
		Node n11 = ll.head;
		Node prevn1 = null;
		Node n22 = ll.head;
		Node prevn2 = null;
		while(n11.data != n1){
			prevn1 =n11;
			n11 = n11.next;
		}
		while(n22.data != n2){
			prevn2 =n22;
			n22 = n22.next;
		}
		if(prevn1 != null && prevn2 != null){
			Node temp = prevn1.next;
			prevn1.next = prevn2.next;
			prevn2.next = temp;
			temp = n11.next;
			n11.next = n22.next;
			n22.next = temp;
		}else if(prevn1 == null){
			Node temp = ll.head;
			ll.head = prevn2.next;
			prevn2.next = temp;
			temp = n11.next;
			n11.next = n22.next;
			n22.next = temp;
		}
	}

	public static void main(String[] args) {
		CreatingSinglyLinkedList obj = new CreatingSinglyLinkedList();
		Node n1 = obj.new Node(11);
		obj.insertAtLast(n1);
		Node n2 = obj.new Node(12);
		obj.insertAtLast(n2);
		Node n3 = obj.new Node(13);
		obj.insertAtLast(n3);
		Node n4 = obj.new Node(14);
		obj.insertAtLast(n4);
		Node n5 = obj.new Node(15);
		obj.insertAtLast(n5);
		System.out.println("Swap Nodes :: 12 and 14");
		SwapNodesForSortedLinkedList obj1 = new SwapNodesForSortedLinkedList();
		obj1.swapNodes(obj, 12, 14);
		obj.print();
		System.out.println("Swap Nodes :: 11 and 15");
		obj1.swapNodes(obj, 11, 15);
		obj.print();
		
	}

}

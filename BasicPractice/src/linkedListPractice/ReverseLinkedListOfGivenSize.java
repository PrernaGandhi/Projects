package linkedListPractice;

import linkedListPractice.CreatingSinglyLinkedList.Node;

public class ReverseLinkedListOfGivenSize {

	public CreatingSinglyLinkedList.Node effectiveReverse(CreatingSinglyLinkedList.Node h){
		CreatingSinglyLinkedList.Node prev = null;
		CreatingSinglyLinkedList.Node curr = h;
		CreatingSinglyLinkedList.Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		h = prev;
		return h;
	}
	
	public static void main(String[] args) {
		CreatingSinglyLinkedList obj = new CreatingSinglyLinkedList();
		ReverseLinkedListOfGivenSize o = new ReverseLinkedListOfGivenSize();
		Node n1 = obj.new Node(11);
		obj.insertAtStart(n1);
		Node n2 = obj.new Node(12);
		obj.insertAtStart(n2);
		Node n3 = obj.new Node(13);
		obj.insertAtStart(n3);
		Node n4 = obj.new Node(14);
		obj.insertAtStart(n4);
		obj.print();
		System.out.println("Reverse simple");
		obj.head = o.effectiveReverse(obj.head);
		obj.print();
	}

}

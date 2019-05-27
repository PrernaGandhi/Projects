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
	
	public CreatingSinglyLinkedList.Node effectiveReverseInSets(CreatingSinglyLinkedList.Node h, int k){
		CreatingSinglyLinkedList.Node prev = null;
		CreatingSinglyLinkedList.Node curr = h;
		CreatingSinglyLinkedList.Node next = null;
		int i=0;
			while(curr != null && i<k){
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				i++;
			}
			if(next!= null){
				h.next = effectiveReverseInSets(next, k);
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
		Node n5 = obj.new Node(15);
		obj.insertAtStart(n5);
		Node n6 = obj.new Node(16);
		obj.insertAtStart(n6);
		obj.print();
		System.out.println("Reverse simple");
		obj.head = o.effectiveReverse(obj.head);
		obj.print();
		System.out.println("Reverse in sets");
		obj.head = o.effectiveReverseInSets(obj.head,3);
		obj.print();
	}

}

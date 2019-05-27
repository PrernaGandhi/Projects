package linkedListPractice;

import linkedListPractice.CreatingSinglyLinkedList.Node;

public class MergeSortInLinkedList {
	
	Node sortedMerge(Node a, Node b) { 
		Node result = null; 
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        if (a.data <= b.data) { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
	
	Node mergeSort(Node h) { 
		CreatingSinglyLinkedList o = new CreatingSinglyLinkedList();
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        Node middle = o.middleElement(h); 
        Node nextofmiddle = middle.next; 
  
        middle.next = null; 
  
        Node left = mergeSort(h); 
        Node right = mergeSort(nextofmiddle); 
  
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
  
	public static void main(String[] args) {
		CreatingSinglyLinkedList obj = new CreatingSinglyLinkedList();
		MergeSortInLinkedList ob = new MergeSortInLinkedList();
		Node n1 = obj.new Node(11);
		obj.insertAtStart(n1);
		Node n2 = obj.new Node(12);
		obj.insertAtStart(n2);
		Node n3 = obj.new Node(13);
		obj.insertAtStart(n3);
		Node n4 = obj.new Node(14);
		obj.insertAtStart(n4);
		obj.print();
		System.out.println("Merge Sort : :");
		obj.head = ob.mergeSort(obj.head);
		obj.print();
		
	}
}

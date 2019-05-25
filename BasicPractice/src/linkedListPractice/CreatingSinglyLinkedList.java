package linkedListPractice;

import searchPractice.BinarySearch;

public class CreatingSinglyLinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}

	public void insertAtStart(Node n){
		if(head != null){
			n.next = head;
		}
		head = n;
	}

	public void insertAtLast(Node n){
		if(head == null){
			insertAtStart(n);
		}else{
			Node l = head;
			while(l.next != null){
				l = l.next;
			}
			l.next = n;
		}
	}

	public void insertAtPosition(Node n, int pos){
		int i=1;
		Node l = head;
		if(pos == 1){
			insertAtStart(n);	
		}else{
			while(l.next != null && i < pos - 1){
				l = l.next;
				i++;
			}
			if(l.next == null && i < pos - 1){
				System.out.println("Position does not exist");
			}else{
				n.next = l.next;
				l.next = n;
			}
		}
	}

	public void print(){
		Node n = head;
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}

	public Node middleElement(){
		Node sptr = head;
		Node fptr = head.next;
		while(fptr != null && fptr.next != null){
			fptr = fptr.next.next;
			sptr = sptr.next;
		}
		return sptr;
	}
	public Node middleElement(Node start, Node end){
		Node sptr = start;
		Node fptr = start.next;
		while(fptr != null && fptr != end && fptr.next != null){
			fptr = fptr.next.next;
			sptr = sptr.next;
		}
		return sptr;
	}

	public int binarySearch(Node h,Node e,int v){
		Node middle = middleElement(h,e);
		if(h == e){
			System.out.println("not found");
			return -1;
		}
		if(middle.data == v){
			System.out.println("Element found");
			return middle.data;
		}else if(v > middle.data){
			return binarySearch(middle.next, e,v);
		}else{
			return binarySearch(h, middle,v);
		}
	}
	
	public void reverse(){
		Node h1 = head;
		Node last = null;
		while(h1 != null && h1.next != null){
			h1 = h1.next;
		}
		last = h1;
		h1 = head;
		while(h1 != null && h1.next != null){
			while(h1 != null && h1.next != null){
				if(h1.next.next == null){
					h1.next.next = h1;
					h1.next = null;
					break;
				}
				h1 = h1.next;
			}
			h1 = head;
		}
		head = last;
	}

	public static void main(String[] args) {
		CreatingSinglyLinkedList obj = new CreatingSinglyLinkedList();
		Node n1 = obj.new Node(11);
		obj.insertAtStart(n1);
		Node n2 = obj.new Node(12);
		obj.insertAtStart(n2);
		Node n3 = obj.new Node(13);
		obj.insertAtStart(n3);
		Node n4 = obj.new Node(14);
		obj.insertAtStart(n4);
		obj.print();
		System.out.println("reverse_______");
		obj.reverse();
		System.out.println("reverse_end_______");
		obj.print();
		Node n5 = obj.new Node(15);
		System.out.println("Insert at last");
		obj.insertAtLast(n5);
		obj.print();
		Node n6 = obj.new Node(1);
		System.out.println("insert at pos 1");
		obj.insertAtPosition(n6,1);
		obj.print();
		Node n7 = obj.new Node(2);
		System.out.println("insert at pos 2");
		obj.insertAtPosition(n7,2);
		obj.print();
		Node n8 = obj.new Node(3);
		System.out.println("insert at pos 3");
		obj.insertAtPosition(n8,3);
		obj.print();
		Node n9 = obj.new Node(9999);
		System.out.println("insert at pos 9");
		obj.insertAtPosition(n9,16);
		obj.print();
		Node n10 = obj.new Node(0000);
		System.out.println("insert at pos 14");
		obj.insertAtPosition(n10,14);
		obj.print();
		System.out.println("Middle element is :: " + obj.middleElement().data);
		System.out.println("Binary search : : for 9");
		System.out.println(obj.binarySearch(obj.head, null,9));
		System.out.println("Binary search : : for 11");
		System.out.println(obj.binarySearch(obj.head, null,11));

	}

}

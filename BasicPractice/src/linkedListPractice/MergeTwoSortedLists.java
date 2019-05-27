package linkedListPractice;

public class MergeTwoSortedLists {
	
	public CreatingSinglyLinkedList mergeLinkedList(CreatingSinglyLinkedList.Node h1, 
			CreatingSinglyLinkedList.Node h2){
		CreatingSinglyLinkedList finallist = new CreatingSinglyLinkedList();
		while(h1 != null && h2 != null){
			CreatingSinglyLinkedList.Node h11 = finallist.new Node(h1.data);
			CreatingSinglyLinkedList.Node h22 = finallist.new Node(h2.data);
			if(h1.data < h2.data){
				finallist.insertAtLast(h11);
				finallist.insertAtLast(h22);
			}else if(h1.data > h2.data){
				finallist.insertAtLast(h22);
				finallist.insertAtLast(h11);
			}else{
				finallist.insertAtLast(h11);
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		if(h1 != null){
			CreatingSinglyLinkedList.Node h11 = finallist.new Node(h1.data);
			finallist.insertAtLast(h11);
			h1 = h1.next;
		}
		if(h2 != null){
			CreatingSinglyLinkedList.Node h22 = finallist.new Node(h2.data);
			finallist.insertAtLast(h22);
			h2 = h2.next;
		}
		return finallist;
	}

	public static void main(String[] args) {
		CreatingSinglyLinkedList obj1 = new CreatingSinglyLinkedList();
		CreatingSinglyLinkedList obj2 = new CreatingSinglyLinkedList();
		CreatingSinglyLinkedList.Node n11 = obj1.new Node(10);
		CreatingSinglyLinkedList.Node n12 = obj1.new Node(30);
		CreatingSinglyLinkedList.Node n13 = obj1.new Node(50);
		CreatingSinglyLinkedList.Node n14 = obj1.new Node(70);
		CreatingSinglyLinkedList.Node n15 = obj1.new Node(80);
		obj1.insertAtLast(n11);
		obj1.insertAtLast(n12);
		obj1.insertAtLast(n13);
		obj1.insertAtLast(n14);
		obj1.insertAtLast(n15);
		System.out.println("Linked List 1 :");
		obj1.print();
		CreatingSinglyLinkedList.Node n21 = obj2.new Node(20);
		CreatingSinglyLinkedList.Node n22 = obj2.new Node(40);
		CreatingSinglyLinkedList.Node n23 = obj2.new Node(60);
		obj2.insertAtLast(n21);
		obj2.insertAtLast(n22);
		obj2.insertAtLast(n23);
		System.out.println("Linked List 2 :");
		obj2.print();
		System.out.println("Merged array ::");
		CreatingSinglyLinkedList obj3 = new CreatingSinglyLinkedList();
		MergeTwoSortedLists ob = new MergeTwoSortedLists();
		obj3.head = null;
		obj3 = ob.mergeLinkedList(obj1.head, obj2.head);
		obj3.print();
	}

}

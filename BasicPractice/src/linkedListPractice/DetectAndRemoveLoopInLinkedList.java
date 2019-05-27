package linkedListPractice;

public class DetectAndRemoveLoopInLinkedList {
	
	int detectLoop(CreatingSinglyLinkedList.Node h){
		CreatingSinglyLinkedList.Node sptr = h;
		CreatingSinglyLinkedList.Node fptr = h;
		while(sptr != null && fptr != null && fptr.next != null){
			sptr = sptr.next;
			fptr = fptr.next.next;
			if(sptr == fptr){
				fptr.next.next = null;
				System.out.println("Loop detected");
				return 1;
			}
		}
		System.out.println("Loop not found");
		return 0;
	}

	public static void main(String[] args) {
		CreatingSinglyLinkedList list = new CreatingSinglyLinkedList(); 
        list.head = list.new Node(50); 
        list.head.next = list.new Node(20); 
        list.head.next.next = list.new Node(15); 
        list.head.next.next.next = list.new Node(4); 
        list.head.next.next.next.next = list.new Node(10);
        list.head.next.next.next.next.next = list.head.next.next; 
        DetectAndRemoveLoopInLinkedList d = new DetectAndRemoveLoopInLinkedList();
        System.out.println(d.detectLoop(list.head));
        list.print();

	}

}

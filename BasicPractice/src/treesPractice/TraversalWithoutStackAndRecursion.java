package treesPractice;

public class TraversalWithoutStackAndRecursion {

	class node{
		int key;
		node left;
		node right;
		boolean visited;
	}
	
	node root;
	node newNode(int data) { 
	    node node = new node(); 
	    node.key = data; 
	    node.left = null; 
	    node.right = null; 
	    node.visited = false; 
	    return (node); 
	}
	
	
	void postorderWithoutStackAndRecursion(node h){
		node temp = h;
		while(temp != null && temp.visited == false){
			if(temp.left != null && temp.left.visited == false){
				temp = temp.left;
			}else if(temp.right != null && temp.right.visited == false){
				temp = temp.right;
			}else{
				System.out.print(temp.key + " ");
				temp.visited = true;
				temp = h;
			}
		}
	}
}

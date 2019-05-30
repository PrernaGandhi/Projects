package treesPractice;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

class CreateBinaryTree {
	
	Node root;
	
	class Node{
		int key;
		Node left,right;
		Node(int key){
			 this.key = key;
			 left = null;
			 right = null;
		 }
	}

	void inorder(Node n){
		if(n == null){
			return;
		}
		inorder(n.left);
		System.out.print(n.key + " ");
		inorder(n.right);
	}
	
	int minValue(Node n){
		int min = n.key;
		while(n.left != null){
			min = n.left.key;
			n = n.left; 
		}
		return min;
	}
	
	Node deleteNode(Node n, int key){
		if(n == null)
			return n;
		if(key < n.key)
			n.left = deleteNode(n.left, key);
		else if(key > n.key)
			n.right = deleteNode(n.right, key);
		else{
			if(n.left == null)
				return n.right;
			else if(n.right == null)
				return n.left;
			n.key = minValue(n.right);
			n.right = deleteNode(n.right, n.key);
		}
		return n;
	}
	
	void iterativePreOrder(Node n){
		if(n == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(n);
		while(!stack.isEmpty()){
			Node val = stack.pop();
			System.out.print(val.key + " ");
			if(val.right != null){
				stack.push(val.right);
			}
			if(val.left != null){
				stack.push(val.left);
			}
		}
	}
	class item{
		Node node1;
		int hd;
		item(Node n,int h){
			node1 = n;
			hd = h;
		}
	}
	
	void printBottomView(Node n){
		if(n == null)
			return;
		Queue<item> q = new LinkedList<>();
		Map<Integer,LinkedList<Integer>> map = new TreeMap<>();
		q.add(new item(n,0));
		Node temp = null;
		while(!q.isEmpty()){
			temp = q.peek().node1;
			int h = q.peek().hd;
			q.remove();
			LinkedList<Integer> i;
			if(map.get(h) == null){
				i = new LinkedList<>();
			}else{
				i = map.get(h);
			}
			i.add(temp.key);
			map.put(h, i);
			if(temp.left != null){
				q.add(new item(temp.left,h - 1));
			}
			if(temp.right != null){
				q.add(new item(temp.right,h + 1));
			}
		}
		for(LinkedList<Integer> i : map.values()){
			System.out.print(i.get(i.size()-1) + " ");
		}
	}
	void topView(Node n){
		if(n == null)
			return;
		Node temp = null;
		Queue<item> kk = new LinkedList<>();
		Map <Integer, Integer> map = new TreeMap<>();
		kk.add(new item(n,0));
		while(kk.size() > 0){
			temp = kk.peek().node1;
			int h = kk.peek().hd;
			kk.remove();
			if(map.get(h) == null){
				System.out.print(temp.key + " ");
				map.put(h, temp.key);
			}
			if(temp.left != null){
				kk.add(new item(temp.left,h - 1));
			}
			if(temp.right != null){
				kk.add(new item(temp.right,h + 1));
			}
		}
		System.out.println();
		for(int i :map.values()){
			System.out.print(i + " ");
		}
	}
	
	int height(Node n){
		if(n == null)
			return 0;
		else{
			int lheight = height(n.left);
			int rheight = height(n.right);
			if(lheight > rheight){
				return lheight+1;
			}else{
				return rheight + 1;
			}
		}
	}
	
	void printLevelOrder(Node n, int h){
		if(n == null)
			return;
		if(h == 1){
			System.out.print(n.key + " ");
		}else if(h>1){
			printLevelOrder(n.left, h - 1);
			printLevelOrder(n.right, h - 1);
		}
	}
	
	void levelOrderTraversal(Node n){
		int val =height(n);
		for(int i=1;i<=val;i++){
			printLevelOrder(n, i);
		}
	}
	
	int max_level = 0;
	void leftView(Node n, int h){
		if(n == null)
			return;
		if(max_level<h){
			System.out.print(n.key + " ");
			max_level = h;
		}
		leftView(n.left, h + 1);
		leftView(n.right, h + 1);
	}
	int max_level1=0;
	void rightView(Node n, int h){
		if(n == null)
			return;
		if(max_level1<h){
			System.out.print(n.key + " ");
			max_level1 = h;
		}
		rightView(n.right, h + 1);
		rightView(n.left, h + 1);
	}
	
	private void getVerticalOrder(Node n, int hd,
			TreeMap<Integer, Vector<Integer>> m) {
		if(n == null){
			return;
		}
		Vector<Integer> k = m.get(hd);
		if(k == null){
			k = new Vector<>();
			k.add(n.key);
		}else{
			k.add(n.key);
		}
		m.put(hd, k);
		getVerticalOrder(n.left, hd - 1, m);
		getVerticalOrder(n.right, hd + 1, m);
	}
	
	void printVerticalOrderTraversal(Node n){
		TreeMap<Integer,Vector<Integer>>m = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(n,hd,m);
		for(Entry<Integer,Vector<Integer>> entry : m.entrySet()){
			System.out.println(entry.getValue());
		}
		
	}
	
	void postOrderWithOneStack(Node n){ 
		Stack<Node> stack = new Stack<>(); 
	    while(true){
	        while(n != null){ 
	            stack.push(n); 
	            stack.push(n); 
	            n = n.left; 
	        } 
	        if(stack.empty()){
	        	return; 
	        }
	        n = stack.pop(); 
	          
	        if(!stack.empty() && stack.peek() == n){
	        	n = n.right; 
	        }else {      
	            System.out.print(n.key + " "); 
	            n = null; 
	        } 
	    } 
    }
	

	void preorder(Node n){
		if(n == null){
			return;
		}
		System.out.print(n.key + " ");
		preorder(n.left);
		preorder(n.right);
	}
	
	void iterativePostOrderWithTwoStacks(Node n){
		if(n == null){
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(n);
		while(!stack1.isEmpty()){
			Node val = stack1.pop();
			stack2.push(val);
			if(val.left != null){
				stack1.push(val.left);
			}
			if(val.right != null){
				stack1.push(val.right);
			}
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().key + " ");
		}
	}
	
	
	void postorder(Node n){
		if(n == null){
			return;
		}
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.key + " ");
	}
	
	Node insert(Node n, int key){
		if(n == null){
			n = new Node(key);
			return n;
		}else if(n.key < key){
			n.right = insert(n.right,key);
		}else{
			n.left = insert(n.left,key);
		}
		return n;
	}
	
	public static void main(String[] args) {
		CreateBinaryTree cbt = new CreateBinaryTree();
		Node root = null;
		root = cbt.insert(root, 10);
		cbt.insert(root, 120);
		cbt.insert(root, 101);
		cbt.insert(root, 110);
		cbt.insert(root, 103);
		cbt.insert(root, 104);
		cbt.insert(root, 2);
		cbt.insert(root, 3);
		cbt.insert(root, 4);
		cbt.insert(root, 5);
		cbt.insert(root, 6);
		System.out.println("Inorder :: ");
		cbt.inorder(root);
		System.out.println();
		System.out.println("Iterative Postorder with 2 stacks:: ");
		cbt.iterativePostOrderWithTwoStacks(root);
		System.out.println();
		System.out.println("Iterative Postorder without stack ad recursion:: ");
		TraversalWithoutStackAndRecursion t = new TraversalWithoutStackAndRecursion();
		TraversalWithoutStackAndRecursion.node root1 = t.newNode(8); 
		root1.left = t.newNode(3); 
	    root1.right = t.newNode(10); 
	    root1.left.left = t.newNode(1); 
	    root1.left.right = t.newNode(6); 
	    root1.left.right.left = t.newNode(4); 
	    root1.left.right.right = t.newNode(7); 
	    root1.right.right = t.newNode(14); 
	    root1.right.right.left = t.newNode(13);
		t.postorderWithoutStackAndRecursion(root1);
		System.out.println();
		System.out.println("Postorder :: ");
		cbt.postorder(root);
		System.out.println();
		System.out.println("Postorder with one stack :: ");
		cbt.postOrderWithOneStack(root);
		System.out.println();
		System.out.println("PreOrder :: ");
		cbt.preorder(root);
		System.out.println();
		System.out.println("Iterative PreOrder :: ");
		cbt.iterativePreOrder(root);
		System.out.println();
		System.out.println("Print vertical order traversal : :");
		cbt.printVerticalOrderTraversal(root);
		System.out.println();
		System.out.println("Top View");
		cbt.topView(root);
		System.out.println();
		System.out.println("Level Order Traversal");
		cbt.levelOrderTraversal(root);
		System.out.println();
		System.out.println("Left view");
		cbt.leftView(root, 1);
		System.out.println();
		System.out.println("Right view");
		cbt.rightView(root, 1);
		System.out.println();
		System.out.println("bottom view");
		cbt.printBottomView(root);
		Node root2 = null;
		root2 = cbt.insert(root2, 10);
		cbt.insert(root2, 5);
		cbt.insert(root2, 15);
		cbt.insert(root2, 2);
		cbt.insert(root2, 6);
		cbt.insert(root2, 12);
		cbt.insert(root2, 17);
		System.out.println();
		System.out.println("bottom view with root 2");
		cbt.printBottomView(root2);
		
		 Node root3 = cbt.new Node(20); 
	     root3.left = cbt.new Node(8); 
	     root3.right = cbt.new Node(22); 
	     root3.left.left = cbt.new Node(5); 
	     root3.left.right = cbt.new Node(3); 
	     root3.right.left = cbt.new Node(4); 
	     root3.right.right = cbt.new Node(25); 
	     root3.left.right.left = cbt.new Node(10); 
	     root3.left.right.right = cbt.new Node(14); 
	     System.out.println();
	     System.out.println("bottom view with root 3");
	     cbt.printBottomView(root3);
	     System.out.println();
	     System.out.println("Delete node 5");
	     cbt.deleteNode(root,5);
	     cbt.inorder(root);;
	}
}

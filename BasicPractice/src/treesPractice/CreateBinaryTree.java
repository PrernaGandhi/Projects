package treesPractice;

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
	
	void preorder(Node n){
		if(n == null){
			return;
		}
		System.out.print(n.key + " ");
		inorder(n.left);
		inorder(n.right);
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
		System.out.println("Postorder :: ");
		cbt.postorder(root);
		System.out.println();
		System.out.println("PreOrder :: ");
		cbt.preorder(root);
	}

}

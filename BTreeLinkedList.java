import java.util.Scanner;

class Binary_Node {

	public String value ;
	public Binary_Node leftChild ;
	public Binary_Node rightChild ;

}

public class BTree_LinkedList {
	
	public Binary_Node root ;
	int height ;
	int count ;
	
	public BTree_LinkedList() {
		this.root = null ;
	}
	
	public BTree_LinkedList(String value) {
		this.root = new Binary_Node() ;
		this.root.value = value ;
		height ++ ;
	}
	
	public BTree_LinkedList(int value) {
		this.root = new Binary_Node() ;
		this.root.value = Integer.toString(value) ;
		height ++ ;
	}
	
	public void deleteBT() {
		this.root = null ;
		System.out.println("The whole binary tree deleted successfully");
	}
	
	public int insert(String str) {
		Binary_Node newNode = new Binary_Node() ;
		newNode.value = str ;
		if(this.root == null) {
			this.root = newNode ;
			System.out.println(str + " Pushed in index : " + this.count);
			this.height = 1 ;
			this.count = 1 ;
			return 0 ;
		}
		Binary_Node tempNode = this.root ;
		int number_elements = (int) Math.pow(2, (this.height - 1)) ;
		int last_row_elements = this.count - ((int) Math.pow(2, (this.height - 1))) + 1;
		if(number_elements == last_row_elements) {
			while(tempNode.leftChild != null) {
				tempNode = tempNode.leftChild ;
			}
			tempNode.leftChild = newNode ;
			System.out.println(str + " pushed in index : " + this.count);
			this.height ++ ;
			this.count ++ ;
			return 0 ;
		}
		for(int i = 0 ; i < this.height ; i++) {
			if(last_row_elements >= (number_elements / 2)) {
				if(tempNode.rightChild == null) {
					tempNode.rightChild = newNode ;
					System.out.println(str + " pushed in index : " + this.count);
					this.count ++ ;
					return 0 ;
				}
				tempNode = tempNode.rightChild ;
				last_row_elements = last_row_elements - (number_elements / 2) ;
			} else {
				if(tempNode.leftChild == null) {
					tempNode.leftChild = newNode ;
					System.out.println(str + " pushed in index : " + this.count);
					this.count ++ ;
					return 0 ;
				}
				tempNode = tempNode.leftChild ;
			}
			number_elements = number_elements / 2 ;
		}
		
		return 0 ;
	}
	
	public int delete() {
		if(this.root == null) {
			System.out.println("There are no element to delete");
			return 0 ;
		}
		Binary_Node tempNode = this.root ;
		int number_elements = (int) Math.pow(2, (this.height - 1)) ;
		int last_row_elements = this.count - (number_elements - 1);
		if(last_row_elements == 1) {
			Binary_Node parentNode = tempNode ;
			while(tempNode.leftChild != null) {
				parentNode = tempNode ;
				tempNode = tempNode.leftChild ;
			}
			System.out.println(tempNode.value + " deleted of index : " + (this.count - 1));
			parentNode.leftChild = null ;
			tempNode = null ;
			this.height -- ;
			this.count -- ;
			return 0 ;
		}
		Binary_Node parentNode = tempNode ;
		for(int i = 0 ; i < (this.height - 1) ; i++) {
			parentNode = tempNode ;
			if(last_row_elements > (number_elements / 2)) {
				tempNode = tempNode.rightChild ;
				if(i == this.height - 2) {
					parentNode.rightChild = null ;
				}
				last_row_elements = last_row_elements - (number_elements / 2) ;
			} else {
				tempNode = tempNode.leftChild ;
				if(i == this.height - 2) {
					parentNode.leftChild = null ;
				}
			}
			number_elements = number_elements / 2 ;
		}
		System.out.println(tempNode.value + " deleted of index : " + (this.count - 1));
		
		tempNode = null ;
		this.count -- ;
		
		return 0 ;
	}
	
	public void traverse() {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("In which order you want to traverse,"
				+ "\n for inorder in,"
				+ "\n for preorder pre,"
				+ "\n for postorder post"
				+ ",\n for exit write exit ") ;
		String temp = sc.next() ;
		
		if(temp.contains("in")) {
			System.out.println("Inorder traversal is going.....") ;
			this.inorder(this.root) ;
			System.out.println();
			System.out.println();
			traverse() ;
		} else if(temp.contains("pre")) {
			System.out.println("Preorder traversal is going.....") ;
			this.preorder(this.root) ;
			System.out.println();
			System.out.println();
			traverse() ;
		} else if(temp.contains("post")) {
			System.out.println("Postorder traversal is going.....") ;
			this.postorder(this.root) ;
			System.out.println();
			System.out.println();
			traverse() ;
		} else if(temp.contains("exit")) {
			System.out.println();
			System.out.println("....Exit successfully");
		} else {
			System.out.println("Invalid") ;
			System.out.println();
			traverse() ;
		}
	}
	
	public void preorder(Binary_Node root) {
		if(root != null) {
			System.out.print(root.value + " ") ;
			preorder(root.leftChild) ;
			preorder(root.rightChild) ;
		}
	}
	
	public void inorder(Binary_Node root) {
		if(root != null) {
			inorder(root.leftChild) ;
			System.out.print(root.value + " ") ;
			inorder(root.rightChild) ;
		}
	}
	
	public void postorder(Binary_Node root) {
		if(root != null) {
			postorder(root.leftChild) ;
			postorder(root.rightChild) ;
			System.out.print(root.value + " ") ;
		}
	}
	
	public void search(String str) {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Which saerching algorithm you want to use,"
				+ "\n for level order traversal write bfs,"
				+ "\n for post order traversal write dfs"
				+ ",\n for exit write exit ") ;
		String temp = sc.next() ;
		int index = 0;
		if(temp.contains("bfs")) {
			System.out.println("BFS is going.....") ;
			this.bfs(this.root , str) ;
			System.out.println();
			System.out.println();
			search(str) ;
		} else if(temp.contains("dfs")) {
			System.out.println("DFS is going.....") ;
			this.dfs(this.root , str) ;
			System.out.println();
			System.out.println();
			search(str) ;
		} else if(temp.contains("exit")) {
			System.out.println();
			System.out.println("....Exit successfully") ;
		} else {
			System.out.println("Invalid") ;
			System.out.println();
			search(str) ;
		}
	}
	
	public void bfs(Binary_Node root , String str) {
		if(root != null) {
			if(root.value == str) {
				System.out.println("The string is present in the binary tree");
			}
			bfs(root.leftChild , str) ;
			bfs(root.rightChild , str) ;
		}
	}
	public void dfs(Binary_Node root , String str) {
		if(root != null) {
			dfs(root.leftChild , str) ;
			dfs(root.rightChild , str) ;
			if(root.value == str) {
				System.out.println("The string is present in the binary tree");
			}
		}
	}
	
}

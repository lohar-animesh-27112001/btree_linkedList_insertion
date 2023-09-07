// I have created an algorithm in which insertion of Binary Tree of any data-type time complexity will be O(log n)

class Binary_Node {

	public String value;
	public Binary_Node leftChild;
	public Binary_Node rightChild;
	public int height;

}

public class BTree_LinkedList_Insertion {

	public Binary_Node root;
	int height;
	int count;

	public BTree_LinkedList() {
		this.root = null ;
	}

	public int add(String str) {
		Binary_Node newNode = new Binary_Node();
		newNode.value = str;
		if (this.root == null) {
			this.root = newNode;
			System.out.println(str + " Pushed in index : " + this.count);
			this.height = 1;
			this.count = 1;
			return 0;
		}
		Binary_Node tempNode = this.root;
		int number_elements = (int) Math.pow(2, (this.height - 1));
		int last_row_elements = this.count - ((this.height * (this.height - 1)) / 2);
		if (number_elements == last_row_elements) {
			while (tempNode.leftChild != null) {
				tempNode = tempNode.leftChild;
			}
			tempNode.leftChild = newNode;
			System.out.println(str + " pushed in index : " + this.count);
			this.height++;
			this.count++;
			return 0;
		}
		for (int i = 0; i < this.height; i++) {
			if (last_row_elements >= (number_elements / 2)) {
				if (tempNode.rightChild == null) {
					tempNode.rightChild = newNode;
					System.out.println(str + " pushed in index : " + this.count);
					this.count++;
					return 0;
				}
				tempNode = tempNode.rightChild;
			} else {
				if (tempNode.leftChild == null) {
					tempNode.leftChild = newNode;
					System.out.println(str + " pushed in index : " + this.count);
					this.count++;
					return 0;
				}
				tempNode = tempNode.leftChild;
			}
			number_elements = (int) Math.pow(2, (this.height - 1));
		}

		return 0;
	}

}

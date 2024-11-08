

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int N;
	
	static class Node{
		char data;
		Node left;
		Node right;
		
		Node(char data){
			this.data = data;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			
			tree.add(a,b,c);
		}
		
		
//		System.out.println(Arrays.toString(tree));

		// 전위 순회
		preorder(tree.root);
		sb.append("\n");
		// 중위 순회
		inorder(tree.root);
		sb.append("\n");
		// 후위 순회
		postorder(tree.root);
		sb.append("\n");
		
		System.out.println(sb);
	}

	static void preorder(Node node) {
		if(node == null) return;
		
		sb.append(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	static void inorder(Node node) {
		if(node == null) return;
		
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}
	static void postorder(Node node) {
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		sb.append(node.data);
	}
	
	static class Tree {
		Node root;
		
		void add(char data, char leftData, char rightData) {
			if(root == null) { // A 저장
				root = new Node(data);
				if(leftData != '.') {
					root.left = new Node(leftData);
				}
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			} else { // A 이후 노드 저장
				search(root, data, leftData, rightData);
			}
		}
		
		// node는 root
		void search(Node node, char data, char leftData, char rightData) {
			if(node == null) return;
			else if(node.data == data) {
				if(leftData != '.') {
					node.left = new Node(leftData);
				}
				if(rightData != '.') {
					node.right = new Node(rightData);
				}
			} else {
				search(node.left, data, leftData, rightData);
				search(node.right, data, leftData, rightData);
			}
		}
	}

}

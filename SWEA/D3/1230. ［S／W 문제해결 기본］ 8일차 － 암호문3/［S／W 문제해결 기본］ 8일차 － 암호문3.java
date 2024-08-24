import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int data;
	Node nextNode;
	Node prevNode;
}

class DLL {
	Node head;
	Node tail;
	int size;
	
	// 생성자 - 노드가 head, tail 2개인 상태의 양방향 연결리스트 생성
	DLL(){
		head = new Node();
		tail = new Node();
		// int size; 0으로 초기화
		head.nextNode = tail;
		tail.prevNode = head;
	}
	
	// 기능 - 삽입, 삭제, 출력, get
	void add(int idx, int data){
		if(idx<0 || idx>size) {
			System.out.println("삽입 불가");
			return;
		} 
		// 크기+1
		size++;
		// 삽입 위치 앞 노드 찾기
		Node prev = head;
		for (int i = 0; i < idx; i++) {
			prev = prev.nextNode; 
		}
		// 새 노드
		Node newNode = new Node();
		newNode.data = data;
		// 새 노드 연결 후 기존 노드 연결 재구성
		newNode.prevNode = prev;
		newNode.nextNode = prev.nextNode;
		prev.nextNode.prevNode = newNode;
		prev.nextNode = newNode;
	}
	
	void remove(int idx) {
		if(idx<0 || idx>size) {
			System.out.println("삭제 불가");
			return;
		}
		// 크기-1
		size--;
		// 삭제 위치 찾기
		Node rm = head.nextNode;
		for (int i = 0; i < idx; i++) {
			rm = rm.nextNode;
		}
		// 연결 재구성
		rm.prevNode.nextNode = rm.nextNode;
		rm.nextNode.prevNode = rm.prevNode;
	}
	
	void print() {
		Node cur = head.nextNode;
		while(cur != tail) {
			System.out.print(cur.data+" ");
			cur = cur.nextNode;
		}
		System.out.println();
	}
	
	int get(int idx) {
		Node cur = head.nextNode;
		for (int i = 0; i < idx; i++) {
			cur = cur.nextNode;
		}
		return cur.data;
	}
	
}

public class Solution {
	
	// 양방향 연결 리스트 직접 구현하기

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		for (int test_case = 1; test_case <=10; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			DLL cipher = new DLL();
//			List<Integer> cipher = new LinkedList<>();		
			for (int i = 0; i < N; i++) {
				cipher.add(i, Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x;
			int y;
			int s;		
			for (int i = 0; i < M; i++) {
				String str = st.nextToken();
				switch (str) {
				case "I": {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						cipher.add(x++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
				case "D": {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						cipher.remove(x);
					}
					break;
				}
				case "A": {
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						cipher.add(cipher.size, Integer.parseInt(st.nextToken()));
					}
					break;
				}
				}
			}
			
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+ cipher.get(i));
			}
			
			System.out.println();
		}
	}

}

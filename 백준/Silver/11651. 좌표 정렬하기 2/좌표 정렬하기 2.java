

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//comparator 연습
	
	static class Node {
		int x;
		int y;
		
		Node(){};
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		List<Node> list = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x, y));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.y != o2.y) return o1.y -o2.y; // 오름차순
				else return o1.x - o2.x;
			}
		});
		StringBuilder sb= new StringBuilder();
		for (Node node : list) {
			sb.append(node.x).append(" "). append(node.y).append("\n");
		}
		
		System.out.println(sb);
	}
}

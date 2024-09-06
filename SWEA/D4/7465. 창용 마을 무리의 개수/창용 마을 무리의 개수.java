import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution { // (양방향=무향) 인접리스트 -> BFS로 풀기........ㅜㅜㅜㅜㅜ
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // 명
			int M = sc.nextInt(); // 관계
			
			List<Integer>[] node = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				node[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				node[A].add(B);
				node[B].add(A);
			}
			
			boolean[] visited = new boolean[N+1];
			Queue<Integer> queue = new LinkedList<>();
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) { // 1~N번 사람
				
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
					
					while(!queue.isEmpty()) {
//						System.out.println(queue);
						int num = queue.poll();
						// node[num]의 리슽에 있는 노드 모두 큐에 넣어야 하는데
						for(int n : node[num]) {
							if(!visited[n]) {
								visited[n] = true;
								queue.add(n);
							}
						}
					}
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
			
		} // for tc

	} // main
	
	


}

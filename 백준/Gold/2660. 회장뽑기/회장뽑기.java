
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// 점수 가장 작은 사람이 회장
		// 모두가 서로와 간접적으로 연결되어 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N + 1];
		List<Integer>[] rel = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			rel[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a != -1 || b != -1) {
			rel[a].add(b);
			rel[b].add(a);
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
//			System.out.println(i);
		
			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];
			q.add(new int[] {i, 0});
			visited[i] = true;
			int depth = 0;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				depth = Math.max(depth, cur[1]);
//				System.out.println(cur);
				for(int r : rel[cur[0]]) {
					if(!visited[r]) {
						q.add(new int[] {r, cur[1] + 1});
						visited[r] = true;
					}
				}
			}
			score[i] = depth;
			
			min = Math.min(min, score[i]);
//			System.out.println(min);
		}
		
		Set<Integer> candidate = new TreeSet<>();
		for(int i = 1; i <= N; i++) {
			if(score[i] == min) candidate.add(i);
		}
		
		System.out.println(min + " " + candidate.size());
		for(int s : candidate) {
			System.out.print(s + " ");
		}
		
	}
}

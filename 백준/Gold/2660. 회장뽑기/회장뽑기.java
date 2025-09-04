
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
	
	// 플로이드 워셜로 풀어보기
	// 모든점에서 모든 점으로의 최단거리 (음수 가중치 포함, 시간 복잡도 ^3)
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N + 1];
		int[][] dist = new int[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a != -1 || b != -1) {
			dist[a][b] = 1;
			dist[b][a] = 1;
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if (i == j) dist[i][j] = 0;
				else if (dist[i][j] != 1) {
					dist[i][j] = 50;
				}
				
			}
		}
//		for(int[] d : dist) {
//			System.out.println(Arrays.toString(d));
//		}
		
		// 플로이드 워셜 (경유점 하나씩 추가)
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}			
		}
//		for(int[] d : dist) {
//			System.out.println(Arrays.toString(d));
//		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				score[i] = Math.max(dist[i][j], score[i]);
			}
			min = Math.min(score[i], min);
		}
		
		Set<Integer> set = new TreeSet<>();
		for(int i = 1; i <= N; i++) {
			if(score[i] == min) set.add(i);
		}
		System.out.println(min + " " + set.size());
		for(int s : set) {
			System.out.print(s + " ");
		}
		
	}
}

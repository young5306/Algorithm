
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// i->j로의 (최단)거리 구함 
		// i->모든 점으로의 거리 중 최대값(절댓값)이 N+1/2 보다 크면 -> 중간 될 수 x
		// 플로이드 워셜
		
		int[][] dist = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1; // a > b
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i != j && dist[i][j] != 1) {
					dist[i][j] = 10000;
				}
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int[] high = new int[N + 1];
		int[] low = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dist[i][j] == 0 || dist[i][j] >= 10000) continue;
				high[i]++;
				low[j]++;
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(high[i] >= (N+1)/2) {
				answer++;
//				System.out.println(i);
			}
			else if(low[i] >= (N+1)/2) {
				answer++;
//				System.out.println(i);
			}
		}
		
		System.out.println(answer);
		
	}

}

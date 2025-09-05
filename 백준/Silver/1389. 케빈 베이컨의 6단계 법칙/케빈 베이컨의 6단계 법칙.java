
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// N 최대 100 -> 플로이드 워셜 시간복잡도 10^6
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					dist[i][j] = 0;
					continue;
				}
				if(dist[i][j] != 1) dist[i][j] = 100000;
			}			
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int[] score = new int[N + 1];
		int min = 10000;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				score[i] += dist[i][j];
			}
			min = Math.min(score[i], min);
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(score[i] == min) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}

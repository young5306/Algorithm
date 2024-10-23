

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Sinfo implements Comparable<Sinfo> {
		int r;
		int c;
		int likes;
		int blanks;

		public Sinfo(int r, int c, int likes, int blanks) {
			super();
			this.r = r;
			this.c = c;
			this.likes = likes;
			this.blanks = blanks;
		}

		// 자리 배치
		// 1. 좋아하는 학생이 많이 인접한 칸 - 찾아서 큐에 넣기
		// 2. 인접 많이 비어있는 칸
		// 3. 위쪽, 왼쪽
		@Override
		public int compareTo(Sinfo o) {
			if(this.likes != o.likes) return o.likes - this.likes; // 내림차순
			else if(this.blanks != o.blanks) return o.blanks - this.blanks;
			else if(this.r != o.r) return this.r - o.r; // 오름차순
			else return this.c - o.c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int n = (int)Math.pow(N, 2);
		List<Integer>[] stuPref = new ArrayList[n+1]; // 1~n+1
		for (int i = 1; i <= n; i++) {
			stuPref[i] = new ArrayList<>();
		}
		int[][] seat = new int[N+1][N+1]; 
		
		for (int i = 1; i <= n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int stuNum = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 4; j++) {
				stuPref[stuNum].add(Integer.parseInt(st.nextToken()));
			}
			
			// 자리 배치
			// 1. 좋아하는 학생이 많이 인접한 칸 - 찾아서 큐에 넣기
			// 2. 인접 많이 비어있는 칸
			// 3. 위쪽, 왼쪽
			
			PriorityQueue<Sinfo> pq = new PriorityQueue<>();
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {

					int maxLikes = 0;
					
					if(seat[r][c]==0) {
						
						int likes = 0;
						int blanks = 0;
						
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr>=1 && nr<=N && nc>=1 && nc<=N) {
								if(seat[nr][nc]==0) blanks++;
								else if(stuPref[stuNum].contains(seat[nr][nc])) likes++;
							}
						}
						
						if(maxLikes > likes) continue;
						maxLikes = Math.max(maxLikes, likes);
						
						pq.add(new Sinfo(r, c, likes, blanks));
					}
				} // for c
			} // for r
			
			
			Sinfo s = pq.poll();
			seat[s.r][s.c] = stuNum;
			
		} // for N
		
		// 만족도 구하기
		int sum = 0;
		for (int r = 1; r <= N ; r++) {
			for (int c = 1; c <= N; c++) {
				int s = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr>=1 && nr<=N && nc>=0 && nc<=N) {
						if(stuPref[seat[r][c]].contains(seat[nr][nc])) s++;
					}
				}
				sum += (int)Math.pow(10, s-1);
			}
		}

		System.out.println(sum);

	}

}

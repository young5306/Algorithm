import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	// 모든 땅에 대해 bfs를 돌면 시간초과가 뜬다.
	// 반대로 물을 기준으로 bfs를 돌면 bfs를 한번만 돌아도 된다.
	// -> 물을 모두 큐에 넣고, 땅을 마주치면 distance 누적, 물을 마주치면 continue

	static boolean[][] visited;
	static int N, M;
	static char[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			Queue<int[]> q = new LinkedList<>();
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char ch = str.charAt(j);
					map[i][j] = ch;
					if (ch == 'W') {
						q.add(new int[] { i, j, 0 });
						visited[i][j] = true;
					}
				}
			}

			int answer = 0;

			while (!q.isEmpty()) {
				int[] place = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = place[0] + dr[d];
					int nc = place[1] + dc[d];
					int curD = place[2];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) { // 땅 마주침
						answer += (curD + 1);
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, curD + 1 }); // 다음 땅 확인하기 위해
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append('\n');

		} // tc 
		System.out.println(sb);
	} // main

}

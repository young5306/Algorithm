
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// cnt: x -> y - 1
	// return cnt + 1
	public static void main(String[] args) throws Exception {
//		for (int d = 1; d <= 100; d++) {
//            int ans = bfs(d);
//            System.out.printf("d=%d -> 최소 이동 횟수=%d\n", d, ans);
//        }
		// 제곱 수 기준 
		// n^2 -> 최소 이동 횟수 = 2n - 1
		// ~ n^2 + n 까지 -> 2^n
		// ~ (n + 1) * (n + 1) 까지 -> 2^n + 1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			
			long dist = y - x;
			long n = (long) Math.sqrt(dist);
			
			long ans = 0;
			if(dist == n * n) {
				ans = 2 * n - 1;
			} else if (dist <= n * n + n) {
				ans = 2 * n;
			} else if  (dist <= (n + 1) * (n + 1)) {
				ans = 2 * n + 1;
			}
			System.out.println(ans);
		}

	}
	
//	static int bfs(int dist) {
//        // 상태: [현재 이동한 거리, 마지막 점프 크기, 사용 횟수]
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{0, 0, 0}); // 시작: 위치 0, 점프 0, 횟수 0
//        boolean[][] visited = new boolean[dist + 1][dist + 2]; 
//        // visited[pos][lastJump]
//
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int pos = cur[0];
//            int jump = cur[1];
//            int cnt = cur[2];
//
//            for (int nextJump = (jump == 0 ? 1 : jump - 1); 
//                 nextJump <= jump + 1; nextJump++) {
//                if (nextJump <= 0) continue; // 음수/0 점프는 무의미
//                int nextPos = pos + nextJump;
//                if (nextPos > dist) continue;
//
//                if (!visited[nextPos][nextJump]) {
//                    visited[nextPos][nextJump] = true;
//                    if (nextPos == dist && nextJump == 1) {
//                        return cnt + 1; // 도착 + 마지막 점프 1
//                    }
//                    q.add(new int[]{nextPos, nextJump, cnt + 1});
//                }
//            }
//        }
//        return -1; // 도달 불가(이 문제에선 나오지 않음)
//    }

}

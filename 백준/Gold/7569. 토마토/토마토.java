
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 델타 배열 (상하좌우앞뒤)
	static int[] dn = { 0, 0, 0, 0, 1, -1 };
	static int[] dm = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int N, M, H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[N][M][H]; // 세로 가로 높이

		Queue<int[]> q = new LinkedList<>();
		int totalTomato = 0; // 바꿔야할 토마토
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int num = Integer.parseInt(st.nextToken());
					tomato[j][k][i] = num;
					if (num == 1)
						q.add(new int[] { j, k, i });
					else if (num == 0)
						totalTomato++;
				}
			}
		}
//		for (int[][] t : tomato) {
//			System.out.println(Arrays.deepToString(t));
//		}
		int level = -1;
		while (!q.isEmpty()) {
//			for (int[] i : q) {
//				System.out.println(Arrays.toString(i));
//			}
			int qs = q.size();
			level++;

			for (int s = 0; s < qs; s++) {
				int[] place = q.poll();
				int n = place[0];
				int m = place[1];
				int h = place[2];

				for (int d = 0; d < 6; d++) {
					int nn = n + dn[d];
					int nm = m + dm[d];
					int nh = h + dh[d];

					if (inRange(nn, nm, nh) && tomato[nn][nm][nh] == 0) {
						tomato[nn][nm][nh] = 1;
						totalTomato--;
						q.add(new int[] { nn, nm, nh });
					}
				}

			}

		}
//		System.out.println(totalTomato);
		System.out.println(totalTomato == 0 ? level : -1);

	}

	static boolean inRange(int nn, int nm, int nh) {
		if (nn >= 0 && nn < N && nm >= 0 && nm < M && nh >= 0 && nh < H) {
			return true;
		}
		return false;
	}

}

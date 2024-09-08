
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int D, W, K; // D:행 3~13, W:열 1~20, K:통과기준1~D 
	static int[][] film; // 보호필름 저장
	static int ans; // 정답(최소 투약 횟수)
	static int[] A, B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			A = new int[W]; // 이미 0으로 초기화 되어 있음
			B = new int[W]; // 전부 1로 만들어 주자
			
			Arrays.fill(B, 1);
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // 입력 완료
			
			ans = K; // 통과기준인 K만큼 쓸 수 있다.
			makefilm(0,0);
			
			System.out.println("#"+tc+" "+ans);
		}

	}
	
	// idx : 현재 약을 주입하려고 하는 행
	// cnt : 약품을 주입한 횟수
	private static void makefilm(int idx, int cnt) {
		if(ans < cnt) return;
		if(idx==D) {
			// 이제 확인을 하겠다.
			if(isOk()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		// 1. 주입 X
		makefilm(idx+1, cnt);
		int[] tmp = film[idx];
		
		// 2. 주입 A
		film[idx] = A;
		makefilm(idx+1, cnt+1);
		// 3. 주입 B
		film[idx] = B;
		makefilm(idx+1, cnt+1);
		
		// 원상복구!
		film[idx] = tmp;
	}
	
	// 모든 열이 연속된 특성 K개 이상인가?
	private static boolean isOk() {
		// 열을 고정시킨 상태에서 검사
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;
			
			for (int r = 1; r < D; r++) {
				if(film[r][c] == film[r-1][c]) cnt++; // 이전과 나와 같다면 카운트
				else cnt = 1;
				
				if(cnt >= K) {
					flag = true;
					break;
				}
			} // 해당 열 검사 완료
			if(!flag) return false; // 해당 열이 통과하지 X. 이후는 볼 필요 X
		} // 모든 열검사 완료
		return true;
	}
	

}

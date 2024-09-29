import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] synergy;
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;
	static int minDiff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			A = new ArrayList();
			// B = new ArrayList();
			A.add(0);
			
			minDiff = 987654321;
			combination(1, 1);
			
			System.out.println("#"+tc+" "+minDiff);
		}

	} // main
	
	static void combination(int idx, int sidx) {
		// 기저 조건
		if(sidx==N/2) {
			B = new ArrayList();
			
			out: for (int i = 0; i < N; i++) {
				for(int a : A) {
					if(i==a) continue out;
				}
				B.add(i);
			}
			int synergyA = 0;
			int synergyB = 0;
			
			for(int a1 : A) {
				for(int a2 : A) {
					synergyA += synergy[a1][a2];
				}
			}
			for(int b1 : B) {
				for(int b2 : B) {
					synergyB += synergy[b1][b2];
				}
			}
			
			minDiff = Math.min(minDiff, Math.abs(synergyA-synergyB));
			return;
		}
		
		// 재귀 부분
		for (int i = idx; i < N; i++) {
			// 선택
			A.add(i);
			combination(i+1, sidx+1);
			// 선택X
			A.remove(sidx); // selected[] 추가적으로 쓰면 안해도 되긴함.
		}
	}

}

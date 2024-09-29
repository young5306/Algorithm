
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> S;
	static ArrayList<Integer> L;
	static int[][] synergy;
	static int N;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		synergy = new int[N][N]; // 0~N-1번
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		S = new ArrayList();
		// L = new ArrayList();
		S.add(0); // 중복 안생기게 0번선수가 있는 곳을 S팀으로 두기
		
		// 조합 
		min = 987654321;
		combination(1, 1); // 1번선수부터(idx) 팀에 넣기(넣은선수의 수 sidx)
		
		System.out.println(min);
	}
	
	static void combination(int idx, int sidx) {
		// 기저 조건
		if(sidx == N/2) {
			// 시너지 계산
			L = new ArrayList();
			out: for (int i = 0; i < N; i++) {
				for(int s : S) {
					if(i == s) continue out;
				}
				L.add(i);
			}
			
			int synergyS = 0;
			int synergyL = 0;
			
			for(int i : S) {
				for(int j : S) {
					synergyS += synergy[i][j];
				}
			}
			
			for(int i : L) {
				for(int j : L) {
					synergyL += synergy[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(synergyS-synergyL));
			return;
		}
		
		// 재귀 부분
		for (int i = idx; i < N; i++) {
			// S에 선수 포함
			S.add(i);
			combination(i+1, sidx+1);
			// 선수 포함X 
			S.remove(sidx);
		}
	}

}

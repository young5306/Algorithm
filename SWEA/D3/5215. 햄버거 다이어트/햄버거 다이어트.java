
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L, max;
	static Ingredient[] ing;
	
	static class Ingredient {
		int t;
		int c;
		
		public Ingredient() {}
		public Ingredient(int t, int c) {
			this.t = t;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ing = new Ingredient[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ing[i] = new Ingredient(t, c);
			}
			
			// dfs
			max = 0; // 최대점수
			dfs(0, 0, 0); // 인덱스(중복x), 맛점수합, 칼로리합 
			
			System.out.println("#"+tc+" "+max);
		}
	}
	
	public static void dfs(int idx, int scoreSum, int calSum) {
		// 기저 조건
		if(calSum > L) return;
		if(idx == N) {
			if(calSum <= L) max = Math.max(max, scoreSum);
			return;
		}
		
		// 선택한 경우
		dfs(idx+1, scoreSum + ing[idx].t, calSum + ing[idx].c);
		// 선택x
		dfs(idx+1, scoreSum, calSum);
	}

}

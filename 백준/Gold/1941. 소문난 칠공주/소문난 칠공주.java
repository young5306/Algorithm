

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// selected, visited (체크하는 배열) -> 1차배열로 풀기
// => 장점 : 69번줄에서 for문 7번만 돌아도 됨
public class Main {
	
	static char[][] stu;
	static int[] selected = new int[7]; // 1차배열 (-> 2차배열로 바꾸기 [i/5][i%5])
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stu = new char[5][5];
		for (int i = 0; i < 5; i++) {
			stu[i] = br.readLine().toCharArray(); // 한줄로 작성 가능
		} // 입력 완료
		
		// 1. 7명 고르기 (조합)
		cnt = 0;
		bt(0,0,0); // depth(sidx), numY, start(idx)
		
		System.out.println(cnt);
	} // main
	
	static void bt(int depth, int numY, int start) {
		// 기저 조건
		if(numY>=4) return;
		
		if(depth==7) {
			bfs();
			return;
		}
		
		// 재귀 부분
		for (int i = start; i < 25; i++) {
			// 선택O
			selected[depth] = i;
			if(stu[i/5][i%5]=='Y') bt(depth+1, numY+1, i+1);
			else bt(depth+1, numY, i+1);
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[7]; 
		q.add(new int[] {selected[0]/5, selected[0]%5}); 
		visited[0] = true;
		int pick = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int ni = nr*5 + nc;
				
				if(!isValid(nr, nc)) continue;
				
				for (int i = 0; i < 7; i++) { // selected 모두 돌면서 인접한 공주있는지 확인 
					if(!visited[i] && selected[i] == ni) {
						visited[i] = true;
						pick++;
						q.add(new int[] {nr, nc});
					}
				}
				
			}
		}
		
		if(pick==7) cnt++;
		
	}
	
	static boolean isValid(int r, int c) {
		if(r>=0 && r<5 && c>=0 && c<5) return true;
		else return false;
	}

}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer> use0;
	static ArrayList<Integer> use1;
	static int[][] distance;
	static int n, min, stair0Len, stair1Len;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백트랙킹으로 모든 경우 고려 (2^10) => 계단1을 쓰거나 계단2를 쓰거나
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			// 사람 위치 리스트
			// 계단 정보 리스트(배열 가능)
			ArrayList<int[]> person = new ArrayList<>(); // {x,y}
			ArrayList<int[]> stair = new ArrayList<>(); // {x,y,계단길이k}
			
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num==1) {
						person.add(new int[] {i,j});
					} else if (num!=0) {
						stair.add(new int[] {i,j,num});
					}
				}
			}
			
			// 사람마다 각 계단 도착 시간 저장해두기 (최종 도착x) 
			n = person.size();
			distance = new int[2][n];
			stair0Len = stair.get(0)[2];
			stair1Len = stair.get(1)[2];

			int stair0R = stair.get(0)[0];
			int stair0C = stair.get(0)[1];
			int stair1R = stair.get(1)[0];
			int stair1C = stair.get(1)[1];
			
			for (int i = 0; i < n; i++) {
				distance[0][i] = getDis(stair0R, stair0C, person.get(i)[0], person.get(i)[1]);
				distance[1][i] = getDis(stair1R, stair1C, person.get(i)[0], person.get(i)[1]);
			}
			
			use0 = new ArrayList<>();
			use1 = new ArrayList<>();
			min = Integer.MAX_VALUE;
			bt(0);
			
			System.out.println("#"+tc+" "+min);
		} // tc

	} // main
	
	static void bt(int idx) {
		// 기저 조건
		if(idx == n) {
			min = Math.min(calcTime(), min);
			return;
		}
		
		// 재귀 부분
		use0.add(distance[0][idx]);
		bt(idx + 1);
		use0.remove(Integer.valueOf(distance[0][idx])); 
		// 하나만 삭제 (정렬할거라 마지막 인덱스 삭제하면 안됨)
		// ** use0.remove(distance[0][idx]); 이렇게 하면 index로 제거됨
		
		use1.add(distance[1][idx]);
		bt(idx + 1);
		use1.remove(Integer.valueOf(distance[1][idx]));
		
	}
	
	static int calcTime() {
		// 계단 도착 시간 이른것부터 정렬
		Collections.sort(use0);
		Collections.sort(use1);
		
		// peekLast 쓰려고 deque 씀
		// 계단에서 출발하는 시간을 저장
		Deque<Integer> dq = new ArrayDeque<>(); 
		
		for (int i = 0; i < use0.size(); i++) {
			if(dq.size()<3) {
				dq.add(use0.get(i)+1);
			} else {
				dq.add(Math.max(use0.get(i)+1, dq.poll()+stair0Len));
			}
		}
		
		int t1 = dq.isEmpty() ? 0 : dq.peekLast()+stair0Len;
		
		dq.clear();
		
		for (int i = 0; i < use1.size(); i++) {
			if(dq.size()<3) {
				dq.add(use1.get(i)+1);
			} else {
				dq.add(Math.max(use1.get(i)+1, dq.poll()+stair1Len));
			}
		}
		
		int t2 = dq.isEmpty() ? 0 : dq.peekLast()+stair1Len;
		
		return Math.max(t1, t2);
	}
	
	
	static int getDis(int stairR, int stairC, int x, int y) {
		return Math.abs(stairR-x) + Math.abs(stairC-y);
	}

}

// (Deque) https://soft.plusblog.co.kr/24
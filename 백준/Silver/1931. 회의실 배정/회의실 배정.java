

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		public Meeting (int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end != o.end) return this.end - o.end; // 오름차순
			else return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// 끝나는 시간 짧은 순으로 꺼내기
		int cnt = 0;
		int endTime = 0;
		
		while(!pq.isEmpty()) {
			Meeting m = pq.poll(); 
			if(m.start < endTime) continue;
			
			cnt++;
			endTime = m.end;
		}
		
		System.out.println(cnt);
	}

}

// 시작 시간 정렬해야함 - 시작시간=종료시간인 회의 고려해야함
/*
3
4 4
1 4
5 7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	// 상우하좌 델타배열
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] ocean = new int[N][N];
		StringTokenizer st;
		
		int sharkR = 0;
		int sharkC = 0;
		int totalFish = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==9) {
					sharkR = i;
					sharkC = j;
					num = 0;
				} else if (num!=0) {
					totalFish++;
				}
				ocean[i][j] = num;
			}
		} // 입력 완료


		// 가장 가까운 물고리 여러마리면 - 가장 위쪽, 가장 왼쪽 순 -> pq 정렬 기준 설정
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0]; // 1순위 : 작은 r (상)
				} else {
					return o1[1] - o2[1]; // 2순위 : 작은 c (좌)
				}
			}
		});
		
		
		// bfs
		// 1. 하나 꺼내고 근처 영역(방문X) pq2에 담음
		// 2. level(거리)마다 물고기 있는지 확인, 그 주변 영역 pq2에 담기(visited)
		// 3. poll - visited, 작은 물고기 있으면 먹고 / bfs 초기화해서 다시 시작 (visited 초기화)
		// 		   					   없으면 다음 pq=pq2 담아서 다음 level 돌기
		
		boolean[][] visited = new boolean[N][N];
		pq.add(new int[]{sharkR, sharkC});
		visited[sharkR][sharkC] = true;
		int sharkSize = 2;
		int eat = 0;
		int totalTime = 0;
		int time  = -1;
		
		out:while(totalFish>0) {
			
			int size = pq.size();
			
			PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] != o2[0]) {
						return o1[0] - o2[0]; // 1순위 : 작은 r
					} else {
						return o1[1] - o2[1]; // 2순위 : 작은 c
					}
				}
			}); 
			
			time++;
			
			for (int s = 0; s < size; s++) {
				
				int[] place = pq.poll();
				int r = place[0];
				int c = place[1];
				
				if(ocean[r][c]!=0 && (ocean[r][c] < sharkSize)) {
					
					// 작은 물고기 있으면 먹고, bfs 초기화하여 다시 돌림
					// 자신의 크기와 같은수의 물고기를 먹어야 크기 1 커짐
					eat++;
					if(eat == sharkSize) {
						sharkSize++;
						eat=0;
					}
					totalFish--;
					visited = new boolean[N][N];
					while(!pq.isEmpty()) {
						pq.poll();
					}
					while(!pq2.isEmpty()) {
						pq2.poll();
					}
					pq2.add(new int[] {r, c});
					visited[r][c] = true;
					ocean[r][c] = 0;
					
					totalTime += time;
//					System.out.println(r+","+c+", time:"+time+":"+totalTime);
					time = -1;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && ocean[nr][nc] <= sharkSize) {
						pq2.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
				
			} // for s

			if(pq2.isEmpty()) {
				break out;
			}

			pq = pq2;
			
		} // while
		
		
		System.out.println(totalTime);

	} // for main

}

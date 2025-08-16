import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1}; // 좌상부터
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

	static class Node {
		int x;
		int y;
		int depth;
		
		Node(){}
		Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			int L = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cX = Integer.parseInt(st.nextToken());
			int cY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int nX = Integer.parseInt(st.nextToken());
			int nY = Integer.parseInt(st.nextToken());
			
			// 몇번만에 이동 (level 있는 bfs)
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(cX, cY, 0));
			boolean[][] visited = new boolean[L][L];
			visited[cX][cY] = true;
			
			int minMove = 0;
			
			out: while(!q.isEmpty()) {
				Node cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				int depth = cur.depth;
				
				for(int d = 0; d < dr.length; d++) {
					int nx = x + dr[d];
					int ny = y + dc[d];
					
					if(nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny, depth + 1));
						
						if(nx == nX && ny == nY) {
							minMove = depth + 1;
							break out;
						}
					}
				}
			}
			sb.append(minMove).append("\n");
		}
		
		System.out.println(sb);
	}

}

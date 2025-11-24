import java.util.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        
        // bfs
        
        // 1. 시작점 찾기
        int n = board.length;
        int m = board[0].length();
        int sr = 0;
        int sc = 0;
        
        out: for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    sr = i;
                    sc = j;
                    break out;
                }
            }
        }
        
        // 2. bfs
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        q.add(new int[]{sr, sc});
        visited[sr][sc] = 1; // 값 - 1 번 이동
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                while(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr].charAt(nc) != 'D') {
                    nr += dr[d];
                    nc += dc[d];
                }
                
                nr -= dr[d]; // 직전
                nc -= dc[d];
                
                // 목표 지점이면 중단
                if(board[nr].charAt(nc) == 'G') {
                    return visited[cr][cc];
                }
                
                // 목표 지점x -> 도착까지 횟수 갱신
                if(visited[nr][nc] == 0) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = visited[cr][cc] + 1;
                }
            }
        }
        
        return -1;
    }
}
import java.util.*;

class Solution {
    
    static int[][] strg;
    static int n, m;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        
        // int[][] 변환
        n = storage.length;
        m = storage[0].length();
        strg = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                strg[i][j] = storage[i].charAt(j) - '0';
            }
        }
        
        // 요청 처리
        for(int i = 0; i < requests.length; i++) {
            int chNum = requests[i].charAt(0) - '0';
            boolean one = requests[i].length() == 1 ? true : false;
            
            if(one) {
                // A인 경우 요청 처리
                shipOne(chNum);
            } else {
                // AA인 경우 요청 처리
                shipAll(chNum);
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(strg[i][j] == -1) continue;
                answer++;
            }
        }
        
        return answer;
    }
    
    static void shipOne (int chNum) {
        // 임시 삭제: -2, 영구 삭제: -1
        
        // 1. 임시 삭제
        bfs(chNum);
        
        // 2. 영구 삭제
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(strg[i][j] == -2) {
                    strg[i][j] = -1;
                }
            }
        }
    }
    
    static void shipAll(int chNum) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(strg[i][j] == chNum) {
                    strg[i][j] = -1;
                }
            }
        }
    }
    
    static void bfs(int chNum) {
        // bfs
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 2][m + 2]; // 테두리 +1 씩 늘림 (i,j) -> strg[i - 1][j - 1]
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= (n + 2) || nc >= (m + 2)) continue;
                if(nr == 0 || nc == 0 || nr == (n + 1) || nc == (m + 1)) { // 테두리
                    if(!visited[nr][nc]) {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                } else { // 테두리 x
                    if(!visited[nr][nc]) {
                        if(strg[nr - 1][nc - 1] == -1) { // 빈공간
                            q.add(new int[]{nr, nc});
                        } else if(strg[nr - 1][nc - 1] == chNum) {
                            strg[nr - 1][nc - 1] = -2;
                        }
                        visited[nr][nc] = true;
                    }
                }
                
                
            }
            
        }
    }
    
}
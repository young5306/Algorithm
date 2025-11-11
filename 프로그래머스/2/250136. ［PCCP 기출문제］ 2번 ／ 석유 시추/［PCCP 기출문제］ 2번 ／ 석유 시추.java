import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] groupId;
    static final int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static final int[] dc = {0, 0, 1, -1};

        
    public int solution(int[][] land) {

        N = land.length;
        M = land[0].length;
        ArrayList<Integer> sizeList = new ArrayList<>(); // 덩어리 사이즈 저장 (인덱스는 groupId)
        
        groupId = new int[N][M]; // 각 칸이 속한 덩어리그룹 id 저장
        for(int[] row : groupId) Arrays.fill(row, -1); 
        int id = 0; // 덩어리 id는 0번 부터 (빈칸은 -1)
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(land[r][c] == 1 && groupId[r][c] == -1) {
                    int s = bfs(land, r, c, id);
                    sizeList.add(s);
                    id++;
                }
            }
        }
        
        // System.out.println(sizes.size());
        
        int max = 0; 
        for(int c = 0; c < M; c++) { 
            Set<Integer> set = new HashSet<>(); // 덩어리id 중복없이 저장 
            for(int r = 0; r < N; r++) { 
                if(groupId[r][c] == -1) continue; 
                set.add(groupId[r][c]); 
            } 
            
            int sum = 0; 
            for(int g : set) { 
                sum += sizeList.get(g); 
            } 
            max = Math.max(sum, max); 
        } 
        
        return max;
        
    }
    
    static int bfs(int[][] land, int r, int c, int id){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        groupId[r][c] = id;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                // groupId -1이면 방문한 적 없는 곳
                if (nr >= 0 && nc >= 0 && nr < N && nc < M 
                    && groupId[nr][nc] == -1 && land[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    groupId[nr][nc] = id;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
       
        // 네트워크 수 구하기 bfs
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            
            q.add(i);
            cnt++;
            while(!q.isEmpty()) {
                int num = q.poll();
                visited[num] = true;

                for(int j = 0; j < n; j++) {
                    if(computers[num][j] == 0 || visited[j]) continue;
                    q.add(j);
                }
            }
        }

        return cnt;
    }
}
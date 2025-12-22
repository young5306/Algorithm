import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(destination);
        dist[destination] = 0;
        
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int nxt : adj[cur]) {
                if(dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            int idx = sources[i];
            answer[i] = dist[idx];
        }
        
        return answer;
    }
}
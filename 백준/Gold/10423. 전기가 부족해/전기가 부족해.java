
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int A;
        int B;
        int W;
        public Edge(int a, int b, int w) {
            super();
            A = a;
            B = b;
            W = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.W - o.W;
        }
    }
    
    static int[] p;
    
    public static void main(String[] args) throws Exception {
        // 모든 도시에 전기 공급 - 프림 or 유니온 파인드
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Edge>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(a, b, w));
            adj[b].add(new Edge(b, a, w));
        } // 입력 완료
        
        // 발전소/발전소 연결 도시 p = 0으로 표시
        // 필요 1) p : 연결됐는지 확인하면서 도시 돌기
        //     2) visited : 각 도시 돌 때, cycle 안생기도록
        //     3) pq : 가장 작은 가중치 선택
        // 1. 발전소 아닌, 발전소나 발전소 연결 도시에 연결안된 
        // 1~N 도시 돌면서 가장 작은 가중치 간선 선택
        // 2. 발전소 마주치면 연결된 것 모두 0으로 표시
        
        p = new int[N+1];
        for (int i = 1; i <= N; i++) {
        	if(set.contains(i)) p[i]=0;
        	else p[i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(p[i]==0) continue; // 발전소이거나, 이미 발전소와 연결됐으면 continue
            
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            for(Edge e : adj[i]) {
                pq.add(e);
            }
            
            while(!pq.isEmpty()) {
                Edge edge = pq.poll();
                if(visited[edge.B]) continue;

//                System.out.println(edge.A+","+edge.B);
//                System.out.println(Arrays.toString(p));
                // 발전소나, 발전소와 연결된 도시면 break
                ans += edge.W;
                if(p[edge.B] == 0) {
                	// 그동안 연결된 점들의 p를 모두 0으로 바꾸기
                	for (int j = 1; j <= N; j++) {
						if(p[j] == i) p[j] = 0;
					}
                	break;
                } 
                // 연결 안된 도시면 while 계속 반복해야 함.
                visited[edge.B] = true; 
                p[edge.B] = i;
                for(Edge e : adj[edge.B]) {
                	if(!visited[e.B]) {
                		pq.add(e);
                	}
                }
            }
        }
        
        System.out.println(ans);
    }

}


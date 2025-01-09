import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // bfs
        // N에서 시작해서 -1, +1, *2인 위치에 시간 저장 => K 도달
        if(N==K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    } // main

    static void bfs(int N){
        int[] time = new int[100001]; // 0~100000
        Queue<Integer> q = new LinkedList<>();
        time[N] = 1; // 최종 결과는 time[n]-1
        q.add(N);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<3; i++){
                int next = 0;
                if(i==0){ // +1
                    next = cur + 1;
                } else if (i==1){
                    next = cur - 1;
                } else {
                    next = cur * 2;
                }

                if(next == K) {
                    System.out.println(time[cur]);
                    return;
                }
                if(next>=0 && next<=100000 && time[next]==0){
                    q.add(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
    }
}

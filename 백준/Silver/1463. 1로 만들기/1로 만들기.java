
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        // bfs?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[N+1]; // 1~10^6 // 연산횟수 저장
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        cnt[N] = 1; // 실제로는 0

        while(!q.isEmpty()){
            int cur = q.poll();

            if (cur == 1) break;

            if(cur%3==0 && cnt[cur/3]==0) { // 3의 배수
                cnt[cur/3] = cnt[cur]+1;
                q.add(cur/3);
            }
            if(cur%2==0 && cnt[cur/2]==0) { // 2의 배수
                cnt[cur/2] = cnt[cur]+1;
                q.add(cur/2);
            }
            if(cur-1>=1 && cnt[cur-1]==0) {
                cnt[cur-1] = cnt[cur]+1;
                q.add(cur-1);
            }
        }

        System.out.println(cnt[1]-1);

    }
}

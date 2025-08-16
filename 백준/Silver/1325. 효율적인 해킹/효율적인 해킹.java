

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] cnt;
    static int[] visited; // 세대 마킹용
    static int mark = 0;

    public static void main(String[] args) throws Exception {
        // A가 B를 신뢰 = B -> A : 역방향 그래프 BFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Integer>[] conn = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            conn[y].add(x); // 역방향 간선: B -> A
        }

        cnt = new int[N + 1];
        visited = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            mark++;                 // 이번 시작점의 방문 표시 값
            visited[i] = mark;

            int tot = 0;            // 방문 수(자기 자신 포함; 비교엔 영향 없음)

            while (!q.isEmpty()) {
                int n = q.poll();
                tot++;

                for (int num : conn[n]) {
                    if (visited[num] == mark) continue;
                    visited[num] = mark;
                    q.add(num);
                }
            }

            cnt[i] = tot;
            if (tot > max) max = tot;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == max) sb.append(i).append(' ');
        }
        System.out.print(sb.toString().trim());
    }
}

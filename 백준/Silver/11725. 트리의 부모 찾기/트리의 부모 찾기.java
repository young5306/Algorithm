

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N + 1];

		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		p[1] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int i : adj[v]) {
				if (p[i] != 0)
					continue;
				p[i] = v;
				q.add(i);
			}
		}
		
		for (int i = 2; i <= N; i++) {
			sb.append(p[i]).append("\n");
		}
		
		System.out.println(sb);

	}

}



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> dud = new HashSet<>();
		Set<String> result = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			dud.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(dud.contains(name)) {
				result.add(name);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for(String s : result) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}

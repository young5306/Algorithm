

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		// 1234567
		sb.append("<");
		int nextIdx = K-1;
		while(!list.isEmpty()) {
			
			int nidx = nextIdx%list.size();
			sb.append(list.get(nidx));
			
			nextIdx = nidx + K -1;
			
			list.remove(nidx);

			if(list.size() != 0) sb.append(", ");
		}
		sb.append(">");
		
		System.out.println(sb);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 중복X, 순서O -> 순열

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new TreeMap<>(); // <값, 개수>
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		
		int[] sel = new int[M];
		
		perm(map, sel, M, 0);
		
		System.out.println(sb);
	}
	
	public static void perm(Map<Integer, Integer> map, int[] sel, int M, int sidx) {
		// 기저 조건
		if(sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀 부분
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()>0) {
				map.put(entry.getKey(), entry.getValue()-1);
				sel[sidx] = entry.getKey();
				perm(map, sel, M, sidx+1);
				map.put(entry.getKey(), entry.getValue()+1);
			}
		}
	}

}

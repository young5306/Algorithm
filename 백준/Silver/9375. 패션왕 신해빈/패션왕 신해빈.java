

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 부분집합 dfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int n = Integer.parseInt(br.readLine());

			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String oth = st.nextToken();
				if(map.containsKey(oth)) {
					map.put(oth, map.get(oth)+1);
				} else {
					map.put(oth, 2); // 선택x경우 포함
				}
			}

			int cnt = 1;
			for (Map.Entry<String,Integer> m : map.entrySet()) {
				cnt *= m.getValue();
			}

			System.out.println(cnt-1); // 공집합인 경우
		}

	}


}

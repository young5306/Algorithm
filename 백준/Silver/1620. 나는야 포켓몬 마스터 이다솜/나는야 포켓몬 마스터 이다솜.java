

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> stringKey = new HashMap<>();
		Map<Integer, String> intKey = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			stringKey.put(input, i);
			intKey.put(i, input);
		}
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			char ch = input.charAt(0);
			if(ch>='0' && ch<='9') {
				int num = Integer.valueOf(input);
				sb.append(intKey.get(num)).append("\n");
			} else {
				sb.append(stringKey.get(input)).append("\n");				
			}
		}
		
		System.out.println(sb);
	}
}

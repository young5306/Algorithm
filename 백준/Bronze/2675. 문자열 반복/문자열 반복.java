

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < N; k++) {
					sb.append(str.charAt(j));
				}
			}
		
			System.out.println(sb);
		}
		
	}

}

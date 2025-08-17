import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			
			int flag = 0;
			int score = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'O') {
					flag++;
					score += flag;
				}
				else {
					flag = 0;
				}
			}
			sb.append(score).append("\n");
		}
		
		System.out.println(sb);
	}

}

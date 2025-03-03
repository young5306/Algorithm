
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int X = (1<<N) - 1;
			
			sb.append("#").append(i).append(" ");
			if((M & X) == X) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

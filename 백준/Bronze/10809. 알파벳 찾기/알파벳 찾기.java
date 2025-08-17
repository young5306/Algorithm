
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] first = new int[26];
		Arrays.fill(first, -1);
		for(int i = 0; i < str.length(); i++) {
			int alphabet = str.charAt(i) - 'a';
			if(first[alphabet] == -1) first[alphabet] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < first.length; i++) {
			sb.append(first[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}

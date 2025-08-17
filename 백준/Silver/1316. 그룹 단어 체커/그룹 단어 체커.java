import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			
			boolean flag = true;
			Set<Character> set = new HashSet<>();
			Character prev = 0;
			for(int i = 0; i < str.length(); i++) {
				Character ch = str.charAt(i);
				if(prev != ch) {
					prev = ch;
					if(set.contains(ch)) {
						flag = false;
						break;
					} else {
						set.add(ch);
					}
				}
			}
			
			if(flag) answer++;
		}
		
		System.out.println(answer);
	}

}

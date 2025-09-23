
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// - 뒤에 나오는 +는 다 묶음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int answer = 0;
		int sum = 0;
		int cur = 0;
		int idx = 1;
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				cur += (str.charAt(i) - '0') * idx;
				idx *= 10;
//				System.out.println("수 " + cur);
			} else if (str.charAt(i) == '+') {
				sum += cur;
				cur = 0;
				idx = 1;
//				System.out.println("+ " + sum);
			} else if (str.charAt(i) == '-') {
				answer -= (sum + cur);
				sum = 0;
				cur = 0;
				idx = 1;
//				System.out.println("- " + answer);
			}
		}
//		if(answer == 0) {
//			answer += (sum + cur);
//		} else {
//			answer += cur;
//		}
		answer += (sum + cur);
		
		System.out.println(answer);
		
	}

}

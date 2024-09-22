import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		// 5부터 쓰기
		while(N>0) {
			if(N%5==0) {
				ans += N/5;
				break;
			} else {
				N-=3;
				ans++;
			}
			
			if(N<0) ans = -1;
		}
		
		System.out.println(ans);
	} // main

}

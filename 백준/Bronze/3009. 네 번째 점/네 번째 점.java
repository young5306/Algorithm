import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x = 0;
		int y = 0;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			x ^= Integer.parseInt(st.nextToken());
			y ^= Integer.parseInt(st.nextToken());
		}
		
		System.out.println(x+" "+y);
	}
}

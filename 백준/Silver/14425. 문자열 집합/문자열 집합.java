
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			if(list.contains(br.readLine())) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}

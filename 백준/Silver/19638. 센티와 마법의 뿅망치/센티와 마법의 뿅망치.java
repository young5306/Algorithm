
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int used = 0;
		while(used < T) {
			int top = pq.peek();
			
			if(top < H) break;
			if(top == 1) break;
			
			pq.poll();
			pq.add(top / 2);
			used++;
		}
		
		int tallest = pq.peek();
		
		if(tallest < H) {
			System.out.println("YES");
			System.out.println(used);
		} else {
			System.out.println("NO");
			System.out.println(tallest);
		}
	}

}

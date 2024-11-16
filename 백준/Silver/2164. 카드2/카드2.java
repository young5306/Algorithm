
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			// 한장 버려
			q.poll();
			if(q.size()==1) break;
			// 한장 뒤로 옮겨
			int num = q.poll();
			q.add(num);
		}
		
		System.out.println(q.poll());
	}

}

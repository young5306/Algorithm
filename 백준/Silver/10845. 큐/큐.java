
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			switch(instruction) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				dq.add(num);
				break;
			case "pop" : 
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pollFirst()).append("\n");
				break;
			case "size" :
				sb.append(dq.size()).append("\n");
				break;
			case "empty" :
				if(dq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front" : 
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekFirst()).append("\n");
				break;
			case "back" :
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekLast()).append("\n");
				break;
			}			
		}
		
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String instr = st.nextToken();
			
			switch(instr) {
			case "push" :
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case "pop" : 
				if(!stack.isEmpty()) sb.append(stack.pop()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size" :
				sb.append(stack.size()).append("\n");
				break;
			case "empty" :
				if(stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "top" :
				if(!stack.isEmpty()) sb.append(stack.peek()).append("\n");
				else sb.append(-1).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}

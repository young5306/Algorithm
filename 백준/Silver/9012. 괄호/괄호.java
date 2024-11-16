import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if(ch == '(') {
					stack.add(ch);
				} else {
					if(stack.isEmpty()) {
						flag = false;
					} else if(stack.peek()=='(') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) flag = false;
			
			System.out.println(flag?"YES":"NO");
			
		}

	}

}

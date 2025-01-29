

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws Exception {
		// stack 사용
		// ( [면 push
		// ] ) 이면 peek로 동일한지 확인 후 pop
		// .나올때까지 진행 -> stack 비어있으면 yes
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		while(!str.equals(".")) {
			
			// 균형 확인			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '(' || ch == '[') stack.push(ch);
				else if(ch == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
				else if(ch == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty()) flag = false;

			sb.append(flag==true?"yes":"no").append("\n");
			str = br.readLine();
		}
		
		System.out.println(sb);
	}

}

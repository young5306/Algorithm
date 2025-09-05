
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
	// 분배법칙...
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		int val = 1;
		boolean flag = true;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == '(') {
				stack.push(ch);
				val *= 2;
			} else if (ch == '[') {
				stack.push(ch);
				val *= 3;
			} else if (ch == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					flag = false;
					break;
				}
				if(str.charAt(i - 1) == '(') {
					ans += val;
				}
				stack.pop();
				val /= 2;
			} else if (ch == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					flag = false;
					break;
				}
				if(str.charAt(i - 1) == '[') {
					ans += val;
				}
				stack.pop();
				val /= 3;
			}
//			System.out.println(ans);
		}
		
		if(!stack.isEmpty()) flag = false;
		
		System.out.println(flag ? ans : 0);
	}

}

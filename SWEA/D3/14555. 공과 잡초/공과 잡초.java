import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			Stack<Character> stack = new Stack<>();
			
			String str = sc.next();
			
			int cnt  = 0;
			for(int i=0; i<str.length(); i++) {
				if (str.charAt(i) == '(') { // (| 인 경우, ()인 경우
					cnt++;
				}
				else if (str.charAt(i) == ')') { // |)인 경우
					if(stack.peek() == '|') {
						cnt++;
					}
				}
				stack.push(str.charAt(i));
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}

	}

}

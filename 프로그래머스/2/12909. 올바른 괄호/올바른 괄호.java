import java.util.Stack;


class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
			if(stack.isEmpty() && ch==')') { // )먼저 나올때
				answer = false;
				break;
			} else if (ch=='(') {
				stack.push(ch);
			} else if(ch==')') {
				stack.pop();
			}
		}
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayDeque<Integer> dq = new ArrayDeque();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
//			System.out.println("num: "+ num);
			if(num==0) {
				dq.pollLast();
			} else {
				dq.addLast(num);
			}
//			System.out.println(dq.peekLast());
		}
		int result = 0;
		while(!dq.isEmpty()) {
			result += dq.poll();
		}
		
		System.out.println(result);
	}

}

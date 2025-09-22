
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			// maxPQ 개수가 minPQ보다 적거나 동일하면 maxPQ에
			if(maxPQ.size() <= minPQ.size()) {
				maxPQ.add(n);
			} else {
				minPQ.add(n);
			}
			
			if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				int tmp = maxPQ.poll();
				maxPQ.add(minPQ.poll());
				minPQ.add(tmp);
			}
			
			sb.append(maxPQ.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}

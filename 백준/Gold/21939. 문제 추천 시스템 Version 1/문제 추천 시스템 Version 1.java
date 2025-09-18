
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	static class Problem implements Comparable<Problem> {
		int p;
		int l;
		Problem(){}
		Problem(int p, int l) {
			this.p = p;
			this.l = l;
		}
		@Override
		public int compareTo(Problem o) {
			if(this.l == o.l) {
				return this.p - o.p;
			}
			return this.l - o.l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		TreeSet<Problem> set = new TreeSet<>();
		int[] levelArr = new int[100001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			set.add(new Problem(p, l));
			levelArr[p] = l;
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				set.add(new Problem(p, l));
				levelArr[p] = l;
			} else if(op.equals("recommend")) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					Problem prob = set.last();
					System.out.println(prob.p);
				} else if (n == -1) {
					Problem prob = set.first();
					System.out.println(prob.p);
				}
			} else if(op.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				int l = levelArr[p];
				set.remove(new Problem(p, l));
				levelArr[p] = 0;
			}
		}
	}

}

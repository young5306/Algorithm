
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Member implements Comparable<Member>{
		int id;
		int age;
		String name;

		public Member(int id, int age, String name){
			this.id = id;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			if(this.age != o.age) {
				return this.age - o.age; // 오름차순
			} else {
				return this.id - o.id; 
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Member> list = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list);
		
		for (Member m : list) {
			System.out.println(m.age + " " + m.name);
		}
		
	}

}

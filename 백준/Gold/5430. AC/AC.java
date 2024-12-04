

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			Deque<Integer> dq = new ArrayDeque<>();
			for(String s : str.substring(1, str.length()-1).split(",")) { // split은 배열 반환
				if(!s.equals("")) dq.add(Integer.parseInt(s));
			}
			
			System.out.println(ac(dq, p));
			
		}
	}
	
	public static String ac(Deque<Integer> dq, String p) {
		boolean dir = true; // 정방향
		for(char ch : p.toCharArray()) {
			if(ch == 'R') {
				dir = !dir;
			} 
			else {
				if(dq.size() == 0) return "error";
				if(dir) dq.removeFirst();
				else dq.removeLast();
			}
		}
		
		StringBuilder sb = new StringBuilder("[");
		if(dir && !dq.isEmpty()) {
			sb.append(dq.removeFirst());
			while(!dq.isEmpty()) {
				sb.append(",");
				sb.append(dq.removeFirst());
			}
		} else if(!dir && !dq.isEmpty()) {
			sb.append(dq.removeLast());
			while(!dq.isEmpty()) {
				sb.append(",");
				sb.append(dq.removeLast());
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
} 

/*[],으로 쪼개서 입력 받기

1. st 사용
StringTokenizer st = new StringTokenizer(str, "[],");
while(st.hasMoreTokens()) {
	dq.add(Integer.parseInt(st.nextToken()));
}

2. split (위 코드)

*/

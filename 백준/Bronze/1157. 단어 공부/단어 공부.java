import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Map<Character, Integer> map = new TreeMap<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'Z') ch = (char) (ch - 'A' + 'a'); // (a - A = b - B)
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		int max = 0;
		for(int v : map.values()) {
			max = Math.max(max, v);
		}
		
		int cnt = 0;
		char key = ' ';
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
//			System.out.println(e.getKey());
			if(e.getValue() == max) {
				cnt++;
				key = e.getKey();
			}
			
		}
		
		System.out.println(cnt == 1 ? (char) (key - 'a' + 'A') : '?');
	}

}

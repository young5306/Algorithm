
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new TreeMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		String str;
		while((str = br.readLine()) != null) { // EOF (End Of File) 처리 방법
			if(str.equals("")) break;
			map.put(str, map.getOrDefault(str, 0) + 1);
			cnt++;
		}
		
		for(Map.Entry<String, Integer> ent : map.entrySet()) {
			System.out.printf("%s %.4f\n", ent.getKey(), ((float) ent.getValue()) * 100 / ((float) cnt));
		}
		
	}

}
// BufferedReader.readLine()은 입력이 끝나면 null을 반환

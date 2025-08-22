
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new TreeMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tot = 0;
		String str;
		while((str = br.readLine()) != null) { // EOF (End Of File) 처리 방법
			if(str.equals("")) break;
			map.put(str, map.getOrDefault(str, 0) + 1);
			tot++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> ent : map.entrySet()) {
			float val = (float) (ent.getValue() * 100.0 / tot);
			sb.append(ent.getKey()).append(" ").append(String.format("%.4f", val)).append("\n");
		}
		
		System.out.println(sb);
	}

}
// BufferedReader.readLine()은 입력이 끝나면 null을 반환

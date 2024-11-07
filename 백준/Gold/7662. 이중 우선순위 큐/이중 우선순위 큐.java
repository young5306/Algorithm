
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main { 
	
	static TreeMap<Integer, Integer> tmap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			
			tmap = new TreeMap<>();
			
			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				switch (str) {
				case "I":
					tmap.compute(num, (key, value) -> value==null?1:value+1);
					break;
				case "D":
					if (tmap.size()!=0) {
						// num==1 최대값 삭제
						tmap.compute(num==1?tmap.lastKey():tmap.firstKey(),
								(key, value) -> value>1?value-1:null);
					}
					break;
					
				}

			}
			
			if(!tmap.isEmpty()) {
				sb.append(tmap.lastKey()).append(' ').append(tmap.firstKey());
			} else {
				sb.append("EMPTY");
			}
			sb.append('\n');
			
		}
		System.out.println(sb);
	}


}
/* 트리맵
(키, 값) 저장
자동 오름차순 정렬
map.put(,)
map.remove(키)
map.clear()
map.firstEntry(), lastEntry() 
map.firstKey(), lastKey()

map.compute("key1", (key, value) -> (value == null) ? 1 : value + 1);
key가 존재하지 않으면 새로 추가, 있으면 value+1로 갱신

null이면 삭제를 의미함.

*/

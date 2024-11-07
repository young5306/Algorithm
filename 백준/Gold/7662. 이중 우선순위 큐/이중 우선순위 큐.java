
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

		for (int tc = 0; tc < T; tc++) {
			
			tmap = new TreeMap<>();
			
			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				switch (str) {
				case "I":
					if(tmap.containsKey(num)) {
						tmap.put(num, tmap.get(num)+1);
					} else {
						tmap.put(num, 1);
					}
					break;
				case "D":
					if (tmap.size()!=0) {
						if (num > 0) { // 최대값 삭제
							int key = tmap.lastKey();
							int value = tmap.lastEntry().getValue();
							remove(key, value);
							remove(key, value);
						} else { // 최소값 삭제
							int key = tmap.firstKey();
							int value = tmap.firstEntry().getValue();
							remove(key, value);
						}
					}
					break;
				}

			}
			
			System.out.println(tmap.size()>0 ? tmap.lastKey() + " " + tmap.firstKey() : "EMPTY" );
		}
	}
	static void remove(int key, int value) {
		if(value>1) {
			tmap.put(key, value-1);
		} else {
			tmap.remove(key);
		}
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
*/

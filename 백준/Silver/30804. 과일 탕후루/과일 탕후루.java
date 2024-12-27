

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 최대 길이 부분 수열 - 투포인터
		// 앞부분부터 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		// 투포인터
		int left = 0;
		int maxLength = 0;
		
		Map<Integer, Integer> fruitCnt = new HashMap<>();
		for (int right = 0; right < N; right++) {
			fruitCnt.put(fruits[right], fruitCnt.getOrDefault(fruits[right], 0)+1);
			
			while(fruitCnt.size() > 2) {
				int leftFruit = fruits[left];
				fruitCnt.put(leftFruit, fruitCnt.get(leftFruit)-1);
				
				if(fruitCnt.get(leftFruit) == 0) {
					fruitCnt.remove(leftFruit);
				}
				
				left++;
			}
			
			maxLength = Math.max(maxLength, right-left+1);
		}
		
		System.out.println(maxLength);

	}

}

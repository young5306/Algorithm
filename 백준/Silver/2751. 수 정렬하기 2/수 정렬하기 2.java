

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백준 클래스2 실버5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
//		int[] arr = new int[N];
		// 1. arrayList는 배열기반 리스트 구현체
		// -> 내부적으로 동적배열 사용하여 데이터 저장 (add 할 떄마다 새로운 배열 생성하고 기존 데이터 보가사, 저장
		// -> 접근이 빠름, 삽입 삭제 느림
		// 2. linkedList는 연결 리스트 기반 리스트 구현체
		// -> 삽입, 삭제 빠름
		
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
//		Arrays.sort(arr); // dualpivot퀵소트 : nlogn, 최악 : n^2
		Collections.sort(list);
		
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

}

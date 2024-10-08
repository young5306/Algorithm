
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	// 가장 긴 증가하는 부분수열은 기존 수열 순서는 그대로 두고 몇몇 숫자를 지워서 만들 수 있는 수열 중
	// 가장 긴 오른차순 수열
	
	static List<Integer> list;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		list.add(0);
		
		// 1. 맨처음에 0을 넣어서 가장 작은 값을 입력해둠.
		// 2. list에 arr숫자 하나씩 넣으면서
		// - list의 마지막 숫자보다 크면 마지막에 추가
		// - 보다 작으면 적절한 위치에 대체 : list.get(i)<숫자<= list.get(i+1) : i+1자리에 대체
		// 반복문 사용 시 시간복잡도 : N * N = 10^12 => 시간초과
		
		for (int i = 0; i < N; i++) {
			int last = list.get(list.size()-1);
			if(arr[i] > last) {
				list.add(arr[i]);
			} else {
				// 적절한 위치에 대체 - 이분탐색
				int idx = binarySearch(arr[i]);
				list.set(idx, arr[i]);
			}
		}
		
		System.out.println(list.size()-1); // 0 빼기

	}
	
	static int binarySearch(int key) {
		int left = 0;
		int right = list.size()-1;
		int result = 0;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(key == list.get(mid)) {
				return mid;
			} else if (key > list.get(mid)) {
				left = mid + 1;
			} else {
				result = mid;
				right = mid - 1;
			}
		}
		return result;
	}


}

//시간 초과
		/*
		for (int i = 0; i < N; i++) {
			int last = list.get(list.size()-1);
			if(arr[i] > last) {
				list.add(arr[i]);
			} else {
				// 적절한 위치에 대체
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j)>=arr[i]) {
						list.set(j, arr[i]);
						break;
					}
				}
			}
		}
		*/
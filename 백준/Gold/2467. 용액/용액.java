import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		투포인터를 써보자
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] solution = new int[N];
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		
		int leftResult = 0;
		int rightResult = N-1;
		
		while(left < right) {
			int value = solution[left] + solution[right];
			
			if(min > Math.abs(value)) {
				min = Math.abs(value);
				
				leftResult = left;
				rightResult = right;
			}
			
			if(value==0) {
				break;
			} else if (value < 0) {
				left++;
			} else {
				right--;
			}
			
		}
		
		System.out.println(solution[leftResult]+" "+solution[rightResult]);
		
		
		
	}

}

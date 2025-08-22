
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] height = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken()); 
		}
		
		// 하나하나 왼오 블록 확인
		int sum = 0;
		for(int i = 1; i < W - 1; i++) {
			// 왼쪽 maxH 블록
			int left = 0;
			for(int j = 0; j < i; j++) {
				left = Math.max(left, height[j]);
			}
			// 오른쪽 maxH 블록
			int right = 0;
			for(int j = i + 1; j < W; j++) {
				right = Math.max(right, height[j]);
			}
			
			if(height[i] < left && height[i] < right) sum += (Math.min(left, right) - height[i]);
		}
		
		System.out.println(sum);
		
	}
}

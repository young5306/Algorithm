import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if(isDanjo(nums[i]*nums[j])) {
						max = Math.max(nums[i]*nums[j], max);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ (max==0 ? -1 : max));
		}
		
	}
	static boolean isDanjo(int num){
		
		int lastNum = 10;
		
		while(num>0) { // 28
			
			if(num%10 > lastNum) {
				return false;
			}
			
			lastNum = num%10;
			num/=10;
			
		}
		return true;
	}

}

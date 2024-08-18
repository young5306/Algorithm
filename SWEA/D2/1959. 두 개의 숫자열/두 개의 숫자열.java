import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			
			for(int i=0; i<N; i++) {
				arr1[i] = sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				arr2[i] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			if(N>=M) {
				for(int i=0; i<=N-M; i++) {
					int sum = 0;
					for(int j=i, k=0; j<i+M && k<M; j++, k++) {
						sum += arr1[j]*arr2[k];
					}
					max = Math.max(sum, max);
				}
			} else {
				for(int i=0; i<=M-N; i++) {
					int sum = 0;
					for(int j=i, k=0; j<i+N && k<N; j++, k++) {
						sum += arr2[j]*arr1[k];
					}
					max = Math.max(sum, max);
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
		
	}
}

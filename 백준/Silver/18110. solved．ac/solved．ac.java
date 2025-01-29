
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] score = new int[n];
		for(int i=0; i<n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(score);
		
		int sub = (int)((n * 0.15) + 0.5);
		
		int total = 0;
		for(int i = sub; i<n-sub; i++) {
			total += score[i];
		}
		
		System.out.println(Math.round((double)total/(n-2*sub)));
	}
}

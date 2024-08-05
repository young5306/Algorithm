import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] line = new int[N];
		
		line[sc.nextInt()] = 1; // 항상 0 입력됨
		
		for(int i=1; i<N; i++) {
			int num = sc.nextInt();

			// 나머지 뒤로 밀고
			for(int j=i-1; j>=i-num; j--) {
				line[j+1] = line[j];
			}
			line[i-num] = i+1;
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(line[i]+" ");
		}
	}
}

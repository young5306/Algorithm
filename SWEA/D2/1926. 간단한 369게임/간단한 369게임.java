import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=1; i<=N; i++) {
			boolean flag = false;
			String str = "";
			int n = i;
			
			while(n!=0) {
				int check = n%10;
				if(check!=0 && check%3==0) {
					flag = true;
					str+="-";
				}
				n/=10;
			}
			
			System.out.print((flag?str:i)+" ");
		}
		
	}
}

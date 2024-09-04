import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int[] price; // 4
	static int[] plan; // 12
	static int min;
	
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			price = new int[4]; // 1일, 1달, 3달, 1년 순
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			
			plan = new int[12]; // 매달 이용 계획
			for (int i = 0; i < 12; i++) {
				plan[i]= sc.nextInt();
			}
			
			min = 2000000;  // 3000원*31*12 = 372*3000 = 1116000
			recur(0, 0);
			
			System.out.println("#"+t+" "+min);
		}
		
	}
	
	public static void recur(int midx, int cost) { // 월인덱스, 중간값 들고 다니기
		// 기저 조건
		if(midx >= 12) {
			min = Math.min(min, cost);
			return;
		}
		// 재귀 조건 (조합 느낌)
		if(plan[midx]==0) {
			recur(midx+1, cost);
		} else {
			for (int i = 0; i < 4; i++) {
				if(plan[midx]!=0) {
					if(i==0) { // 1일권
						recur(midx+1, cost+plan[midx]*price[i]);
					} else if (i==1) { // 1달권
						recur(midx+1, cost+price[i]);
					} else if (i==2) { // 3달권
						recur(midx+3, cost+price[i]);
					} else if (i==3) { // 1년권
						recur(midx+12, cost+price[i]);
					}
				}
			}
		}
	}
}

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 왼쪽 아래 꼭지점 주어짐
		int[] xArr = new int[N];
		int[] yArr = new int[N];
		
		for(int i=0; i<N; i++) {
			xArr[i] = sc.nextInt();
			yArr[i] = sc.nextInt();
		}
		
		// 2차 배열 : 색칠된 부분 = 1로 표시
		int[][] board = new int[100][100];
		for(int i=0; i<N; i++) {
			for(int r=xArr[i]; r<xArr[i]+10; r++) {
				for(int c=yArr[i]; c<yArr[i]+10; c++) {
					board[r][c]=1;
				}
			}
		}
		
		// 1인 부분 더하기
		int cnt = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(board[r][c]==1) cnt++;
			}
		}
		System.out.println(cnt);

	}

}
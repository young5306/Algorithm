import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] AB = new int[N];
		int[] BC = new int[N];
		int[] CA = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			AB[i] = a + b;
			BC[i] = b + c;
			CA[i] = c + a;
		}
		Arrays.sort(AB); // 오름차순
		Arrays.sort(BC);
		Arrays.sort(CA);
		int sumAB = 0;
		int sumBC = 0;
		int sumCA = 0;
		for(int i = N - 1; i >= N - K; i--) {
			sumAB += AB[i];
			sumBC += BC[i];
			sumCA += CA[i];
		}
		
		System.out.println(Math.max(Math.max(sumAB, sumBC), sumCA));
	}

}

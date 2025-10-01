import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] line = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1]; 
			}
		});
		
		int min = line[0][0];
		int max = line[0][1];
		int answer = max - min;
		
		for(int i = 0; i < N; i++) {
			if(min <= line[i][0] && line[i][1] <= max) continue;
			else if (line[i][0] < max) answer += line[i][1] - max;
			else answer += line[i][1] - line[i][0];
			
			min = line[i][0];
			max = line[i][1];
		}
		
		System.out.println(answer);
	}

}

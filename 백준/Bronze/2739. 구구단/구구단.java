import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
			for (int j = 1; j <= 9; j++) {
				System.out.println(N+" * "+j+" = "+N*j);
			}

	}

}

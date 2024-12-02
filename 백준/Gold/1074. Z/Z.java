

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 1. 시작변수result 0, N=3이면 range는 64(2^N * 2^N = 2^2N)
	// 0<= 범위 <64
	// 2. 입력 r, c의 범위 0 ~ 2^(N-1) ~ 2^N 파악해서 1,2,3,4사분면 알아내기
	// 3. 시작변수 갱신 : 시작변수 += range/4*(사분면-1)
	// range /= 4 갱신
	// N-- 갱신
	// 4. N이 음수될 때 멈춤 (즉, 총 N번 반복 작업)

	static int N, r, c, result, dimR, dimC, length, range;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		result = 0;
		dimR = 0; // 사분면 시작점(왼쪽위모서리)
		dimC = 0;
		length = (int) Math.pow(2, N);
		range = length * length;

//		System.out.println(N+" "+r+" "+c+", "+range);

		for (int n = length / 2; n >= 1; n /= 2) {
			// 사분면 확인하기 + dimRC갱신
			int dim = checkDim(n);
			result += (range/4)*(dim-1);
			range /= 4;
		}
		
		System.out.println(result);

	}

	static int checkDim(int n) {
		// 입력 r, c의 범위 : dim<= <dim+n / 이상

		if (dimR <= r && r < dimR + n) {
			// 1사분면
			if (dimC <= c && c < dimC + n) {
				return 1;
			}
			// 2사분면
			else {
				dimC += n;
				return 2;
			}
		} else {
			// 3사분면
			if (dimC <= c && c < dimC + n) {
				dimR += n;
				return 3;
			}
			// 4사분면
			else {
				dimR += n;
				dimC += n;
				return 4;
			}
		}
	}

}

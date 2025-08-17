
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[26]; // A~Z 빈도
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            // 소문자면 대문자로 변화
            if ('a' <= c && c <= 'z') c = (char)(c - 'a' + 'A');
            cnt[c - 'A']++;
        }

        int max = -1, idx = -1;
        boolean tie = false;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                idx = i;
                tie = false; // 새로운 최댓값 발견 -> 동률 해제
            } else if (cnt[i] == max) {
                tie = true; // 최댓값과 동률
            }
        }

        if (tie) System.out.println("?");
        else System.out.println((char) ('A' + idx));
	}

}

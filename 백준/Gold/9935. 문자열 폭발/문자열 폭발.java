
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (char c : str1.toCharArray()) {
            sb.append(c);
            // str2가 sb의 끝에 있는지 확인
            if (sb.length() >= str2.length() &&
                sb.substring(sb.length() - str2.length()).equals(str2)) {
                sb.setLength(sb.length() - str2.length()); // str2 길이만큼 잘라냄
            }
        }

        String result = sb.toString();
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }

}

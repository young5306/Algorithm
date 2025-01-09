
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sortedArr[i] = num;
        }
        Arrays.sort(sortedArr);

        // rank 지정

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int value : sortedArr) {
            if(!rankMap.containsKey(value)){
                rankMap.put(value, rank++);
            }
        }
        
        // rank 찾기

        for(int value : arr) {
            sb.append(rankMap.get(value)).append(" ");
        }

        System.out.println(sb);
    }
}

//
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int white, blue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 재귀
        white = 0;
        blue = 0;
        partition(0,0, N); // 왼쪽위 모서리 좌표, 한변 길이

        System.out.println(white);
        System.out.println(blue);

    } // main

    public static void partition(int row, int col, int size){
        // 기저 조건
        if(size == 0) {
            return;
        }

        // 재귀 부분

        // 같은 색상인지 확인
        boolean sameColor = true;
        int color = paper[row][col];
        out : for (int i = row; i < row+size; i++){
            for (int j = col; j < col+size; j++){
                if(paper[i][j] != color){
                    sameColor = false;
                    break out;
                }
            }
        }

        // 같은 색상이면 return, 아니면 또 재귀
        if(sameColor) {
            if(color == 0) white++;
            else blue++;
            return;
        }

        int newSize = size/2;
        partition(row, col, newSize); // 1사분면
        partition(row+newSize, col, newSize); // 2사분면
        partition(row, col+newSize, newSize); // 3사분면
        partition(row+newSize, col+newSize, newSize); // 4사분면

    }
}

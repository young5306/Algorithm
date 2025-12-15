import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        // 누적합
        int n = board.length;
        int m = board[0].length;
        
        int[][] sum = new int[n + 1][m + 1];
        
        for(int i = 0; i < skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            if(skill[i][0] == 1) degree = -degree;
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        // 세로 누적합
        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++){
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        // 가로 누적합
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        // 최종 내구도 계산, 파괴되지 않은 건물 개수 계산
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] += sum[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        int xr = routes.length; // 로봇 수
        int mr = routes[0].length; // 로봇이 거치는 칸 수
        Queue<int[]>[] memo = new LinkedList[xr]; // memo[i] : x번 로봇의 위치 순차적으로 저장
        for(int x = 0; x < xr; x++) {
            memo[x] = new LinkedList<>();
        }
        
        // 1. 로봇들 경로 저장 - 0번 로봇부터 큐에 1초마다의 이동 경로(칸) 저장
        for(int x = 0; x < xr; x++) {
            int point = routes[x][0]; // 현재 포인트
            int r = points[point - 1][0];
            int c = points[point - 1][1];
            memo[x].add(new int[]{r, c});
            
            for(int m = 1; m < mr; m++) {
                int nPoint = routes[x][m]; // 다음 이동할 포인트
                int nr = points[nPoint - 1][0];
                int nc = points[nPoint - 1][1];
                
                while(nr != r){
                    if(r < nr) {
                        r++;
                    } else {
                        r--;
                    }
                    memo[x].add(new int[]{r, c});
                }
                
                while(nc != c) {
                    if(c < nc) {
                        c++;
                    } else {
                        c--;
                    }
                    memo[x].add(new int[]{r, c});
                }
            }
        }
        
        // 2. 경로 겹침 확인 - 1초마다 각 로봇들 이동 경로의 큐에서 꺼내서 겹치는지 확인
        int answer = 0;
        int escapeRobot = 0;
        while(escapeRobot != xr) {
            int[][] cnt = new int[101][101];
            escapeRobot = 0;
            
            for(int x = 0; x < xr; x++) {
                if(memo[x].isEmpty()) {
                    escapeRobot++;
                    continue;
                }
                
                int[] temp = memo[x].poll();
                cnt[temp[0]][temp[1]]++;
            }
            
            for(int i = 0; i < 101; i++) {
                for(int j = 0; j < 101; j++) {
                    if(cnt[i][j] > 1) {
                        answer++;
                    } 
                }
            }
        }
    
        return answer;
    }
}
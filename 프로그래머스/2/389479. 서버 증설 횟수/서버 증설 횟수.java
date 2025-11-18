import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        
        // 필요할 때마다 증설 (그리디)
        
        // 한 타임에 최대 1000명 (서버 최대 1000/m개 증설)
        int[] scnt = new int[players.length];
        int answer = 0;
        
        for(int i = 0; i < players.length; i++) {
            int need = players[i] / m; // 증설해야하는 서버 수
            int have = scnt[i];
            
            if(need > have) {
                answer += (need - have);
                for(int t = 0; t < k; t++) {
                    if(i + t >= players.length) break;
                    scnt[i + t] += (need - have);
                }
            }
        }
        
        return answer;
    }
}
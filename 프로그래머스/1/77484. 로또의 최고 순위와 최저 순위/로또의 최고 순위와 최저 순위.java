import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
                
        HashSet<Integer> set = new HashSet<>();
        for (int w : win_nums) {
            set.add(w);
        }
        
        int hitCnt = 0; // 일치개수
        int zeroCnt = 0;
        for (int l : lottos) {
            if(set.contains(l)) {
                hitCnt++;
            }
            if(l == 0) {
                zeroCnt++;
            }
        }
        
        int[] answer = {getScore(hitCnt+zeroCnt), getScore(hitCnt)};
        
        return answer;
    }
    
    static int getScore(int cnt) {
        switch (cnt) {
                case 6: return 1;
                case 5: return 2;
                case 4: return 3;
                case 3: return 4;
                case 2: return 5;
                default: return 6;
        }
    }
}
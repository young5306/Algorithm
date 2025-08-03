import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // reserve를 돌면서 왼,오순으로 확인
        
        Arrays.sort(lost);
        
        HashSet<Integer> reserveSet = new HashSet<>();
        for(int i = 0; i < reserve.length; i++) {
            reserveSet.add(reserve[i]);   
        }
        
        for (int i = 0; i < lost.length; i++) {
            if(reserveSet.contains(lost[i])) {
                reserveSet.remove(lost[i]);
                lost[i] = -1;
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            if(lost[i] == -1) continue;
            // 왼오순으로 확인
            if(reserveSet.contains(lost[i] - 1)) {
                reserveSet.remove(lost[i] - 1);
                lost[i] = -1;
            } else if (reserveSet.contains(lost[i] + 1)) {
                reserveSet.remove(lost[i] + 1);
                lost[i] = -1;
            }
        }
        
        int lostCnt = 0;
        for(int stu : lost) {
            if(stu == -1) continue;
            else lostCnt++;
        }
        return n - lostCnt;
    }
}
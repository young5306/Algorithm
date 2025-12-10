import java.util.*;

class Solution {    
    public int solution(int[][] scores) {
        
        // 일일이 비교하면 x (시간복잡도 10만^2 -> 100억)
        
        // 1. 일단 근무 태도 점수로 정렬 (내림차순)
        // 2. 동료 평가 점수를 비교
        //  - 이전에 나온 동료 평가 점수의 max값보다 작으면 삭제 후보
        //  - 해당 삭제 후보의 동료 평가 점수는 직전 동료 평가 점수와 같거나 작음
        //    - 작은 경우에만 삭제 확정
        
        int wanA = scores[0][0];
        int wanB = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1]); // a는 내림차순, b는 오름차순
        // for(int i = 0; i < scores.length; i++) {
        //     System.out.println(Arrays.toString(scores[i]));
        // }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        int maxB = scores[0][1];
        pq.add(new int[]{scores[0][0], scores[0][1]});
        for(int i = 1; i < scores.length; i++) {
            if(scores[i][1] < maxB) {
                continue;
            }

            maxB = Math.max(scores[i][1], maxB);
            pq.add(new int[]{scores[i][0], scores[i][1]});
        }
        
        int same = 0;
        int cnt = 0;
        int prev = -1;
        boolean flag = false;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            // System.out.println(cur[0] + ", " + cur[1]);
            cnt++;
            
            if(cur[0] + cur[1] == prev) {
                same++;
            }
            
            if(cur[0] == wanA && cur[1] == wanB) {
                flag = true;
                if(prev == cur[0] + cur[1]) cnt -= same;
                break;
            }
            
            if(cur[0] + cur[1] != prev) {
                same = 0;
                prev = cur[0] + cur[1];
            }
        }
        
        return flag ? cnt : -1;
    }
}
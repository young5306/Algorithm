import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        // 시작점으로 정렬
        // 끝점
        
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // Arrays.sort(target, (a, b) -> (a[0] - b[0]));
        
        int answer = 1;
        int prevEndMin = targets[0][1];
        for(int i = 0; i < targets.length; i++) {
            if(prevEndMin <= targets[i][0]) {
                answer++; // 요격 횟수 +1 증가
                prevEndMin = targets[i][1]; // 끝점 최솟값 초기화
            } else {
                prevEndMin = Math.min(prevEndMin, targets[i][1]);
            }  
        }
        
        return answer;
    }
}
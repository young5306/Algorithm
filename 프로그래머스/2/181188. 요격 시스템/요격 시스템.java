import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        // 끝점으로 정렬
        // 끝점 - 0.1에서 요격한다고 생각
        // 끝점이 다음 시작점들보다 작아질 때, 요격 횟수 + 1
        
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // Arrays.sort(target, (a, b) -> (a[0] - b[0]));
        
        int answer = 1;
        int e = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
             if(e <= targets[i][0]) {
                 answer++;
                 e = targets[i][1];
             }
        }
        
        return answer;
    }
}
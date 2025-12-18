import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<Integer> check = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            check.add(0);
        }
        int answer = 0;
        
        for(int i = 1; i <= n - 4; i++) {
            check.set(0, i);
            for(int j = i + 1; j <= n - 3; j++) {
                check.set(1, j);
                for(int k = j + 1; k <= n - 2; k++) {
                    check.set(2, k);
                    for(int l = k + 1; l <= n - 1; l++) {
                        check.set(3, l);
                        for(int m = l + 1; m <= n; m++) {
                            check.set(4, m);
                            
                            boolean flag = true;
                            for(int a = 0; a < q.length; a++) {
                                int cnt = 0;
                                for(int b = 0; b < 5; b++) {
                                    if(check.contains(q[a][b])) cnt++;
                                }
                                if(ans[a] != cnt) {
                                    flag = false;
                                    break;
                                }
                            }
                            
                            if(flag) answer++;
                        }
                    }
                }
            }
        }
            
        return answer;
    }
}
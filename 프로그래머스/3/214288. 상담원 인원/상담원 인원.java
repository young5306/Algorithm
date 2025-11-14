import java.util.*;

class Solution {
    static int K, N, min;
    static int[] kMentoCnt;
    static int[][] reqsArr;

    public int solution(int k, int n, int[][] reqs) {
        // 모든 경우의 수 구하기: 시간복잡도 20^5
        // dfs
        
        K = k;
        N = n;
        kMentoCnt = new int[K + 1]; // 1번 ~ k번 유형을 담당하는 멘토 수
        Arrays.fill(kMentoCnt, 1); // 각 상담 유형은 최소 1명 배치
        reqsArr = reqs;
        
        min = Integer.MAX_VALUE;
        dfs(1, N - K); // 유형idx, 배치해야 할 남은 멘토 수
        
        return min;
    }
    
    static void dfs(int kidx, int remain) {
        // 기저 조건
        if(kidx > K && remain == 0) {
            // 대기 시간 확인
            int wtime = calcWaitingTime();
            min = Math.min(min, wtime);
            return;
        }
        if(kidx > K) {
            return;
        }
        
        // 재귀 부분
        for(int i = 0; i <= remain; i++) {
            kMentoCnt[kidx] += i;
            dfs(kidx + 1, remain - i);
            kMentoCnt[kidx] -= i;
        }
    }
    
    static int calcWaitingTime() {
        // 유형마다 pq 만들어서 끝나는 시점 저장
        PriorityQueue<Integer>[] pq = new PriorityQueue[K + 1];
        
        for(int i = 1; i <= K; i++) {
            pq[i] = new PriorityQueue<>();
            for(int j = 0; j < kMentoCnt[i]; j++){
                pq[i].add(0);
            }
        }
        
        int wtime = 0;
        
        for(int i = 0; i < reqsArr.length; i++) {
            int start = reqsArr[i][0]; // 이미 오름차순으로 나옴
            int duration = reqsArr[i][1];
            int k = reqsArr[i][2];
            
            int time = pq[k].poll();
            
            if(time <= start) { // 바로 시작
                pq[k].add(start + duration);
            } else { // 대기 후 시작
                wtime += (time - start);
                pq[k].add(time + duration);
            }
        }
        return wtime;
    }
}
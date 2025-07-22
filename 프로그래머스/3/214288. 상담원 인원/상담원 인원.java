import java.util.*;

class Solution {

    static int K, N;
    static int[] kArr;
    static int[][] req;
    static int min;

    public int solution(int k, int n, int[][] reqs) {
        K = k;
        N = n;
        req = reqs;
        min = Integer.MAX_VALUE;

        // 모든 경우의 수를 확인하다고 가정 - 최대 20^5
        // k배열 - 상담 끝나는 시간들 리스트로 저장

        // 1. 모든 경우의 수 돌기 (dfs)
        kArr = new int[K];
        Arrays.fill(kArr, 1);
        dfs(0, n - k); // n-k명을 k개 상담에 분배 (중복 조합), 중복 순열로 풀면 시간 초과 뜸

        return min;
    }

    static void dfs(int idx, int remain) {
        // 기저 조건
        if (idx == K || remain == 0) {
            // 남은 인원 다 배분했으면 대기 시간 계산
            min = Math.min(min, getWaitingTime());
            return;
        }

        for (int i = 0; i <= remain; i++) {
            kArr[idx] += i;
            dfs(idx + 1, remain - i);
            kArr[idx] -= i;
            // kArr[i]++; // 중복 순열 코드
            // dfs(scnt + 1);
            // kArr[i]--;
        }
    }

    static int getWaitingTime() {
        PriorityQueue<Integer>[] kTime = new PriorityQueue[K];
        for(int i = 0; i < K; i++) {
            kTime[i] = new PriorityQueue<>();
            for(int j = 0; j < kArr[i]; j++) {
                kTime[i].add(0);
            }
        }

        int wt = 0;

        for(int i = 0; i < req.length; i++) {
            int start = req[i][0];
            int counselTime = req[i][1];
            int type = req[i][2] - 1;

            int recentTime = kTime[type].poll();
            if(recentTime > start) {
                wt += (recentTime - start);
                kTime[type].add(recentTime + counselTime);
            } else {
                kTime[type].add(start + counselTime);
            }
        }

        return wt;
    }
}
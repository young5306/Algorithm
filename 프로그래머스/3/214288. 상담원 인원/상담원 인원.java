import java.util.*;

class Solution {
    static int[][] reqs;
    static int n, k, min = Integer.MAX_VALUE;
    static int[] kArr;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        this.reqs = reqs;
        kArr = new int[k];

        // 각 상담 유형에 최소 1명씩 먼저 배정
        Arrays.fill(kArr, 1);

        // 나머지 n - k명을 분배
        dfs(0, n - k);

        return min;
    }

    // 상담 유형별 멘토 분배 조합 구하기
    static void dfs(int idx, int remain) {
        if (idx == k || remain == 0) {
            // 남은 인원 다 배분했으면 대기 시간 계산
            min = Math.min(min, simulate());
            return;
        }

        for (int i = 0; i <= remain; i++) {
            kArr[idx] += i;
            dfs(idx + 1, remain - i);
            kArr[idx] -= i;
        }
    }

    // 현재 kArr 멘토 배치 상태에서 총 대기 시간 계산
    static int simulate() {
        // 상담 유형별로 멘토의 다음 가능 시간 PriorityQueue로 관리
        PriorityQueue<Integer>[] mentorQueues = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {
            mentorQueues[i] = new PriorityQueue<>();
            for (int j = 0; j < kArr[i]; j++) {
                mentorQueues[i].add(0); // 모든 멘토는 처음에 0분부터 상담 가능
            }
        }

        int totalWait = 0;

        for (int[] req : reqs) {
            int start = req[0], time = req[1], type = req[2] - 1;
            PriorityQueue<Integer> pq = mentorQueues[type];
            int availableTime = pq.poll();
            if (availableTime > start) {
                totalWait += availableTime - start;
                pq.add(availableTime + time);
            } else {
                pq.add(start + time);
            }
        }

        return totalWait;
    }
}

class Solution {
    public long solution(int[] sequence) {
        
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];
        
        long answer = Math.max(dp1[0], dp2[0]);
        
        for (int i = 1; i < sequence.length; i++) {
            // 1) 1,-1,1,-1 -> 홀수일때 -
            int next = sequence[i];
            if (i % 2 != 0) next = -next;
            dp1[i] = Math.max(dp1[i-1] + next, next);
            answer = Math.max(answer, dp1[i]);
        }
        
        for (int i = 1; i < sequence.length; i++) {
            // 2) -1,1,-1,1 -> 짝수일때 -
            int next = sequence[i];
            if (i % 2 == 0) next = -next;
            dp2[i] = Math.max(dp2[i-1] + next, next);
            answer = Math.max(answer, dp2[i]);
        }
        
        return answer;
    }
}
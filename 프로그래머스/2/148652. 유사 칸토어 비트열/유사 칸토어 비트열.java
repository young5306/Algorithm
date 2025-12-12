class Solution {
    public int solution(int n, long l, long r) {
        
        // n = 0 -> 1 => len 1, 0의 위치: 1 (0)
        // n = 1 -> 11011 => (0~4) => len 5, 0의 위치: 2 (1)
        // n = 2 -> 11011 11011 00000 11011 11011 => a => (0~4)(5~9)00000(15~19)(20~24) => len 25, 0의 위치: 10 ~14 (5)
        // n = 3 -> a a 00000*5 a a => 0~24/25~49/50~74/a/a => len 125, 0의 위치: 50~74 (25)
        // n = 4 -> b b 00000*25 b b => len 625, 0의 위치: 250~ (125)
        // ...
        // n -> c c 00000*(5^(n-1)) c c => len 5^n, 0의 위치: 2 * (5^(n-1)) (5^(n-1))
        
        int answer = 0;
        for(long i = l; i <= r; i++) {
            answer += getNum(n, i - 1);
        }
        
        return answer;
    }
    
    static int getNum(int n , long i) {
        // 기저 조건
        if(n == 0) return 1;
        
        // 재귀 부분
        long len = (long) Math.pow(5, n);
        long blockSize = len / 5;
        long blockIdx = i / blockSize;
        if(blockIdx == 2) return 0;
        long newI = i % blockSize;
        return getNum(n - 1, newI);
    }
}


import java.util.*;

class Solution {
    
    static int[] discount;
    static int[][] user;
    static int[] emoticon;
    static int[] disNums = {10, 20, 30, 40};
    static int N, M;
    static PriorityQueue<Info> pq;
    
    static class Info implements Comparable<Info> {
        int plus;
        int sales;
        
        Info(){}
        Info(int plus, int sales){
            this.plus = plus;
            this.sales = sales;
        }
        
        @Override
        public int compareTo(Info o) {
            if(this.plus != o.plus) return o.plus - this.plus;
            return o.sales - this.sales;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        // 모든 경우의 수 확인해보기: 4^7 = 16384
        
        N = emoticons.length;
        M = users.length;
        user = users;
        emoticon = emoticons;
        discount = new int[N]; 
        
        pq = new PriorityQueue<>();
        dfs(0);
        
        Info answer = pq.poll();
        return new int[]{answer.plus, answer.sales};
    }
    
    static void dfs(int idx) {
        // 기저 조건
        if(idx >= N) {
            // 플러스 가입자 수, 판매액 계산
            calculate();
            return;
        }
        
        // 재귀 부분
        for(int i = 0;  i < disNums.length; i++) {
            discount[idx] = disNums[i];
            dfs(idx + 1);
        }   
    }
    
    static void calculate() {
        
        int plus = 0;
        int sales = 0;
        for(int i = 0; i < M; i++) { // 사람
            int dis = user[i][0];
            int max = user[i][1];
            
            int sum = 0;
            for(int j = 0; j < N; j++) { // 이모티콘
                if(discount[j] >= dis) {
                    int cost = emoticon[j] * (100 - discount[j]) / 100;
                    sum += cost;
                }
            }
            
            if(sum >= max) {
                plus++;
            } else {
                sales += sum;
            }
        }
        
        pq.add(new Info(plus, sales));
    }
}
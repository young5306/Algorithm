import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        // 특징 정리 (in: 들어오는 간선, out: 나가는 간선)
        // 1) 도넛 모양 그래프의 한 정점에 대해: in 1, out 1
        // 2) 막대 모양 그래프: in 1, out 1 (양끝: 0이거나/ in 1이거나/ out 1)
        // 3) 8자 모양 그래프: in 2, out 2 / in 1, out 1 
        // -> 새로 생성한 점 때문에 in은 + 1될 수 있음.
        
        // 생성한 점은 in이 있을 수 없음
        // in 0일 때 out 0 or 1이면 막대 그래프
        // -> in 0, out이 2개 이상이면 생성한 점
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            out.put(edges[i][0], out.getOrDefault(edges[i][0], 0) + 1);
            in.put(edges[i][1], in.getOrDefault(edges[i][1], 0) + 1);
        }
        
        int newNode = 0; // 선별 조건: in 0, out 2 이상
        int donut = 0; // 몰라.. 나머지에서 빼: 그래프 수(newNode의 out) - bar 수, shape8 수
        int bar = 0; // 맨끝 점: out 0인 점
        int shape8 = 0; // 가운데 점: in 2/3, out 2 (나머지 점: in 1/2, out 1 는 세지x)
        
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(!in.containsKey(node)) {
                    newNode = node;
                } else {
                    shape8++; // 8자 그래프 정점 중 가운데 점
                }
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) {
                bar++;
            }
        }
        
        donut = out.get(newNode) - bar - shape8;

        int[] answer = new int[]{newNode, donut, bar, shape8};
        
        return answer; // 생성한 정점, 도넛, 막대, 8자 모양 그래프의 수
    }
}
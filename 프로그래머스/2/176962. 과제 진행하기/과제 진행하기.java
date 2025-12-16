import java.util.*;

class Solution {
    
    class Plan implements Comparable<Plan> {
        String name;
        int starttime;
        int playtime;
        
        Plan(){}
        Plan(String name, int starttime, int playtime) {
            this.name = name;
            this.starttime = starttime;
            this.playtime = playtime;
        }
        
        @Override
        public int compareTo (Plan o) {
            return this.starttime - o.starttime;
        }
    }
    
    class Working {
        String name;
        int lefttime;
        
        Working(){}
        Working(String name, int lefttime) {
            this.name = name;
            this.lefttime = lefttime;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        // 1. 새로운 과제들 시작 시간으로 정렬된 pq 
        PriorityQueue<Plan> pq = new PriorityQueue<>();
        for(int i = 0; i < plans.length; i++) {
            String start = plans[i][1];
            int h = Integer.parseInt(start.substring(0, 2));
            int m = Integer.parseInt(start.substring(3));
            pq.add(new Plan(plans[i][0], h * 60 + m, Integer.parseInt(plans[i][2])));
        }
        
        // 2. 진행 중인 과제 스택
        // 3. 끝난 과제 담을 리스트
        List<String> list = new ArrayList<>();
        Stack<Working> stack = new Stack<>();
        Plan p = pq.poll();
        stack.add(new Working(p.name, p.playtime));
        
        int curtime = p.starttime;
        
        while(!pq.isEmpty()) {

            Plan nxt = pq.peek();
            int gap = nxt.starttime - curtime;
            
            // a. 새로운 과제 시작 전에 진행 중이던 과제 시작
            if(gap > 0) {
                // 스택에 있는 과제 시작
                Working work = stack.pop();
                
                if(work.lefttime <= gap) { // 완료
                    list.add(work.name);
                    curtime += work.lefttime;
                }
                else { // 미완료
                    stack.add(new Working(work.name, work.lefttime - gap));
                    curtime = nxt.starttime; 
                }
            } 
            // b. 다음 작업이 선점
            else {
                // pq에 있는 과제 시작
                Plan plan = pq.poll();
                stack.add(new Working(plan.name, plan.playtime));
            }
            
            if(stack.isEmpty()) {
                Plan stnxt = pq.poll();
                stack.add(new Working(stnxt.name, stnxt.playtime));
                curtime = stnxt.starttime;
            }
        }
        
        while(!stack.isEmpty()) {
            Working cur = stack.pop();
            list.add(cur.name);
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
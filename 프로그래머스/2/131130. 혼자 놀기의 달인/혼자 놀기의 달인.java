import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= cards.length; i++) {
            
            int pick = i;
            int num = cards[pick - 1];
            if(num == -1) continue;
            int cnt = 0;
            
            while(num != -1) {
                cnt++;
                cards[pick - 1] = -1;
                
                pick = num;
                num = cards[pick - 1];
            }
            
            list.add(cnt);
        }
        
        if(list.size() <= 1) return 0;
        
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        
        return list.get(0) * list.get(1);
    }
}
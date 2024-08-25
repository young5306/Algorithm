import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] ans1 = {1,2,3,4,5}; // 5
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int[] cnt = new int[4]; // 1,2,3
        
        for (int i = 0; i < answers.length; i++) {
			if(answers[i] == ans1[i%5]) cnt[1]++;
			if(answers[i] == ans2[i%8]) cnt[2]++;
			if(answers[i] == ans3[i%10]) cnt[3]++;
		}
        
        int max = Math.max(cnt[1], Math.max(cnt[2], cnt[3]));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
			if(max == cnt[i]) result.add(i);
		}
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
        
        return answer;
    }
}
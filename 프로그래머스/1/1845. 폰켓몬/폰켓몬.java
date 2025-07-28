import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int type : nums) {
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = Math.min(nums.length/2, map.size());
        return answer;
    }
}
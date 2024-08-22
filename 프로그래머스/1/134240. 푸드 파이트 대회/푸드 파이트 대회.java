class Solution {
    public String solution(int[] food) {
        String answer = ""; 
        
        for(int i=1; i<food.length; i++) {
        	answer+=(""+i).repeat(food[i]/2);
        }
        answer+='0';
        for(int i=answer.length()-2; i>=0; i--) {
        	answer+= answer.charAt(i);
        }
        return answer;
    }
}
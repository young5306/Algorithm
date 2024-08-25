class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 1; 
        
        if(my_string.length() < is_suffix.length()) {
        	answer = 0;
        }
        else {
        	int strIdx = my_string.length()-1;
            
            for (int i = is_suffix.length()-1; i >=0 ; i--) {
    			if(is_suffix.charAt(i) != my_string.charAt(strIdx--)) {
    				answer = 0;
    				break;
    			}
    		}
        }
        
        return answer;
    }
}
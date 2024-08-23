class Solution {
	public static int solution(int n) {
        int answer = 1;
        
        for(int i=1; i<=n; i++, answer++) {
        	
        	while(isThree(answer)) {
        		answer++;
        	}
        	
        }
        
        return answer-1;
    } 
	
	static boolean isThree(int N) {
		// true : 3배수거나 3포함 숫자이거나
		
		if(N%3==0) return true;
		
    	while(N>0) {
    		if(N%10==3) return true;
    		N/=10;
    	}
    	
		return false;
	}
	

}
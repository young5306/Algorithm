class Solution {
    public String solution(String code) {
        String ret = "";
        
        char mode = '0';
        for (int i = 0; i < code.length(); i++) {
			if(code.charAt(i)=='1') {
				mode = mode=='0'?'1':'0';
			} else {
				// mode 0 : 짝수 인덱스만 추가
				// mode 1 : 홀수 인덱스만 추가
				if((mode=='0' && i%2==0) || (mode=='1' && i%2==1)){
					ret+=code.charAt(i);
				}
			}
			
		}
        return ret.length()==0 ? "EMPTY" : ret;
    }
}
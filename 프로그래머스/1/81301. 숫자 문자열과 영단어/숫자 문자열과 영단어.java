class Solution {
    public int solution(String s) {
        String answer = "";
        
        String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	
        	if(ch >= '0' && ch<='9') { // 숫자일 때
        		answer+=ch;
        	} else { // 영단어일 때
        		String input = "" + s.charAt(i) + s.charAt(i+1) + s.charAt(i+2);
        		String match = "";
        		int j = 0;
        		for (j = 0; j < english.length; j++) {
					if(english[j].startsWith(input)){
						match = english[j];
						break;
					}
				}
        		i+=match.length()-1;
        		answer += ""+j;
        		// System.out.println(ch+", "+input+", "+", "+match+", "+answer+"->"+i);
        	}
			
		}
        return Integer.parseInt(answer);
    }
}
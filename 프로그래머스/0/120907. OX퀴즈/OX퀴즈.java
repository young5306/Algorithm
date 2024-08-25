class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int X;
        int Y;
        String op;
        int Z;
        
        for (int i = 0; i < quiz.length; i++) {
        	String result = "";
        	
			String[] str = quiz[i].split(" ");
			X = Integer.parseInt(str[0]);
			op = str[1];
			Y = Integer.parseInt(str[2]);
			Z = Integer.parseInt(str[4]);
			
			switch (op) {
			case "+": {
				if(X+Y == Z) result = "O";
				else result = "X";
				break;
			}
			case "-": {
				if(X-Y == Z) result = "O";
				else result = "X";
			}
			}
			
			answer[i] = result;
			
		}
        return answer;
    }
}
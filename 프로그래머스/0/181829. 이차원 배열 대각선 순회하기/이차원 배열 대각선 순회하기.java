class Solution {
    public int solution(int[][] board, int k) {
        int sum = 0;
        for (int i = 0; i < board.length && i<=k; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(i+j<=k) {
					sum += board[i][j];
				} else break;
			}
		}
        
        return sum;
    }
}
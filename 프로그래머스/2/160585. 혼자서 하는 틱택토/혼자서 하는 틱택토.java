class Solution {
    
    public int solution(String[] board) {
        // 만들 수 없는 경우
        
        // 1. O - X 가 1, 0이 아닌 경우
        // 2. O - X = 0, O >= 3 인데 -> O가 빙고가 만들어진 경우
        // 3. O - X = 1, X >= 3 인데 -> X가 빙고가 만들어진 경우
        
        int oCnt = 0;
        int xCnt = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                switch(ch) {
                    case 'O': 
                        oCnt++;
                        break;
                    case 'X':
                        xCnt++;
                        break;
                    default:
                        break;
                }
            }
        }

        int answer = 1;
        int gap = oCnt - xCnt;
        
        if(gap != 0 && gap != 1) {
            answer = 0;
        } else if (gap == 0 && oCnt >= 3) {
            answer = bingo(board, 'O') ? 0 : 1;
        } else if (gap == 1 && xCnt >= 3) {
            answer = bingo(board, 'X') ? 0 : 1;
        }
        
        return answer;
    }
    
    static boolean bingo(String[] board, char check) {
        boolean flag = false;
        
        if(board[1].charAt(1) == check) {
            // 1. 좌상 대각선
            if (board[0].charAt(0) == check && board[2].charAt(2) == check){
                flag = true;
            } 
            // 2. 좌하 대각선
            else if (board[0].charAt(2) == check && board[2].charAt(0) == check) {
                flag = true;
            }
            // 3. 가운데 수평
            else if (board[1].charAt(0) == check && board[1].charAt(2) == check) {
                flag = true;
            }
            // 4. 가운데 수직
            else if (board[0].charAt(1) == check && board[2].charAt(1) == check) {
                flag = true;
            }
        } 
        
        if (board[0].charAt(0) == check) {
            // 5. 첫줄 수평
            if (board[0].charAt(1) == check && board[0].charAt(2) == check) {
                flag = true;
            }
            // 6. 첫줄 수직
            else if (board[1].charAt(0) == check && board[2].charAt(0) == check) {
                flag = true;
            }
        } 
        
        if (board[2].charAt(2) == check) {
            // 7. 3줄 수평
            if (board[2].charAt(0) == check && board[2].charAt(1) == check) {
                flag = true;
            }
            // 8. 3줄 수직
            else if (board[0].charAt(2) == check && board[1].charAt(2) == check) {
                flag = true;
            }
        }
        
        return flag;
    }
}
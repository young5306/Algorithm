import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        
        // 포화 이진 트리 - 중위 순회
        
        // 1. 이진수 변환
        // 2. 포화 이진트리 생성
        // 3. 유효한 포화 이진트리인지 확인 - dfs
        // - root가 0인데 서브(왼,오 중 하나라도)의 root가 1이면 유효x
        
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            // 1. 이진수 변환
            String binary = Long.toBinaryString(numbers[i]);
            // 2. 포화 이진트리 변환
            binary = getFullBinary(binary);
            // 3. 유효한지 확인
            boolean flag = false;
            if(binary.length() == 1) flag = true;
            else if (binary.length() == 3) {
                flag = lastTreeCheck(binary);
            } else {
                flag = dfs(binary);
            }
            
            answer[i] = flag ? 1 : 0;
        }
        
        return answer;
    }
    
    static String getFullBinary(String str) {
        // 작은 포화 이진 트리부터
        int num = str.length();
        int cntNode = 1;
        int leaf = 1;
        
        while(cntNode < num) {
            leaf *= 2;
            cntNode += leaf;
        }
        
        return "0".repeat(cntNode - num) + str;
    }
    
    static boolean dfs(String str) {
        if(str.length() == 3) { // 마지막 서브 트리
            return lastTreeCheck(str);
        }
        
        int rootNum = str.length() / 2; // idx 기준
        String leftSubTree = str.substring(0, rootNum);
        String rightSubTree = str.substring(rootNum + 1);
        
        int leftRootNum = leftSubTree.length() / 2;
        int rightRootNum = rightSubTree.length() / 2;
        
        if(str.charAt(rootNum) == '0') {
            if(leftSubTree.charAt(leftRootNum) == '1'
               || rightSubTree.charAt(rightRootNum) == '1') {
                return false;
            }
        }
        
        return dfs(leftSubTree) && dfs(rightSubTree);
    }
    
    static boolean lastTreeCheck(String str) {
        if(str.charAt(1) == '0' && (str.charAt(0) == '1' || str.charAt(2) == '1')) return false;
        return true;
    }
}
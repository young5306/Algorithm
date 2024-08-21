class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        // num개의 연속 정수 합 total = 0~num-1합 + 시작값*num
        int numSum = (num-1)*num/2;
        int start = (total - numSum) / num;
        for(int i=0; i<answer.length; i++) {
        	answer[i] = start++;
        }
        return answer;
    }
}
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l, r).filter(i->{
			while(i>0) {
				if(i%5!=0) return false;
				i/=10;
			}
			return true;
		}).toArray();
		
		return answer.length != 0 ? answer : new int[]{-1};
    }
}
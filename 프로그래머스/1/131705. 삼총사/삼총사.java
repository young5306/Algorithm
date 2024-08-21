class Solution {
    public int solution(int[] number) {
        int s1;
        int s2;
        int s3;
        
        int cnt = 0;
        int sum = 0;
        for(s1=0; s1<number.length-2; s1++) {
        	sum = number[s1];
        	for(s2=s1+1; s2<number.length-1; s2++) {
        		sum = number[s1] + number[s2];
        		for(s3=s2+1; s3<number.length; s3++) {
        			if((sum+number[s3])==0) {
        				cnt++;
        			}
        		}
        	}
        }
        
        return cnt;
    }
}
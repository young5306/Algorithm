class Solution {
    public long solution(int price, int money, int count) {
        // price : 2500, money : 1, count : 2500 
		// -> 모자란 금액 : 2500*(1+2+..+2500)-1 = 7,815,625,000-1 = 70억
		// int 범위 : -21억~21억 
		// long 범위 : 10^19
		
		long answer = 0;
		
        long needMoney = (long) price * count * (count+1) / 2 - money;
		
        if(needMoney <= 0) answer = 0;
        else answer = needMoney;
        
        return answer;
    }
}
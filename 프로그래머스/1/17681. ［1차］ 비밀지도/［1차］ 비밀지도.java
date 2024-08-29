class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int j = n-1; j>=0 ; j--) {
			answer[j]=""; // 초기화
		}
        
        for (int i = 0; i < n; i++) {
			
			int num1 = arr1[i];
			int num2 = arr2[i];
			int binary1 = 0;
			int binary2 = 0;
			
			int idx = n-1;
			String str = "";
			while(idx>=0) {
	        	binary1 = num1%2;
				binary2 = num2%2;
				
				if(binary1==0 && binary2==0) {
					str += " ";
				} else {
					str += "#";
				}
				num1/=2;
				num2/=2;
				idx--;
			}
//			System.out.println(str);
			
			for (int j = n-1; j>=0 ; j--) {
				answer[i]+=str.charAt(j);
			}
		}
        
        
        return answer;
    }
}
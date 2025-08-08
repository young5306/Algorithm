class Solution {
    public int[] solution(int brown, int yellow) {
        
        int h = 1;
        for (h = 1; h <= yellow/2; h++) { // yellow/2
            if(yellow%h != 0) continue;
            if(brown != 2*(yellow/h+(h+2))) continue;
            break;
        }
        return new int[] {yellow/h+2, h+2};
    }
}

// 세로가 1,2,3,4,...
// brown수가 2*(y/h+(h+2)) -> (주의)y/h가 정수일 경우에만 진행
// 답[가로,세로] = [y/h+2, h+2]

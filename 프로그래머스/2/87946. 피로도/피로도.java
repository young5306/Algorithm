class Solution {
    static int cnt = 0;
	static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // 완전 탐색 (dfs)
		visited = new boolean[dungeons.length];
		dfs(0, k, dungeons); // 현재 피로도, 다음 입장 피로도			
        return cnt;
    }
    public static void dfs(int depth, int k, int[][] dungeons) {
		for(int i=0; i<dungeons.length; i++) {
			// 기저 조건
			if(visited[i] || dungeons[i][0] > k) {
				continue;
			}
			// 재귀 부분
			visited[i] = true;
			dfs(depth+1, k - dungeons[i][1], dungeons);
			visited[i] = false;
		}
		cnt = Math.max(cnt, depth);
	}
}
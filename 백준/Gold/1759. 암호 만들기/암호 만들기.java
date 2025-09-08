
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C;
	static char[] ch, selected;
	static boolean[] visited;
	static int vow, con;

	public static void main(String[] args) throws Exception {
		// 순서 없는 조합 문제

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ch = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ch);
		
		visited = new boolean[C];
		selected = new char[L];
		vow = 0;
		con = 0;
		dfs(0, 0);
	}
	
	static void dfs(int idx, int sidx) {
		// 기저 조건
		if(sidx == L) {
			if(vow >= 1 && con >= 2) {
				for(char s : selected) {
					System.out.print(s);
				}
				System.out.println();
			}
			return;
		}
		
		// 재귀 부분
		for(int i = idx; i < C; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				vow++;
			} else {
				con++;
			}
			selected[sidx] = ch[i];
			
			dfs(i + 1, sidx + 1);
			
			visited[i] = false;
			if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				vow--;
			} else {
				con--;
			}
		}
	}

}

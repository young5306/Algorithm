
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		List<String> list = new ArrayList<>();
		list.add("c=");
		list.add("c-");
		list.add("dz=");
		list.add("d-");
		list.add("lj");
		list.add("nj");
		list.add("s=");
		list.add("z=");
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			
			if(i <= str.length() - 2) {
				String frag2 = str.substring(i, i + 2);
				if(list.contains(frag2)) {
					i++;
					cnt++;
					continue;
				}
			}
			if(i <= str.length() - 3) {
				String frag3 = str.substring(i, i + 3);
				if(list.contains(frag3)) {
					i += 2;
					cnt++;
					continue;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}

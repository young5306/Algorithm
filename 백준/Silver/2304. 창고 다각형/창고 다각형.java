
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	// 1) 최고층까지는 계속 올라감
	// 2) 최고층 이후부터는 보다 전층보다 낮은층만 가야함
	
	static class Pole {
		int l;
		int h;
		Pole(){}
		Pole(int l, int h){
			this.l = l;
			this.h = h;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int maxH = 0;
		PriorityQueue<Pole> pq1 = new PriorityQueue<>(new Comparator<Pole>() {
			@Override
			public int compare(Pole o1, Pole o2) {
				return o1.l - o2.l;
			}
		});
		PriorityQueue<Pole> pq2 = new PriorityQueue<>(new Comparator<Pole>() {
			@Override
			public int compare(Pole o1, Pole o2) {
				return o2.h - o1.h; // 내림차순
			}
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			pq1.add(new Pole(l, h));
			maxH = Math.max(maxH, h);
		}
		
		int sum = 0;
		// 1) 최고층까지
		int prevl = pq1.peek().l;
		int prevh = pq1.peek().h;
		while(!pq1.isEmpty()) {
			Pole cur = pq1.poll();
//			System.out.println("최고층까지: Pole(" + cur.l + ", "+ cur.h + ")");
			
			if(cur.h <= maxH && cur.h >= prevh) {
				sum += ((cur.l - prevl) * prevh);
				prevl = cur.l;
				prevh = cur.h;
//				System.out.println("선택: Pole(" + cur.l + ", "+ cur.h + ")" + "sum: " + sum);
			}
			
			if(cur.h == maxH) {
				prevl = cur.l;
				prevh = cur.h;
				sum += maxH;
//				System.out.println("max: Pole(" + cur.l + ", "+ cur.h + ")" + "sum: " + sum);
				
				while(!pq1.isEmpty()) {
					pq2.add(pq1.poll());
				}
				break;
			}
		}
		// 2) 최고층 다음
		while(!pq2.isEmpty()) {
			Pole cur = pq2.poll();
//			System.out.println("최고층이후: Pole(" + cur.l + ", "+ cur.h + ")");
			
			if(cur.l > prevl && cur.h <= prevh) {
				sum += ((cur.l - prevl) * cur.h);
				prevl = cur.l;
				prevh = cur.h;
//				System.out.println("선택: Pole(" + cur.l + ", "+ cur.h + ")" + "sum: " + sum);
			}
		}
		
		System.out.println(sum);
	}

}

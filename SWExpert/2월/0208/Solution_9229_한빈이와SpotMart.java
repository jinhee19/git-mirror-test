import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	public static ArrayList<Integer> snacks = new ArrayList<Integer>();
	public static boolean isChecked[];
	public static int N, M;
	public static int ans;
	
	public static void find(int count, int weight) {
		if(count == 2) {
			if(weight <= M)
				if(ans < weight)
					ans = weight;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isChecked[i]) {
				isChecked[i] = true;
				find(count + 1, weight + snacks.get(i));
				isChecked[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isChecked = new boolean[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++)
				snacks.add(Integer.parseInt(st.nextToken()));
			
			find(0, 0);
			
			if(ans == 0)
				ans = -1;
			
			System.out.println("#" + tc + " " + ans);
			snacks.clear();
			ans = 0;
		}
	}
}

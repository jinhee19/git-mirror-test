import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	public static ArrayList<int[]> gradient = new ArrayList<int[]>();
	public static int N;
	public static int L;
	public static int ans;
	
	public static void combi(int calorie, int score, int count) {
		if(calorie > L) {
			return;
		}
		
		if(count == N) {
			if(ans < score)
				ans = score;
			return;
		}
		
		combi(calorie + gradient.get(count)[1], score+gradient.get(count)[0], count + 1);
		combi(calorie, score, count + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				gradient.add(new int[] {score, cal});
			}
			
			combi(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
			gradient.clear();
		}
	}
}

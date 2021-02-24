import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6730_장애물경주난이도 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] heights = new int[N];
			int upMax = 0;
			int downMax = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++)
				heights[i] = Integer.parseInt(st.nextToken());
			
			int up = 0;
			int down = 0;
			
			for(int i = 0; i < N-1; i++) {
				if(heights[i] < heights[i+1]) {
					up = heights[i+1] - heights[i];
					if(up > upMax)
						upMax = up;
				}else if(heights[i] > heights[i+1]){
					down = heights[i] - heights[i+1];
					if(down > downMax)
						downMax = down;
				}
			}
			
			System.out.println("#" + tc + " " + upMax + " " + downMax);
			
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] values = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++)
					values[i][j] = line.charAt(j) - '0';
			}
			
			int middle = N/2;
			int len = 0;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += values[i][middle];
				for(int j = 1; j <= len; j++) {
					sum += values[i][middle-j];
					sum += values[i][middle+j];
				}
				if(i <= N/2 - 1)
					len++;
				else
					len--;
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}

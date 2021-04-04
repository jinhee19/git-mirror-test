import java.util.Arrays;
import java.util.Scanner;

public class Main_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] costs = new int[N+1][3];
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 3; j++)
				costs[i][j] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][3];
		
		dp[1][0] = costs[1][0];
		dp[1][1] = costs[1][1];
		dp[1][2] = costs[1][2];
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] + costs[i][0], dp[i-1][2] + costs[i][0]);
			dp[i][1] = Math.min(dp[i-1][0] + costs[i][1], dp[i-1][2] + costs[i][1]);
			dp[i][2] = Math.min(dp[i-1][0] + costs[i][2], dp[i-1][1] + costs[i][2]);
		}
		
		int[] list = new int[3];
		list[0] = dp[N][0];
		list[1] = dp[N][1];
		list[2] = dp[N][2];
		
		Arrays.sort(list);
		
		System.out.println(list[0]);
	}
}

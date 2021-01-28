package baekjoon.jan;

import java.util.Scanner;

public class BOJ_9095 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] dp;
		
		for(int i = 0; i < T; i++) {
			int N = scan.nextInt();
			dp = new int[N+1];
			
			dp[1] = 1;
			if(N >= 2) dp[2] = 2;
			if(N >= 3) dp[3] = 4;
			
			for(int j = 4; j <= N; j++)
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			
			System.out.println(dp[N]);
		}
		
		scan.close();
	}
}

package baekjoon.jan;

import java.util.Scanner;

/* 쉬운 계단 수 */
public class BOJ_10844 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long ans = 0;
		long[][] dp = new long[N+1][10];
		
		dp[1][0] = 0;
		for(int i = 1; i <= 9; i++)
			dp[1][i] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0)
					dp[i][j] = dp[i-1][j+1];
				else if(j == 9)
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				dp[i][j] = dp[i][j]%1000000000;
			}
		}
		
		for(int i = 0; i <= 9; i++)
			ans = ans + dp[N][i];
		System.out.println(ans%1000000000);
		scan.close();
	}
}

package baekjoon.jan;

import java.util.Scanner;

/* 쉬운 계단 수 */
public class BOJ_10844 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] dp = new int[N+1];
		
		dp[1] = 9;
		if(N >= 2) dp[2] = 17;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = (2*dp[i-1] - 2)%1000000000;
		}
		
		System.out.println(dp[N]);
		scan.close();
	}
}

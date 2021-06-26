package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[M+1];
			fac[1] = 1;
			
			for(int i = 2; i <= M; i++)
				fac[i] = fac[i-1]*i;
			
			if(N == M)
				System.out.println(1);
			else {
				System.out.println(fac[M] + ", " + fac[N] + ", " + fac[M-N]);
				System.out.println(fac[M]/(fac[N]*fac[M-N]));
			}
		}
	}
}

/*
 * 분류 : 수학, 다이나믹 프로그래밍, 조합론
 * 시간 제한 : 0.5초
 * 메모리 제한 : 128MB
 * 
 * 문제 풀이 : mCn
 */

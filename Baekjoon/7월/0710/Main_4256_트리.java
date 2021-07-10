package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4256_Æ®¸® {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] pre = new int[n];
			int[] in = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				pre[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				in[i] = Integer.parseInt(st.nextToken());
			
			
		}
	}
}

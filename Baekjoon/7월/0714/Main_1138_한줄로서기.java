package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] info = new int[N];
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			info[i] = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < N; i++)
			System.out.print(answer[i] + " ");
		
	}
}

/*
 * 분류 : 구현
 */

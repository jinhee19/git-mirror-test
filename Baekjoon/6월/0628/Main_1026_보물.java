package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1026_보물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A); // 오름차순 정렬
		Arrays.sort(B, Collections.reverseOrder()); // 내림차순 정렬
		
		int answer = 0;
		for(int i = 0; i < N; i++)
			answer += A[i] * B[i];
		
		System.out.println(answer);
	}
}	

/*
 * 분류 : 수학, 정렬
 */

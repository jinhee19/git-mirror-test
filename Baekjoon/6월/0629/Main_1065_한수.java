package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		String num = Integer.toString(N);
		
		if(num.length() == 1 || num.length() == 2) 
			System.out.println(N);
		else {
			answer = 99;
			for(int i = 100; i <= N; i++) {
				
			}
			
			System.out.println(answer);
		}
	}
}

/*
 * 분류 : 브루트포스 알고리즘
 */

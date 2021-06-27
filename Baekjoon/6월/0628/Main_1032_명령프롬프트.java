package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032_명령프롬프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] files = new String[N];
		
		for(int i = 0; i < N; i++)
			files[i] = br.readLine();
		
		int len = files[0].length();
		String answer = "";
		boolean flag = true;
		
		for(int i = 0; i < len; i++) {
			char c = files[0].charAt(i);
			for(int j = 1; j < N; j++) {
				if(c != files[j].charAt(i)) {
					flag = false;
					break;
				}
					
			}
			if(flag == false)
				answer += "?";
			else
				answer += c;
			flag = true;
		}
		
		System.out.println(answer);
	}
}

/*
 * 분류 : 구현, 문자열
 */
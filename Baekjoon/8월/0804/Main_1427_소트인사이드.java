package baekjoon.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); 
		Integer[] num = new Integer[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			num[i] = str.charAt(i) - '0';
		}
		
		Arrays.sort(num, Collections.reverseOrder());
		
		String answer = "";
		
		for(int i = 0; i < num.length; i++)
			answer += Integer.toString(num[i]);
		
		System.out.println(answer);
	}
}

/*
 * 분류 : 문자열, 정렬
 */

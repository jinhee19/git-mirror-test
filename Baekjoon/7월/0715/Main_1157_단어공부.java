package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int[] count = new int[26];
		int max = 0;
		char answer = '0';
		
		word = word.toUpperCase();
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int num = ch - '0' - 17;
			count[num]++;
			if(max < count[num]) {
				answer = (char) ('A' + num);
				max = count[num];
			}else if(max == count[num]) {
				answer = '?';
				break;
			}	
		}
		
		if(max == -1)
			System.out.println("?");
		else
			System.out.println(Character.toString(answer));
		
		
		
	}
}

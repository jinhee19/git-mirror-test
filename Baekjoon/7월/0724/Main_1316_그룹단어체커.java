package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			boolean[] alphabet = new boolean[26];
			char ch = word.charAt(0);
			alphabet[(int)ch - 96] = true;
			int j = 1;
			
			for(j = 1; j < word.length(); j++) {
				if(ch != word.charAt(j) && alphabet[(int)word.charAt(j) - 96])
					break;
				else {
					alphabet[(int)word.charAt(j)-96] = true;
				}
			}
			
			if(j >= word.length())
				answer++;
		}
		
		System.out.println(answer);
		
	}
}

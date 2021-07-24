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
			alphabet[(int)ch - 97] = true;
			int j = 1;
			
			for(j = 1; j < word.length(); j++) {
				char temp = word.charAt(j);
				if(ch != temp) {
					if(alphabet[(int)temp - 97] == true)
						break;
					else {
						ch = temp;
						alphabet[(int)temp - 97] = true; 
					}
				}
			}
			
			if(j >= word.length())
				answer++;
		}
		
		System.out.println(answer);
		
	}
}

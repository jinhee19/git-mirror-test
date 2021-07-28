package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1373_2진수8진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String two_num = br.readLine();
		int ten_num = 0;
		
		for(int i = 0; i < two_num.length(); i++) {
			char ch = two_num.charAt(two_num.length() - 1 -i);
			
			if(ch == '1') {
				ten_num += Math.pow(2, i);
			}
		}
		
		String eight_num = "";
		
		Stack<Character> stack = new Stack<>();
		
	}
}

// 204 -> 25, 4 -> 3, 1 -> 0, 3

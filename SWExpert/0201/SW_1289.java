package day0201;

import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i = 1; i <= T; i++) {
			String origin = scan.next();
			int num = 0;
			char check = '1';
			
			for(int j = 0; j < origin.length(); j++) {
				if(origin.charAt(j) == check) {
					num++;
					if(check == '1')
						check = '0';
					else
						check = '1';
				}
			}
			
			System.out.println("#" + i + " " + num);
		}
		
	}
}

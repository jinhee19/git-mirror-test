package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			int[][] nums = new int[num+1][2];
			// int[][] nums = new int[41][2];
			
			if(num >= 0) {
				nums[0][0] = 1;
			}
			if(num >= 1) {
				nums[1][1] = 1;
			}
			
			if(num >= 2) {
				for(int i = 2; i <= num; i++) {
					nums[i][0] = nums[i-1][0] + nums[i-2][0];
					nums[i][1] = nums[i-1][1] + nums[i-2][1];
				}
			}
			System.out.println(nums[num][0] + " " + nums[num][1]);
		}
	}
}

/*
 * 1차 시도 실패 -> 시간초과 (시간 제한 0.25초)
 * 재귀 시간복잡도 -> O(2^n)
 */

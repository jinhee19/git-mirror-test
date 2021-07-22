package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1296_데이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String minsik = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] list = new String[N];
		double max = 0;
		String answer = "";
		int minL = 0, minO = 0, minV = 0, minE = 0;
		
		for(int i = 0; i < minsik.length(); i++) {
			if(minsik.charAt(i) == 'L')
				minL++;
			else if(minsik.charAt(i) == 'O')
				minO++;
			else if(minsik.charAt(i) == 'V')
				minV++;
			else if(minsik.charAt(i) == 'E')
				minE++;
		}
		
		for(int i = 0; i < N; i++)
			list[i] = br.readLine();
		
		Arrays.sort(list);
		answer = list[0];
		
		for(int i = 0; i < N; i++) {
			int L = minL, O = minO, V = minV, E = minE;
			double percentage = 0;
			for(int j = 0; j < list[i].length(); j++) {
				if(list[i].charAt(j) == 'L')
					L++;
				else if(list[i].charAt(j) == 'O')
					O++;
				else if(list[i].charAt(j) == 'V')
					V++;
				else if(list[i].charAt(j) == 'E')
					E++;
			}
			percentage = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E))%100;
			if(max < percentage) {
				max = percentage;
				answer = list[i];
			}
		}
		
		System.out.println(answer);
	}
}

/*
 * 분류 : 구현, 문자열
 */
package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1085_직사각형에서탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = 0, h = 0, x = 0, y = 0;
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int midw = w/2;
		int midh = h/2;
		
		int answer = 0;
		
		if(x < midw && y < midh) {
			if(x < y)
				answer = x;
			else
				answer = y;
		}else if(x < midw && y >= midh) {
			if(x < (h - y))
				answer = x;
			else
				answer = h-y;
		}else if(x >= midw && y < midh) {
			if((w-x) < y)
				answer = w - x;
			else
				answer = y;
		}else {
			if((w-x) < (h-y))
				answer = w - x;
			else
				answer = h - y;
		}
		
		System.out.println(answer);
	}
}

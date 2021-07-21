package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1269_´ëÄªÂ÷ÁýÇÕ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int aNum = Integer.parseInt(st.nextToken());
		int bNum = Integer.parseInt(st.nextToken());
		
		int[] A = new int[aNum];
		int[] B = new int[bNum];
		
		st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < aNum; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < bNum; i++)
			B[i] = Integer.parseInt(st.nextToken());
	}
}

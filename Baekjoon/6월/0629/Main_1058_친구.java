package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1058_친구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] infos = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			infos[i] = br.readLine().toCharArray();
		}
		
		
	}
}

/*
 * 예상 분류 : 그래프
 * 분류 : 그래프 이론, 그래프 탐색, 브루트포스 알고리즘, 깊이 우선 탐색
 */

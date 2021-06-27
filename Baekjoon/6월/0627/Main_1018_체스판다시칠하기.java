package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static char[][] board;
	
	static int setColor(int x, int y) {
		int num = 0;
		char check = board[y][x];
		
		for(int i = y; i < y+8; i++) {
			for(int j = x; j < x+8; j++) {
				if(j == x) {
					if(check != board[i][j]) { 
						num++;
						check = (check == 'W') ? 'W' : 'B';
					}
					else
						check = board[i][j];
				}
				else {
					if(check == board[i][j]) {
						num++;
						check = (check == 'W') ? 'B' : 'W';
					}
					else
						check = board[i][j];
				}
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		board = new char[N][M];
		
		for(int i = 0; i < N; i++) { // 보드의각 행의 상태 : B(검은색), W(흰색)
			board[i] = br.readLine().toCharArray();			
		}
		
		int num = 0;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				num = setColor(j, i);
				
				if(answer > num)
					answer = num;
			}
		}
		System.out.println(answer);
	}
}


/*
 * 분류 : 브루트포스 알고리즘
 *  
 */
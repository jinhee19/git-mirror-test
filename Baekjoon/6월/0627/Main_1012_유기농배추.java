package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int M, N;
	static int[][] board;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int px = temp[0];
			int py = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if(board[ny][nx] == 1) {
					board[ny][nx] = 0;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 위치의 개수 
			
			int[][] infos = new int[K][2];
			board = new int[N][M];
			
			int x = 0, y = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()); // x (가로)
				y = Integer.parseInt(st.nextToken()); // y (세로)
				infos[i][0] = x;
				infos[i][1] = y;
				board[y][x] = 1;
			}
			
			int answer = 0;
			
			for(int i = 0; i < K; i++) {
				x = infos[i][0];
				y = infos[i][1];
				if(board[y][x] == 1) {
					bfs(x, y);
					answer++;
				}
			}
			
			System.out.println(answer);
		}
	}
}

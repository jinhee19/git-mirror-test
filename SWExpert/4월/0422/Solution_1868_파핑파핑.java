import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑 {
	static int ans;
	static int N;
	static char[][] board;
	static int[][] bombCnt;
	static boolean[][] check;
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		check[y][x] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			if(bombCnt[temp[1]][temp[0]] != 0)
				continue;
		
			for(int i = 0; i < 8; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(check[ny][nx]) 
					continue;
				check[ny][nx] = true;
				queue.add(new int[] {nx,ny});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			check = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			// 폭탄의 위치에는 check를 true로 표시(나중에 남는 .에는 false로 표시될 것이기 때문에 이를 세기 위해서)
			for(int i =0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == '*')
						check[i][j] = true;
				}
			}
			// '.' 각 위치의 주변에 있는 폭탄의 개수 표시
			bombCnt = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == '.') {
						int cnt = 0;
						for(int k = 0; k < 8; k++) {
							int nx = j + dx[k];
							int ny = i + dy[k];
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue;
							if(board[ny][nx] == '*')
								cnt++;
						}
						bombCnt[i][j] = cnt;
					}
				}
			}
			
			// 주변 폭탄의 개수가 0인 곳 먼저 방문(주변에 숫자로 표시할 수 있는 곳 check를 true로 변경)
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(bombCnt[i][j] == 0 && !check[i][j]) {
						bfs(j, i);
						ans++;
					}
				}
			}
			
			// 나머지 위치(.)를 방문하기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!check[i][j])
						ans++;
				}
			}
			
			sb.append("#" + tc + " " + ans + "\n");
			ans = 0;
		}
		
		System.out.println(sb);
	}

}

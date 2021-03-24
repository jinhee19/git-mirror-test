import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int H, W;
	static int cheese;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void meltingCheese() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		int x = 0, y = 0, nx = 0, ny = 0;
		visited = new boolean[H][W];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			x = temp[1];
			y = temp[0];
			
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx]) continue;
				if(board[ny][nx] == 1) {
					board[ny][nx] = 0;
					cheese--;
				}
				else {
					queue.add(new int[] {ny, nx});
				}
				visited[ny][nx] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		cheese = 0;
		board = new int[H][W];
		visited = new boolean[H][W];
		int time = 0;
		int remains = 0;
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1)
					cheese++;
			}
		}
		
		while(cheese != 0) {
			remains = cheese;
			meltingCheese();
			time++;
		}
		
		System.out.println(time + "\n" + remains);
	}
}

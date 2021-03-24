import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Square{
	int x;
	int y;
	int min;
	int k;
	
	public Square(int y, int x, int min, int k) {
		this.x = x;
		this.y = y;
		this.min = min;
		this.k = k;
	}
}

public class Main_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] board;
	static int ans = -1;
	static boolean[][][] visited;
	// 원숭이의 움직임
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	// 말의 움직임
	static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static void bfs() {
		Queue<Square> queue = new LinkedList<>();
		queue.add(new Square(0, 0, 0, 0));
		visited[0][0][0] = true;
		int x = 0, y = 0, min = 0,nx = 0, ny = 0, k = 0;
		
		while(!queue.isEmpty()) {
			Square temp = queue.poll();
			x = temp.x;
			y = temp.y;
			min = temp.min;
			k = temp.k;
			
			if(x == W-1 && y == H-1) {
				ans = min;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx][k]) continue;
				if(board[ny][nx] == 1) continue;
				visited[ny][nx][k] = true;
				queue.add(new Square(ny, nx, min+1, k));
			}	
			
			if(k == K) continue;
	
			for(int i = 0; i < 8; i++) {
				nx = x + hx[i];
				ny = y + hy[i];
				
				if(nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx][k+1]) continue;
				if(board[ny][nx] == 1) continue;
				visited[ny][nx][k+1] = true;
				queue.add(new Square(ny, nx, min+1, k+1));
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		board = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		bfs();

		System.out.println(ans);
	}
}

import java.util.Scanner;
import java.util.Stack;

public class Solution_1861_정사각형방 {
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};
	public static boolean[][] visited;
	public static int[][] arr;
	public static int N;
	
	public static int Move(int x, int y) {
		Stack<int[]> stack = new Stack<>();
		int move = 1;
		
		visited[y][x] = true;
		stack.push(new int[] {x, y});
		while(!stack.empty()) {
			int[] item = stack.pop();
			int px = item[0];
			int py = item[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx > -1 && nx < N && ny > -1 && ny < N) {
					if(!visited[ny][nx] && (arr[ny][nx]-arr[py][px] == 1)) {
						visited[ny][nx] = true;
						stack.push(new int[] {nx, ny});
						move++;
					}
				}
			}
		}
		return move;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			int max = 0;
			int start = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					int move = Move(j, i);
				
					if(max < move) {
						max = move;
						start = arr[i][j];
					}
					else if(move != 0 && max == move) {
						if(arr[i][j] < start)
							start = arr[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + start + " " + max);
		}
	}
}

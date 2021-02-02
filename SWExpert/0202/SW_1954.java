import java.util.Scanner;

public class Solution_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int x = 0;
			int y = 0;
			int dir = 0;
			
			System.out.println("#"+tc);
			
			if(N == 1) {
				System.out.println(1);
				continue;
			}
			
			int[][] arr = new int[N][N];
	
			
			for(int i = 1; i <= N*N; i++) {
				arr[y][x] = i;
				x = x + dx[dir];
				y = y + dy[dir];
				
				if(x < 0 || x >= N || y < 0 || y >= N) {
					x = x - dx[dir];
					y = y - dy[dir];
					
					dir = (dir+1)%4;
					
					x = x + dx[dir];
					y = y + dy[dir];
				}
				
				if(arr[y][x] != 0) {
					x = x - dx[dir];
					y = y - dy[dir];
					
					dir = (dir+1)%4;
					
					x = x + dx[dir];
					y = y + dy[dir];
				}
				
				
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
			
		}
	}
}

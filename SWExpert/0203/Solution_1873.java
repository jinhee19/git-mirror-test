import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] arr = new char[H][W];
			
			int x = 0;
			int y = 0;
			int dir = 0; //0: 위, 1: 오, 2: 아래, 3: 왼
			
			for(int i = 0; i < H; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] input = new char[N];
			
			input = br.readLine().toCharArray();
			
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					if(arr[i][j] == '<') {
						x = j;
						y = i;
						dir = 3;
					}else if(arr[i][j] == '^') {
						x = j;
						y = i;
						dir = 0;
					}else if(arr[i][j] == '>') {
						x = j;
						y = i;
						dir = 1;
					}else if(arr[i][j] == 'v') {
						x = j;
						y = i;
						dir = 2;
					}
			}
			
			for(int i = 0; i < N; i++) {
				if(input[i] == 'U') {
					dir = 0;
					arr[y][x] = '^';
					if(y-1 >= 0 && arr[y-1][x] == '.') {
						arr[y][x] = '.';
						y--;
						arr[y][x] = '^';
					}
				}else if(input[i] == 'D') {
					dir = 2;
					arr[y][x] = 'v';
					if(y+1 < H && arr[y+1][x] == '.') {
						arr[y][x] = '.';
						y++;
						arr[y][x] = 'v';
					}
				}else if(input[i] == 'L') {
					dir = 3;
					arr[y][x] = '<';
					if(x-1 >= 0 && arr[y][x-1] == '.') {
						arr[y][x] = '.';
						x--;
						arr[y][x] = '<';
					}
				}else if(input[i] == 'R') {
					dir = 1;
					arr[y][x] = '>';
					if(x+1 < W && arr[y][x+1] == '.') {
						arr[y][x] = '.';
						x++;
						arr[y][x] = '>';
					}
				}else{
					int nx = x;
					int ny = y;
					if(dir == 0) {
						ny--;
						while(ny >= 0) {
							if(arr[ny][nx] == '*') {
								arr[ny][nx] = '.';
								break;
							}
							else if(arr[ny][nx] == '#')
								break;
							ny--;
						}
					}
					else if(dir == 1) {
						nx++;
						while(nx < W) {
							if(arr[ny][nx] == '*') {
								arr[ny][nx] = '.';
								break;
							}
							else if(arr[ny][nx] == '#')
								break;
							nx++;
						}
					}
					else if(dir == 2) {
						ny++;
						while(ny < H) {
							if(arr[ny][nx] == '*') {
								arr[ny][nx] = '.';
								break;
							}
							else if(arr[ny][nx] == '#')
								break;
							ny++;
						}
					}
					else {
						nx--;
						while(nx >= 0) {
							if(arr[ny][nx] == '*') {
								arr[ny][nx] = '.';
								break;
							}
							else if(arr[ny][nx] == '#')
								break;
							nx--;
						}
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
		} //testcase
	}
}

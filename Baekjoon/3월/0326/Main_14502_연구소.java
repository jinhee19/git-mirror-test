import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M; // 세로, 가로
	static int[][] map;
	static ArrayList<int[]> virus_loc = new ArrayList<>();
	static Queue<int[]> queue = new LinkedList<>();
	static int max;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int count(int[][] temp) {
		int cnt = 0;
		
		for(int i = 0;i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
	
	static int virus() {
		int[][] clone = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				clone[i][j] = map[i][j];
			}
		}
		
		int x = 0, y = 0, nx = 0, ny = 0;
		
		for(int[] loc: virus_loc)
			queue.add(loc);
		
		while(!queue.isEmpty()){
			int[] temp = queue.poll();
			y = temp[0];
			x = temp[1];
			
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if(nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if(clone[ny][nx] == 0) {
					clone[ny][nx] = 2;
					queue.add(new int[] {ny, nx});
				}
			}
		}
		
		return count(clone);
	}
	
	
	static void block(int cnt) {
		if(cnt == 3) {
			int safe = virus();
			if(safe > max)
				max = safe;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					virus_loc.add(new int[] {i, j});
			}
		}
		
		block(0);
		
		System.out.println(max);
	}
}

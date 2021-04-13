import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// BFS + PriorityQueue
public class Solution_1249_보급로 {
	static class Place implements Comparable<Place>{
		int x;
		int y;;
		int time;
		
		public Place(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Place o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			// 도로 상태
			for(int i = 0; i < N; i++) {
				char[] arr = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = arr[j] - '0';
				}
			}

			// 필요한 정보 - x, y, 파여진 도로의 깊이
			PriorityQueue<Place> queue = new PriorityQueue<>();
			queue.add(new Place(0, 0, 0));
			map[0][0] = -1;
			
			int x = 0, y = 0, time = 0;
			int answer = Integer.MAX_VALUE;
			
			while(!queue.isEmpty()) {
				Place p = queue.poll();
				x = p.x;
				y = p.y;
				time = p.time;
				
				if(x == N-1 && y == N-1) {
					answer = time;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if(map[ny][nx] == -1)
						continue;
					queue.add(new Place(nx, ny, time + map[ny][nx]));
					map[ny][nx] = -1;
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}
}

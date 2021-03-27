import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	// kruscal 탐색을 위한 edges 배열(시작 섬, 도착 섬, 가중치 = 거리)
	static ArrayList<Island> edges = new ArrayList<>();
	static ArrayList<int[]> islands = new ArrayList<>();
	static ArrayList<ArrayList<int[]>> island_set = new ArrayList<>(); 
	static boolean[][] visited;
	static int[] parents;
	
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static class Island implements Comparable<Island>{
		private int start;
		private int end;
		private int weight;
		
		public Island(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Island o) {
			return this.weight - o.weight;
		}		
	}

	// 각 섬에 번호 붙이기
	static void setRoom(int x, int y,int num) {	
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y,x});
		visited[y][x] = true;
		map[y][x] = num;
		island_set.get(num-1).add(new int[] {y,x});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int px = temp[1];
			int py = temp[0];
			
			// 사방탐색
			for(int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) continue;
				// 범위를 벗어나지 않고, 방문하지 않은 위치 중 섬인 경우
				if(map[ny][nx] == 1) {
					visited[ny][nx] = true;
					map[ny][nx] = num;
					island_set.get(num-1).add(new int[] {ny,nx});
					queue.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	// 직선 탐색
	static void dfs(int x, int y, int dir, int start, int end, int len) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		// 그 다음 위치가 경계를 벗어나면
		if(nx < 0 || nx >= M || ny <0 || ny >= N)
			return;
		// 그 다음 위치가 도착 섬 번호인경우
		if(map[ny][nx] == end) {
			// 도착 섬 까지의 길이가 2이상인 경우
			if(len >= 2) {
				// 현재 위치까지의 다리 길이가 dist에 저장된 값보다 작다면 갱신
				if(dist[start][end] > len) {
					// 무향 그래프이기 때문에 시작-도착, 도착-시작 배열 채워줘야함.
					dist[start][end] = len;
					dist[end][start] = len;
				}
			}
			return;
		}
		// 그 다음 위치가 바다(0)인 경우 다음 위치 탐색(dfs) -> 길이는 1 늘어남
		if(map[ny][nx] == 0) dfs(x + dx[dir], y + dy[dir], dir, start, end, len+1);
	}
	
	static void getBridgeLen(int island1, int island2) {
		// 시작 섬에 해당하는 섬들
		ArrayList<int[]> start = island_set.get(island1-1);
		
		for(int i = 0; i < start.size(); i++) {
			int x = start.get(i)[1];
			int y = start.get(i)[0];
			// 사방(dx, dy) 직선(dfs) 탐색
			// 방문했던 위치를 다시 방문할 가능성 X -> visited 배열 필요 X
			for(int j = 0; j < 4; j++) {
				dfs(x, y, j, island1, island2, 0); // x, y, 방향, 시작 섬 번호, 도착 섬 번호
			}
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a; // 자신이 루트이면 자신의 번호 리턴
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		
		if(ar != br) { // 두 노드의 root가 다르면 합침
			parents[br] = ar;
			return true;
		}
		// 두 노드의 root가 같다면 싸이클 발생
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)// 섬일 경우
					islands.add(new int[] {i, j});
			}
		}

		// 섬들에 번호 매기기
		int num = 1; // 섬의 번호
		for(int i = 0; i < islands.size(); i++) {
			int x = islands.get(i)[1];
			int y = islands.get(i)[0];
			if(!visited[y][x]) { // 번호가 매겨지지 않은 섬이라면
				// 섬들의 분류
				island_set.add(new ArrayList<int[]>());
				setRoom(x, y, num);
				num++; // num에 해당하는 번호가 매겨진 섬들의 분류 끝나면 그 다음 번호로 변경
			}			
		}
		
		// 섬 번호 확인하기
		/*
		for(int k = 0; k < N; k++) {
			for(int j = 0; j < M; j++) {
					System.out.print(map[k][j] + " ");
			}
			System.out.println();
		}
		*/
		
		// 각 섬 사이의 최소 거리 배열
		dist = new int[num+1][num+1];
		// 최소 거리 배열 초기화
		for(int i = 1; i <= num; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		// 각 섬 사이의 다리 최소 길이 구하기 
		/*
		 * 시작 번호에 해당하는 모든 섬들에서 각각 사방 직선으로 탐색하다가
		 * 도착 번호에 해당하는 섬을 만나면 len 갱신
		 * => 최종적으로 시작 섬에서 도착 섬까지의 최소 거리 구할 수 있음
		 */
		// 1-2,1-3,1-4,2-3,2-4,3-4
		// 현재 섬의 개수 = num - 1 (위의 코드에서 num++을 한 번 더 했기 때문)
		for(int i = 1; i < num; i++) {
			for(int j = i+1; j < num; j++) {
				getBridgeLen(i, j);
				// kruscal 탐색을 위해서 Island로 저장
				edges.add(new Island(i, j, dist[i][j]));
			}
		}
		
		// 각 섬 사이의 최소 다리 길이 배열을 가지고 최소 경로 구하기
		// union-find
		int result = 0;
		parents = new int[num+1];
		Collections.sort(edges); // 가중치 기준으로 오름차순 정렬
	
		// 각 섬들 사이의 거리 출력
		/*
		for(Island is : edges) {
			System.out.println("start : " + is.start + ", end : " + is.end + ", weight : " + is.weight);
		}
		*/
		
		// parent 초기화
		for(int i = 1; i < num; i++) {
			parents[i] = i;
		}
		
		// 각 섬 사이의 간선에 대해 찾아보면서
		for(Island is : edges) {
			if(union(is.start, is.end)) { // 싸이클이 아니라면(두 섬 사이에 다리로 연결되어 있지 않다면)
				// 각 섬 사이의 거리가 Integer.MAX_VALUE인 경우 -> 각 섬 사이를 잇는 다리가 X
				if(is.weight != Integer.MAX_VALUE)
					result += is.weight;
			}
		}
		
		// 모든 섬을 연결하는 것 불가능(result == 0)
		if(result == 0)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}

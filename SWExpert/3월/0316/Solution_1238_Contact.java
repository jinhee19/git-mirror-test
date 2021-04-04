import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int ans;
	static boolean[] visited = new boolean[101];
	static boolean[][] graph = new boolean[101][101];
	
	static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		int maxCnt = -1;
		int cnt = 0;
		int node = 0;
		queue.add(new int[] {start,0});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			node = queue.peek()[0];
			cnt = queue.peek()[1];
			queue.poll();
			
			if(cnt == maxCnt) {
				ans = Math.max(node, ans);
			}
			else if(cnt > maxCnt) {
				maxCnt = cnt;
				ans = node;
			}
			
			for(int i = 1; i <= 100; i++) {
				if(graph[node][i] == false) { continue;}
				if(visited[i]) {continue;}
				visited[i] = true;
				queue.add(new int[] {i, cnt+1});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < size/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(graph[from][to] == true)
					continue;
				graph[from][to] = true;
			}
			
			bfs(start);
			System.out.println("#" + tc + " " + ans);
			
			Arrays.fill(visited, false);
			for(int i = 1; i <= 100; i++)
				Arrays.fill(graph[i], false);
			ans = 0;
		}
	}
}

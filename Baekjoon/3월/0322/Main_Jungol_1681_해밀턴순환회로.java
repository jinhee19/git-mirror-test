import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 참고 블로그 : https://skygood95.tistory.com/28 
 * 			-> 다익스트라 + 비트 연산자 ==> BFS
 */
public class Main_Jungol_1681_해밀턴순환회로 {
	static int N;
	static int[][] costs;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int cnt, int vertex, int total) {
		if(cnt == N) { // 마지막 장소까지 감
			int lastWeight = costs[vertex][1]; // 마지막 장소에서 출발지까지의 거리
			if(min > total + lastWeight && lastWeight > 0) // 마지막 장소에서 출발지까지의 거리가 0일 가능성도 고려
				min = total + lastWeight;
			return;
		}
		
		if(total > min)
			return;
		for(int i = 1; i <= N; i++) {
			if(costs[vertex][i] > 0 && !visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, i, total + costs[vertex][i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int start = 1;
		int end = 1;
		
		// 장소와 장소를 이동하는 비용 배열
		costs = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 1, 0);
		
		System.out.println(min);
	}
}

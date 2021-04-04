import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 풀이 참고블로그 
 * https://onejunu.tistory.com/87
 * https://gaybee.tistory.com/34
 */

public class Main_1753_최단경로2 {
	static class Edge implements Comparable<Edge>{
		int end;
		int weight;
		
		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		// 각 정점에 연결된 간선 정보 저장하는 배열
		ArrayList<Edge>[] edges = new ArrayList[V+1];
		
		// 배열 초기화(ArrayList)
		for(int i = 1; i < V+1; i++)
			edges[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[s].add(new Edge(e, w));
		}
		
		// dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		
		// dist 배열 초기화
		for(int i = 1; i < V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			// 방문하지않은 정점들 중 최소가중치의 정점 선택
			Edge temp = pq.poll();
			int to = temp.end;
			int val = temp.weight;
			
			if(visited[to]) continue;
			visited[to] = true; // 선택 정점 방문 처리
			
			// 선택된 정점에 연결된 정점들
			for(Edge edge : edges[to]) {
				// 시작정점부터 다음 정점까지의 거리 > 시작정점부터 현재 정점까지의 거리 + 현재정점과 다음 정점사이의 거리
				if(dist[edge.end] > dist[to] + edge.weight) {
					dist[edge.end] = dist[to] + edge.weight;
					// 다음 정점을 pq에 넣음(갱신된 거리로)
					pq.add(new Edge(edge.end, dist[edge.end]));
				}
			}
		}
		
		for(int i = 1; i < V + 1; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
	}
}

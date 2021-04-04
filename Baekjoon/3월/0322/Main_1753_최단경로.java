import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	final static int INF = Integer.MAX_VALUE;
	
	public static class Node implements Comparable<Node>{
		int v;
		int distance;
		
		public Node(int v, int distance) {
			this.v = v;
			this.distance = distance;
		}
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] D = new int[V+1];
		boolean[] visited = new boolean[V+1];
		List<Node>[] matrix = new ArrayList[V+1];
		int start = Integer.parseInt(br.readLine());
	
		Arrays.fill(matrix, new ArrayList<Node>());
		Arrays.fill(D, INF);
		D[start] = 0;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int gra = Integer.parseInt(st.nextToken());
			
			matrix[first].add(new Node(end, gra));
		}
	
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		
		Node current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			if(visited[current.v]) continue;
			
			visited[current.v] = true;
			for(Node node : matrix[current.v]) {
				if(!visited[node.v] && D[node.v] > current.distance + node.distance) {
					D[node.v] = current.distance + node.distance;
					queue.add(new Node(node.v, D[node.v]));
				}
			}
		
		}
		
		for(int i = 1; i < D.length; i++) {
			if(D[i] == INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(D[i]);
		}
	}
}

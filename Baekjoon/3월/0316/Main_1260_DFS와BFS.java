import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static void DFS(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for(int y : graph[x]) {
			if(!visited[y])
				DFS(y);
		}
		/*
		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		visited[start] = true;
		
		while(!stack.empty()) {
			int node = stack.pop();
			System.out.print(node + " ");
			
			for(int i = 0; i < graph[node].size(); i++) {
				if(visited[graph[node].get(i)]) {continue;}
				visited[graph[node].get(i)] = true;
				stack.add(graph[node].get(i));
			}
		}
		*/
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			for(int no : graph[node]) {
				if(visited[no]) {continue;}
				visited[no] = true;
				queue.add(no);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph[from].add(to);
			graph[to].add(from);
		}
		for(int i = 1; i < N+1; i++){
			Collections.sort(graph[i]);
		}
		DFS(V);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(V);
	}
}

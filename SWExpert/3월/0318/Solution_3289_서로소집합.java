import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static int[] parent;
	static int[] rank;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	static int find(int x) {
		if(parent[x] == x) return x;
		
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		int parent_a = find(a);
		int parent_b = find(b);
		
		if(parent_a == parent_b) return;
		else {
			if(rank[parent_a] > rank[parent_b])
				parent[parent_b] = parent_a;
			else if(rank[parent_a] < rank[parent_b])
				parent[parent_a] = parent_b;
			else {
				parent[parent_b] = parent_a;
				rank[parent_b]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			rank = new int[N+1];
			
			for(int i = 1; i <= N; i++)
				parent[i] = i;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int method = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(method == 0) union(a,b);
				
				else {
					if(find(a) == find(b))
						ans.add(1);
					else
						ans.add(0);
				}
			}
			System.out.println("#" + tc + " " + ans.toString());
			ans.clear();
		}
	}
}

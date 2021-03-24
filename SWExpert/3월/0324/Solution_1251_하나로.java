import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 크루스칼 알고리즘
class Node implements Comparable<Node>{
	int start;
	int end;
	double value;
	
	public Node(int start, int end, double value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return (int) (this.value - o.value);
	}
	
}

public class Solution_1251_하나로 {
	static int N;
	static int[] parents;
	static ArrayList<Node> edges = new ArrayList<>();
	
	static void make() {
		for(int i = 0; i < N; i++) {
			parents[i] = i;
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
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			double E = Double.parseDouble(br.readLine());
			
			parents = new int[N];
			
			// 각 섬 사이의 거리(해저터널 길이) 제곱 리스트 -> edges
			int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			for(int i = 0; i < N; i++) {
				x1 = Integer.parseInt(x[i]);
				y1 = Integer.parseInt(y[i]);
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					x2 = Integer.parseInt(x[j]);
					y2 = Integer.parseInt(y[j]);
					edges.add(new Node(i, j, Math.pow(x1-x2, 2) + Math.pow(y1-y2,2)));
				}
			}
			
			make();
			
			// 해저터널 길이가 작은 순서대로 정렬
			Collections.sort(edges);
			double result = 0;
			int count = 0; // 연결 간선(해저터널) 수
			for(Node node : edges) {
				if(union(node.start, node.end)) { // 싸이클이 발생하지 않았다면
					result += node.value;
					count++;
					if(count == N-1)
						break;
				}
			}
			
			// 소수 첫번째 자리에서 반올림
			sb.append("#" + tc + " " + (int)Math.round(result*E) + "\n");
			edges.clear();
		}
		System.out.println(sb);
	}
}

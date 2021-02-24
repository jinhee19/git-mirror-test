import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<String> code = new LinkedList<String>();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++)
				code.add(st.nextToken());
			
			int line = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < line; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				
				for(int j = index; j < index + num; j++) {
					code.add(j, st.nextToken());
				}
			}
			
			sb.append("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				sb.append(code.get(i) + " ");
			}
			sb.append("\n");
			code.clear();
		}
		System.out.println(sb);
	}
}

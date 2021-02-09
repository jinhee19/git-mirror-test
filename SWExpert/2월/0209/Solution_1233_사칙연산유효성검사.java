import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean isNum = false;
			int possible = 1;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int node = Integer.parseInt(st.nextToken());
				String ch = st.nextToken();
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
				}
				if(st.hasMoreTokens()) {
					int right = Integer.parseInt(st.nextToken());
				}
				
				if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
					if(isNum == true) {
						possible = 0;
					}
				}
				else
					isNum = true;
			}
			
			System.out.println("#"+ tc + " " + possible);
		}
	}
}

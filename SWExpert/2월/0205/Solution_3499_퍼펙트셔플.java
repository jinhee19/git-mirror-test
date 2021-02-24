import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 카드의 개수
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ArrayList<String> deq1 = new ArrayList<String>();
			ArrayList<String> deq2 = new ArrayList<String>();
			
			// 퍼펙트 셔플 
			ArrayList<String> perfect = new ArrayList<String>();
			
			for(int i = 0; i < N/2; i++) {
				deq1.add(st.nextToken());
			}
			
			// 홀수인 경우
			if(N%2 != 0)
				deq1.add(st.nextToken());
			
			for(int i = 0; i < N/2; i++) {
				deq2.add(st.nextToken());
			}
			
			// deq1과 deq2에서 각각 하나씩 뽑아서 perfect에 넣음
			for(int i = 0; i < N/2; i++) {
				perfect.add(deq1.get(i));
				perfect.add(deq2.get(i));
			}
			
			// 홀수인 경우
			if(N%2 != 0)
				perfect.add(deq1.get(deq1.size()-1));
			
			sb.append("#" + tc + " ");
			for(int i = 0; i < N; i++)
				sb.append(perfect.get(i) + " ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}

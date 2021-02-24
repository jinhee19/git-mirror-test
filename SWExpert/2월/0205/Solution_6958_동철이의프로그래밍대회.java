import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6958_동철이의프로그래밍대회 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = 0;
			int num = 0;
			int person = 0;
			int[] solve = new int[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++)
					if(Integer.parseInt(st.nextToken()) == 1)
						num++;
				if(max < num)
					max = num;
				
				solve[i] = num;
				num = 0;
			}
			
			Arrays.sort(solve);
			for(int i = 0; i < N; i++)
				if(solve[i] == max)
					person++;
			
			sb.append("#" + tc + " " + person+ " " + max + "\n");
		}
		System.out.println(sb);
	}
}



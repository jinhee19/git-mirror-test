import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] len = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				len[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && len[i] <len[j]+1)
						len[i] = len[j]+1;
				}
				if(max < len[i]) max = len[i];
			}
			sb.append("#" + tc + " " + max + "\n");
			
		}
		System.out.println(sb);
	}
}

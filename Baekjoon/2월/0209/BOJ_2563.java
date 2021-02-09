import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] area = new int[100][100];
		int num = 0;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			for(int x = X; x < X+10; x++) {
				for(int y = Y; y < Y+10; y++) {
					area[x][y] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				if(area[i][j] == 1)
					num++;
		System.out.println(num);
	}
}

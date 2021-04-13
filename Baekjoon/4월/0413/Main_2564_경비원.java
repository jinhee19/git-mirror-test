import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> stores = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			stores.add(new int[] {dir, sec});
		}
		
		st = new StringTokenizer(br.readLine());
		int dong_dir = Integer.parseInt(st.nextToken());
		int dong_sec = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			int[] temp = stores.get(i);
			int len = 0;
		
			if(dong_dir == 1) {
				if(temp[0] == 1) 
					len = Math.abs(dong_sec - temp[1]);
				else if(temp[0] == 2)
					len = (h + dong_sec + temp[1] > h + 2*w - dong_sec - temp[1])?h + 2*w - dong_sec - temp[1]:h + dong_sec + temp[1];
				else if(temp[0] == 3)
					len = dong_sec + temp[1];
				else
					len = w - dong_sec + temp[1];
			}
			else if(dong_dir == 2) {
				if(temp[0] == 1) 
					len = (h + dong_sec + temp[1] > h + 2*w - dong_sec - temp[1])?h + 2*w - dong_sec - temp[1]:h + dong_sec + temp[1];
				else if(temp[0] == 2)
					len = Math.abs(dong_sec - temp[1]);
				else if(temp[0] == 3)
					len = h - temp[1] + dong_sec;
				else
					len = w + h - dong_sec - temp[1];
			}
			else if(dong_dir == 3) {
				if(temp[0] == 1) 
					len = dong_sec + temp[1];
				else if(temp[0] == 2)
					len = h-dong_sec + temp[1];
				else if(temp[0] == 3)
					len = Math.abs(dong_sec - temp[1]);
				else
					len = (w + dong_sec + temp[1] > w + 2*h - dong_sec - temp[1])?w + 2*h - dong_sec - temp[1]:w + dong_sec + temp[1];
			}
			else {
				if(temp[0] == 1) 
					len = w - temp[1] + dong_sec;
				else if(temp[0] == 2)
					len = w + h - dong_sec - temp[1];
				else if(temp[0] == 3)
					len = (w + dong_sec + temp[1] > w + 2*h - dong_sec - temp[1])?w + 2*h - dong_sec - temp[1]:w + dong_sec + temp[1];
				else
					len = Math.abs(dong_sec - temp[1]);
			}
			ans += len;
		}
		
		System.out.println(ans);
	}
}

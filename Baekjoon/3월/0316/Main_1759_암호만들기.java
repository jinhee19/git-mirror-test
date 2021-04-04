import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L;
	static int C;
	static char[] alpha;
	
	static void combi(int cnt, int index, String line) {
		if(cnt == L) {
			int a = 0;
			int b = 0;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || 
						line.charAt(i) == 'o' || line.charAt(i) == 'u')
					a++;
				else
					b++;
			}
			if(a > 0 && b > 1) {
				char[] answer = line.toCharArray();
				Arrays.sort(answer);
				System.out.println(answer);
			}
			return;
		}
		
		for(int i = index; i < C; i++) 
			combi(cnt+1, i+1, line + alpha[i]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++)
			alpha[i] = st.nextToken().charAt(0);
		
		Arrays.sort(alpha);
		
		combi(0, 0, "");
		
	}
}	

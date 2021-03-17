import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] stat;
	static boolean[] choice;
	static ArrayList<Integer> teamA = new ArrayList<>();
	static ArrayList<Integer> teamB = new ArrayList<>();
	
	static int calculateDiff() {
		int sumA = 0;
		int sumB = 0;
		
		for(int i = 0; i < teamA.size(); i++) {
			for(int j = 0; j < teamA.size(); j++) {
				sumA += stat[teamA.get(i)][teamA.get(j)];
			}
		}
		
		for(int i = 0; i < teamB.size(); i++) {
			for(int j = 0; j < teamB.size(); j++) {
				sumB += stat[teamB.get(i)][teamB.get(j)];
			}
		}
		
		return Math.abs(sumA - sumB);
	}
	
	static void combi(int cnt, int index) {
		if(cnt == N/2) {
			for(int i = 0; i < N; i++) {
				if(choice[i] == true)
					teamA.add(i);
				else
					teamB.add(i);
			}
			
			int diff = calculateDiff();
			if(min > diff)
				min = diff;
			
			teamA.clear();
			teamB.clear();
			return;
		}
		
		for(int i = index; i < N; i++) {
			choice[i] = true;
			combi(cnt + 1, i+1);
			choice[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		choice = new boolean[N];
		stat = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0, 0);
		System.out.println(min);
	}
}

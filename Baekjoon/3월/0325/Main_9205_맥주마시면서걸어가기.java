import java.util.ArrayList;
import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int martNum = sc.nextInt();
			ArrayList<int[]> loc = new ArrayList<>();
			
			// 상근이네 집, 편의점, 페스티벌의 좌표 입력
			for(int i = 0; i < martNum + 2; i++) {
				loc.add(new int[] {sc.nextInt(), sc.nextInt()});
			}
			
			int bill = 20;
			
			for(int i = 0; i < martNum+1; i++) {
				int[] present = loc.get(i);
				int[] next = loc.get(i+1);
				int end = Math.abs(present[0]-loc.get(martNum+1)[0]) + Math.abs(present[1]-loc.get(martNum+1)[1]);
				int len = Math.abs(present[0]-next[0]) + Math.abs(present[1]-next[1]);
				int need = len/50;
		
				// 현재 가지고 있는 맥주로 페스티벌까지 갈 수 있다면
				if(bill >= end/50)
					break;
				
				// 그렇지 않다면
			}
			
			System.out.println("happy");
		}
	}
}

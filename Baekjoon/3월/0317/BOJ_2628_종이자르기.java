import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int cut = sc.nextInt();

		ArrayList<Integer> w = new ArrayList<Integer>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> area = new ArrayList<Integer>();
		
		w.add(0); h.add(0);
		
		for(int i = 0; i < cut; i++) {
			int dir = sc.nextInt();
			int num = sc.nextInt();
			
			if(dir == 0)  // 가로로 자르는 점선
				h.add(num);
			else // 세로로 자르는 점선
				w.add(num);
		}
		w.add(width); h.add(height);
		Collections.sort(w);
		Collections.sort(h);
		
		for(int i = 0; i < w.size()-1; i++) {
			for(int j = 0; j < h.size()-1; j++) {
				int x= w.get(i+1) - w.get(i);
				int y = h.get(j+1) - h.get(j);
				area.add(x*y);
			}
		}
		Collections.sort(area);

		System.out.println(area.get(area.size()-1));
	}
}

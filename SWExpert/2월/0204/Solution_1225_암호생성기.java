

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int sub = 1;
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) 
				queue.add(sc.nextInt());
			
			while(true) {
				int num = queue.poll();
				num = num - sub;
				if(num > 0 )
					queue.add(num);
				else {
					queue.add(0);
					break;
				}
				sub++;
				if(sub > 5)
					sub = 1;
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}

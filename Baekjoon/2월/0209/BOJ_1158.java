import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_OBJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++)
			queue.add(i);
		
		while(!queue.isEmpty()) {
			int present = queue.poll();
			num++;
			if(num == K) {
				list.add(present);
				num = 0;
			}
			else {
				queue.add(present);
			}	
		}
		System.out.print("<");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i != list.size() -1)
				System.out.print(", ");
		}
		System.out.println(">");
	}
}

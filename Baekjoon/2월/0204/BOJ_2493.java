import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_BJ_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
	
		stack.add(Integer.parseInt(st.nextToken()));
		index.add(1);
		sb.append("0 ");
		for(int i = 1; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			while(!stack.empty()) {
				if(stack.peek() < input) {
					stack.pop();
					index.pop();
				}
				else {
					sb.append(index.peek() + " ");
					break;
				}
			}
			if(stack.empty())
				sb.append("0 ");
			stack.push(input);
			index.push(i+1);
		}
		
		System.out.println(sb);

		
		//3 2 4 5 9
		//3 9   
		//0 1 1 1 1
		//0 1 0 0 0
		//0 1 
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1223_계산기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Character> sign= new Stack<Character>();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			str = br.readLine();
			String change = "";
			
			for(int i = 0; i < N; i++) {
				char ch = str.charAt(i);
				if(ch == '+') {
					while(!sign.empty()) {
						change += sign.pop();
					}
					sign.add(ch);
				}
				else if(ch == '*') {
					sign.add(ch);
				}
				else {
					change += ch;
				}
			}
		
			while(!sign.empty())
				change += sign.pop();
			
			for(int i = 0; i < N; i++) {
				char item = change.charAt(i);
				if(item == '+') {
					int a = stack.pop();
					int b = stack.pop();
					stack.add(a + b);
				}
				else if(item == '*') {
					int a = stack.pop();
					int b = stack.pop();
					stack.add(a * b);
				}
				else {
					stack.add(item-'0');
				}
			}
			
			System.out.println("#" + tc + " " + stack.pop());
		}
	}
}	

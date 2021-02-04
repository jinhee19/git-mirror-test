

import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			Stack<Character> stack = new Stack<Character>();
			int truth = 0;
			
			String string = sc.next();
			
			for(int i = 0; i < len; i++) {
				char input = string.charAt(i);
				if(input == '(' || input == '[' || input == '{' || input == '<')
					stack.push(input);
				else {
					if(!stack.empty()) {
						if(stack.peek() == '(' && input == ')')
							stack.pop();
						else if(stack.peek() == '[' && input == ']')
							stack.pop();
						else if(stack.peek() == '{' && input == '}')
							stack.pop();
						else if(stack.peek() == '<' && input == '>')
							stack.pop();
						else
							break;
					}
					else
						break;
				}
			}
			
			if(stack.size() == 0)
				truth = 1;
			
			System.out.println("#" + tc + " " + truth);
		}
	}
}

package programmers.april;

import java.util.Stack;

public class Solution_괄호변환 {

	static boolean rightSyntax(String str) {
		if(!balanceSyntax(str))
			return false;
		// 괄호의 짝이 맞는 경우
		Stack<Character> stack = new Stack<>();
		
		char c = 0;
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(c == '(')
				stack.add(c);
			else if(c==')' && stack.size() != 0)
				stack.pop();
		}
		if(stack.size() == 0)
			return true;
		
		return false;
	}
	
	static boolean balanceSyntax(String str) {
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(')
				cnt1++;
			else
				cnt2++;
		}
		
		if(cnt1 == cnt2)
			return true;
		return false;
	}
	
	static String find(String str) {
		//1번 
		if(str.length() == 0)
			return "";
		
		//2번(분리)
		String u = "";
		String v = "";
		for(int i = 2; i <= str.length(); i++) {
			u = str.substring(0, i);
			v = str.substring(i, str.length());
			if(balanceSyntax(u) && balanceSyntax(v)) {
				break;
			}
		}
		//3번 - u가 올바른 괄호 문자열인 경우
		if(rightSyntax(u)) {
			u += find(v);
			return u;
		}
		else{ //4번 - u가 올바른 괄호 문자열이 아닌 경우
			String temp = "(";
			temp += find(v);
			temp += ")";
			
			// u의 첫 번째와 마지막 문자 제거 
			u = u.substring(1, u.length()-1);
			// 문자열의 괄호 방향 뒤집기
			String change = "";
			
			for(int i = 0; i < u.length(); i++) {
				if(u.charAt(i) == '(')
					change += ')';
				else
					change += '(';
			}
			temp += change;
			return temp;
		}
	}
	
	public static void main(String[] args) {
		String p = "()))((()";
		String answer = "";
		
		if(rightSyntax(p))
			System.out.println(p);
		else {
			answer = find(p);
			System.out.println(answer);
		}
	}
}

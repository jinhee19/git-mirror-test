package programmers.april;

import java.util.ArrayList;

public class Solution_수식최대화 {
	static long answer = 0;
	
	static long cal(long n1, long n2, char c) {
		if(c == '+')
			return n1 + n2;
		else if(c == '-')
			return n1 - n2;
		else
			return n1*n2;
	}
	
	static void calculate(String order, ArrayList<String> exp) {
		ArrayList<String> temp = (ArrayList<String>) exp.clone();
		long n1 = 0;
		long n2 = 0;
		long result = 0;
		
		for(int i = 0;i < 3; i++) {
			char c = order.charAt(i);
			
			for(int j = 0; j < temp.size(); j++) {
				// if(c == temp.get(j).charAt(0)) -> numberformatException(n1 = Integer.parseIng())
				// -> 음수의 - 부호를 charAt(0)으로 가져와서 비교해서 문제가 된다.
				if(temp.get(j).length() == 1 && c == temp.get(j).charAt(0)) {
					n1 = Long.parseLong(temp.get(j-1));
					n2 = Long.parseLong(temp.get(j+1));
					result = cal(n1, n2, c);
					temp.add(j-1, Long.toString(result));
					temp.remove(j);
					temp.remove(j);
					temp.remove(j);
					j = 0; // temp의 길이가 계속 바뀌기 때문에 j = 0 부터 다시 탐색해야 한다.
				}
			}
		}
		
		result = Long.parseLong(temp.get(0));
		if(Math.abs(result) > answer)
			answer = Math.abs(result);
	}
	
	public static void main(String[] args) {
		String expression = "";
		
		ArrayList<String> arr = new ArrayList<>();
		
		String num = "";
	
		// 숫자와 연산자를 구별해서 배열에 넣기
		for(int i =0 ; i < expression.length(); i++) {
			if(expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
					expression.charAt(i) == '*') {
				arr.add(num);
				arr.add(Character.toString(expression.charAt(i)));
				num = "";
			}else {
				num += expression.charAt(i);
			}
		}
		arr.add(num);
		

		calculate("+-*", arr);
		calculate("+*-", arr);
		calculate("-+*", arr);
		calculate("-*+", arr);
		calculate("*+-", arr);
		calculate("*-+", arr);

		System.out.println(answer);
	}
}

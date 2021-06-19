package programmers.june;

public class 로또의최고순위와최저순위 {
	static int[] lottos = {44, 1, 0, 0, 31, 25};
	static int[] win_nums = {31, 10, 45, 1, 6, 19};
	
	public static void main(String[] args) {
		int[] answer = new int[2];
		
		boolean[] lotto_num = new boolean[46];
		int[] rank = {6, 6, 5, 4, 3, 2, 1};
		
		int same = 0;
		int zero = 0;
		
		for(int i = 1; i <= 45; i++) {
			lotto_num[i] = false;
		}
		
		for(int i = 0; i < win_nums.length; i++) {
			lotto_num[win_nums[i]] = true;
		}
		
		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) 
				zero++;
			else if(lotto_num[lottos[i]])
				same++;
		}
		
		int max = zero + same;
		int min = same;
		
		answer[0] = rank[max];
		answer[1] = rank[min];
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}

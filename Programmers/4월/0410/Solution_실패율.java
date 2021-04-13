package programmers.april;

import java.util.*;

public class Solution_실패율 {
	
	static class Stage implements Comparable<Stage>{
		int num;
		float fail;
		
		public Stage(int num, float fail) {
			this.num = num;
			this.fail = fail;
		}

		@Override
		public int compareTo(Stage o) {
			if(this.fail == o.fail)
				return this.num - o.num; // 오름차순
			else {
				float temp = o.fail - this.fail; // 내림차순
				if(temp > 0)
					return 1;
				else
					return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = new int[N];
		ArrayList<Stage> list = new ArrayList<>();
		
		// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 : n
		// 스테이지에 도달한 플레이어의 수 : n과 같거나 큰 수 
		
		for(int i = 1; i <= N; i++) {
			int not = 0;
			int reach = 0;
			for(int j = 0; j < stages.length; j++) {
				if(stages[j] == i)
					not++;
				if(stages[j] >= i)
					reach++;
			}
			if(not == 0)
				list.add(new Stage(i, 0));
			else
				list.add(new Stage(i, (float)not/reach));
		}

		// 실패율이 높은 스테이지부터 내림차순, 실패율이 같은 경우 작은 번호의 스테이지
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++)
			answer[i] = list.get(i).num;
		
		for(int i : answer)
			System.out.println(i);
	}
}

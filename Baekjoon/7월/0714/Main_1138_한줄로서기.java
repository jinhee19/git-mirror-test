package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 인원 수
		int[] info = new int[N+1];
		int[] answer = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		// 키가 1인 사람부터 왼쪽에 자신보다 큰 사람이 서 있는 수 입력
		for(int i = 0; i < N; i++) {
			info[i+1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(answer[j] == 0 && info[i] == 0) {// 해당 자리가 비어있고 자신보다 왼쪽에 서있어야 할 사람 수만큼 배치되어있다면
					answer[j] = i;
					break;
				}else if(answer[j] == 0) // 아직 자신보다 왼쪽에 서 있어야 할 수만큼 안 서있으므로 빈 자리가 있다면 자신보다 큰 사람이 배정될 예정
					info[i]--;
			}
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(answer[i] + " ");
		
	}
}

/*
 * 분류 : 구현, 그리디
 * 
 * key point : 입력이 키 순서대로 주어지므로 나중에 배치되는 사람의 경우 현재 배치되는 사람보다 무조건 키가 클 것이라는 조건이 있다.
 * => 그리디(매 순간 정답을 고를 수 있다)
 */



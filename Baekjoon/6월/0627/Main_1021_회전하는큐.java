package baekjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	static int[] arr;
	
	static void outputFirst() {
		int[] temp = new int[arr.length-1];
		
		for(int i = 0; i < temp.length; i++)
			temp[i] = arr[i+1];
		
		arr = temp;
	}
	
	static void moveLeft() {
		int[] temp = new int[arr.length];
		int first = arr[0];

		for(int i = 0; i < arr.length-1; i++)
			temp[i] = arr[i+1];
		
		temp[temp.length-1] = first;

		arr = temp;
	}
	
	static void moveRight() {
		int[] temp = new int[arr.length];
		int end = arr[arr.length-1];
		
		for(int i = 1; i < arr.length; i++)
			temp[i] = arr[i-1];
		
		temp[0] = end;
		
		arr = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N]; // 양방향 순환 큐
		for(int i = 0; i < N; i++)
			arr[i] = i+1;
		
		st = new StringTokenizer(br.readLine());
		int[] output = new int[M]; // 뽑아내려고 하는 원소의 위치
		
		for(int i = 0; i < M; i++)
			output[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i  < output.length; i++) {
			int idx = output[i];
			
			if(idx == arr[0]) { // arr의 첫번째 원소가 뽑으려는 원소인 경우
				outputFirst();
			}
			else {
				// 뽑으려는 원소의 위치
				int loc = 0;
				
				for(int j = 0; j < arr.length; j++) {
					if(arr[j] == idx)
						loc = j;
				}
				
				if(loc > arr.length/2) {
					while(idx != arr[0]) {
						num++;
						moveRight();
					}
					outputFirst();
				}
				else {
					while(idx != arr[0]) {
						num++;
						moveLeft();
					}
					outputFirst();	
				}
			}
		}
		
		System.out.println(num);
	}
}

/*
 * 분류 : 자료구조, 덱
 */


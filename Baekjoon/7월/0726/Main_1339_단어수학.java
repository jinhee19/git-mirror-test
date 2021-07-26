package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1339_�ܾ���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		HashMap<Character, int[]> map = new HashMap<>(); // ���ĺ�, {��ġ, ������ ����}
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			words[i] = word;
			for(int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				if(map.get(ch) == null) {
					map.put(ch, new int[] {word.length() - j, 1});
				}
				else {
					int[] temp = map.get(ch);
					int loc = temp[0];
					if(loc < word.length() - j)
						loc = word.length() -j;
					map.put(ch, new int[] {loc, temp[1]+1});
				}
			}
		}
		
		// ��ġ��, ���� ������ ����
		ArrayList<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, int[]>>() {

			@Override
			public int compare(Entry<Character, int[]> o1, Entry<Character, int[]> o2) {
				if(o1.getValue()[0] == o2.getValue()[0])
					return o2.getValue()[1] - o1.getValue()[1];
				return o2.getValue()[0] - o1.getValue()[0];
			}

		});
		
		
		int num = 9;
		for(int i = 0; i < list.size(); i++) {
			char ch = list.get(i).getKey();
			for(int j = 0; j < N; j++) {
				words[j] = words[j].replace(ch, (char)(num +'0'));
			}
			num--;
		}
		
		for(int i = 0; i < N; i++)
			answer += Integer.parseInt(words[i]);

		System.out.println(answer);
		
	}
}

/*
 * �з� : �׸��� �˰���, ���Ʈ���� �˰���
 * ���̵��
 *  1. �ڸ����� ū ��ġ�� ���ĺ����� �������
 *  2. �ڸ����� ���� ���ĺ��� ��� ������ �󵵰� Ŭ ����
 * 
 * ��� ���� 
 *  1. HashMap�� Value �������� List�� �̿��ؼ� �����ϴ� ���
 *  2. HashMap ��� Ȯ���ϴ� ��� -> entrySet(), keySet()
 *  3. int to char -> (char)(num + '0')
 */

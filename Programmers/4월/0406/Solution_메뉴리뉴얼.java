package programmers.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution_메뉴리뉴얼 {
	static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	static int[] course = {2,3,4};
	 
	static int num = 0;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	    
    static void combi(int cnt, int idx, String str, boolean[] check){
        if(cnt == num){
        	String temp = "";
        	for(int i = 0; i < str.length(); i++) {
        		if(check[i])
        			temp += str.charAt(i);
        	}
        	char[] arr = temp.toCharArray();
        	Arrays.sort(arr);
        	temp = String.copyValueOf(arr);
        	System.out.println("temp : " + temp);
        	if(map.get(temp) == null)
        		map.put(temp, 1);
        	else {
        		int count = map.get(temp) + 1;
        		map.put(temp, count);
        	}
        		
            return;
        }
        
        for(int i = idx; i < str.length(); i++){
        	check[i] = true;
            combi(cnt + 1, i+1, str, check);
            check[i] = false;
        }
    }
	    
	public static void main(String[] args) {
		ArrayList<String> answer = new ArrayList<>();
		
		for(int i = 0; i < course.length; i++){
            num = course[i];
            for(int j = 0; j < orders.length; j++){
                combi(0, 0, orders[j], new boolean[orders[j].length()]);
            }
            
            ArrayList<String> list = new ArrayList<>(map.keySet());
            
            list.sort((o1, o2)->map.get(o2) - map.get(o1));
            
            int number = 0;
            for(String str : list) {
            	if(number == 0) {
            		if(map.get(str) >= 2) {
            			number = map.get(str);
            			answer.add(str);
            		}
            		else
            			break;
            	}
            	else {
            		if(map.get(str) == number)
            			answer.add(str);
            		else
            			break;
            	}
            }
            map = new HashMap<>();
        }
        Collections.sort(answer);
        System.out.println(answer.toString());
	}
}

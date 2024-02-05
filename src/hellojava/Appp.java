package hellojava;

import java.util.HashMap;

public class Appp {

	public static void main(String[] args) {
	
	}
 public static HashMap <Character,Integer> findFrequency(String word) {
	 HashMap<Character,Integer> map=new HashMap<>();
	 char[] chars=word.toCharArray();	
	 for(char c:chars) {
		if(map.containsKey(c)) 
			map.put(c,map.get(c)+1);
		else
			map.put(c,1);
	 }
	 PriorityQueue<HuffmanNode>queue=newPriorityQueue
	 
	 
	return map;
	 
 }
 class HuffmanNode implement Comparable<HauffmanNode>{
	 Hauffman left,right;
	 
	 
	 public int compareTo(Huffman)
 }
}

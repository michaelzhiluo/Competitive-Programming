/*
ID: michael274
LANG: JAVA
TASK: fence
*/

import java.io.*;
import java.util.*;

class fence {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("fence.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		int n = s.nextInt();
		PriorityQueue<Integer>[] adj = new PriorityQueue[501];
		Stack<Integer> stk = new Stack<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i=1; i<adj.length; i++){
			adj[i]  = new PriorityQueue();
		}
		while(s.hasNext()){
			int from = s.nextInt();
			int to = s.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		int location = 1;
		for(int i=1; i<adj.length; i++){
			if(adj[i].size()%2==1){
				location = i; break;
			}
		}
		while(true){
			if(!adj[location].isEmpty()){
				stk.add(location);
				int temp = adj[location].poll();
				adj[temp].remove(new Integer(location));
				location = temp;
			}else{
				answer.add(location);
				if(stk.isEmpty()){
					break;
				}else{
					location = stk.pop();
				}
			}
		}
		for(int i= answer.size()-1; i>=0; i--){
			out.println(answer.get(i));
		}

		out.close();                                
	}
}

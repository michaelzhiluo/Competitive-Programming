/*
ID: michael274
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

class holstein {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		int min = 10000;
		int numvit = s.nextInt();
		int[] vitamins = new int[numvit];
		boolean satisfy = true;
		for(int i=0; i<vitamins.length; i++){
			vitamins[i] = s.nextInt();
		}
		int numfeed = s.nextInt();
		int[][] feed = new int[numfeed][numvit];
		int[] sum = new int[numvit];
		for(int i=0; i<feed.length; i++){
			for(int j=0; j<feed[0].length; j++){
				feed[i][j] = s.nextInt();
			}
		}
		ArrayList<Integer> winner= new ArrayList<Integer>();
		int minsize = numfeed;
		for(long i = 0; i < (1<<numfeed); i++){
		    ArrayList<Integer> subset = new ArrayList<Integer>();
		    for(int j = 0; j < numfeed; j++){
		        if(((i>>j) & 1) == 1){ 
		            subset.add(j);
		        }
		    }
		    for(int j: subset){
		    	for(int k=0; k<numvit; k++){
		    		sum[k] +=feed[j][k];
		    	}
		    }
		    for(int j=0; j<numvit; j++){
		    	if(sum[j] <vitamins[j]){
		    		satisfy = false;
		    	}
		    }
		    if(satisfy && subset.size()<=minsize && subset.size()>0){
		    	winner  = new ArrayList<Integer>();
		    	winner.addAll(subset);
		    	minsize = subset.size();
		    }
		    sum = new int[numvit];
		    satisfy = true;
		}
		
		out.print(winner.size()+ " ");
    	for(int j=0; j<winner.size(); j++){
    		if(j==winner.size()-1){
    			out.print(winner.get(j)+1);
    		}else{
    			out.print(winner.get(j)+1 + " ");
    		}
    	}
		out.println();
		out.close();                                  
	}

}

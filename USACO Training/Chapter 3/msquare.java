/*
ID: michael274
LANG: JAVA
TASK: msquare
*/

import java.io.*;
import java.util.*;

class msquare {
	static StringBuilder ss = new StringBuilder();
	static int[][] transformation = {{7, 6, 5, 4, 3, 2, 1, 0},
									{3, 0, 1, 2, 5, 6, 7, 4},
									{0, 6, 1, 3, 4, 2, 5, 7}};
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("msquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
		int[] result = {s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()};
		HashMap<int[], String> perm = new HashMap<int[], String>();
		int[] start = new int[]{1,2,3,4,5,6,7,8};
		perm.put(start, "");
		boolean[] seen = new boolean[40320];
		seen[0] = true;
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		while(!queue.isEmpty()){
			int[] temp = queue.pop();
			if(Arrays.equals(temp, result)){
				out.println(perm.get(temp).length());
				out.println(perm.get(temp));
				break;
			}
			int[][] transformations = trans(temp);
			for(int i=0; i<3; i++){
				int temp1 = index(transformations[i]);
				if(!seen[temp1]){
					seen[temp1] = true;
					perm.put(transformations[i], perm.get(temp) + (char)(65 + i));
					queue.add(transformations[i]);
				}
			}
		}
		out.close();                                  
	}
	public static int index(int[] state)
	{
			int idx;
			int[] c = new int[8];
			for(int i = 0; i < 8;i++){
				c[i] = state[i];
			}
			idx = 0;
			for(int i = 0; i < 7;i++){				
				idx = idx*(8-i)+(c[i]-1);
				for(int j = i+1;j<8;j++){
					if(c[j] > c[i]) c[j]--;
				}
			}
			return idx;
	}

	public static int[][] trans(int[] s){
		int[][] temp = new int[3][8];
		for(int i=0; i<3; i++){
			for(int j=0; j<8; j++){
				temp[i][j] = s[transformation[i][j]];
			}
		}
		return temp;
	}

}

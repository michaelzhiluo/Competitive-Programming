/*
ID: michael274
LANG: JAVA
TASK: spin
*/

import java.io.*;
import java.util.*;

class spin {
	static class wheel{
		int speed;
		int[][] wedges; 
		public wheel(int s, int n){
			speed = s;
			wedges = new int[n][2];
		}
	}
	static wheel[] w = new wheel[5];
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("spin.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
		for(int i=0; i<w.length; i++){
			w[i] = new wheel(s.nextInt(), s.nextInt());
			for(int j=0; j<w[i].wedges.length; j++){
				w[i].wedges[j][0] = s.nextInt();
				w[i].wedges[j][1] = (w[i].wedges[j][0] + s.nextInt())%360;
			}
		}
		boolean temp = false;
		for(int i=0; i<360; i++){
			gglol:
			for(int j=0; j<360; j++){
				gg:
				for(int k=0; k<5; k++){
					for(int l=0; l<w[k].wedges.length; l++){
						if(works(j, w[k].wedges[l])){
							continue gg;
						}
					}
					continue gglol;
				}
				out.println(i);
				out.close();
				System.exit(0);
			}
			
			//update
			for(int j=0; j<5; j++){
				for(int k=0; k<w[j].wedges.length; k++){
					w[j].wedges[k][0] = (w[j].wedges[k][0]+w[j].speed)%360;
					w[j].wedges[k][1] = (w[j].wedges[k][1]+w[j].speed)%360;
				}
			}
		}
		out.println("none");
		out.close();                                  
	}

	public static boolean works(int angle, int[] gg){
		if(gg[0] > gg[1]){
			return angle >= gg[0] || angle <= gg[1];
		}
		return angle <= gg[1] && angle >= gg[0];
	}

}

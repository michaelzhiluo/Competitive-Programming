import java.util.*;

public class Prim{
	public static void main(String[] args){
		int[][] weight = new int[9][9];
		int[] distance = new int[9];
		for(int i=0; i<distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		int[] source = new int[9];
		distance[1] = 0;
		int treesize = 0;
		int treecost = 0;
		boolean[] intree = new boolean[9];
		weight[1][2] = 30;
		weight[2][1] = 30;
		weight[1][3] = 20;
		weight[3][1] = 20;
		weight[1][6] = 25;
		weight[6][1] = 25;
		weight[2][3] = 9;
		weight[3][2] = 9;
		weight[2][4] = 21;
		weight[4][2] = 21;
		weight[2][5] = 9;
		weight[5][2] = 9;
		weight[5][4] = 8;
		weight[4][5] = 8;
		weight[4][8] = 15;
		weight[8][4] = 15;
		weight[5][8] = 12;
		weight[8][5] = 12;
		weight[8][6] = 11;
		weight[6][8] = 11;
		weight[6][7] = 10;
		weight[7][6] = 10;
		weight[3][7] = 7;
		weight[7][3] = 7;
		weight[2][7] = 45;
		weight[7][2] = 45;
		while(treesize < 8){
			int minindex =0;
			int mindistance = Integer.MAX_VALUE;
			for(int i=1; i<distance.length; i++){
				if(!intree[i] && distance[i] < mindistance){
					mindistance = distance[i];
					minindex = i;
				}
			}
			intree[minindex] = true;
			treecost +=mindistance;
			treesize++;
			for(int i=1; i<distance.length; i++){
				if(weight[minindex][i]!=0 && !intree[i] && weight[minindex][i] < distance[i]){
					distance[i] = weight[minindex][i];
					source[i] = minindex;
				}
			}
		}
		for(int i=1; i<distance.length; i++){
			System.out.println(i + ", " + distance[i] + ",  " + source[i]);
		}
		System.out.println(treecost);

 	}
}
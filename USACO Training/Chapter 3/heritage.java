/*
ID: michael274
LANG: JAVA
TASK: heritage
*/

import java.io.*;
import java.util.*;

class heritage {
	static char[] inorder, preorder;
	static StringBuilder postorder = new StringBuilder();
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("heritage.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("heritage.out")));
		String in = s.next();
		String pre = s.next();
		inorder = new char[in.length()];
		preorder = new char[pre.length()];
		for(int i=0; i<inorder.length; i++){
			inorder[i] = in.charAt(i);
			preorder[i] = pre.charAt(i);	
		}
		printpost(inorder, preorder, inorder.length);
		out.println(postorder.toString());
		out.close();                                
	}
	public static int index(char a[], char b, int c){
		for(int i=0; i<c; i++){
			if(a[i] == b){
				return i;
			}
		}
		return -1;
	}
	public static void printpost(char[] inorder, char[] preorder, int n){
		int root = index(inorder, preorder[0], n);

		if(root!=0){
			printpost(inorder, Arrays.copyOfRange(preorder, 1, preorder.length), root);
		}
		if(root != n-1){
			printpost( Arrays.copyOfRange(inorder, root+1, inorder.length),Arrays.copyOfRange(preorder, root+1, preorder.length),n-root-1);
		}
		postorder.append(preorder[0]);
	}
}

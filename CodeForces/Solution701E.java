import java.io.*;
import java.util.*;
public class Solution701E{
	public static void main(String [] args) throws FileNotFoundException{
		HashMap<String, Integer> temp1 = new HashMap<String, Integer>();
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=0; i<n; i++){
			String gg = s.next();
			if(temp1.containsKey(gg)){
				int temp = temp1.get(gg) + 1;
				temp1.put(gg, temp);
				System.out.println(gg + "" + temp);
			}else{
				temp1.put(gg, 0);
				System.out.println("OK");
			}	
		}
	}
}


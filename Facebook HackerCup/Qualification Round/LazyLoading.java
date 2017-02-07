import java.io.*;
import java.util.*;

class LazyLoading {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("lazy_loading.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		int n = s.nextInt();
		for(int i=1; i<=n; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int hi = s.nextInt();
			for(int j=0; j<hi; j++){
				temp.add(s.nextInt());
			}
			Collections.sort(temp);
			int counter =0;
			while(temp.size()!=0){
				int max = temp.get(temp.size()-1);
				temp.remove(temp.size()-1);
				if(max <50){
					int numremove =(int)(Math.ceil(50.0/max) -1);
					if(numremove > temp.size()){
						break;
					}
					for(int j=0; j<numremove; j++){
						temp.remove(0);
					}
				}
				counter++;
			}
			out.println("Case #" + i + ": " + counter);
		}
		out.close();                                
	}
}

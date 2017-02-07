import java.io.*;
import java.util.*;

class ProgressPie {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("progress_pie.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		//Scanner s = new Scanner(new FileReader("ProgressPie.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ProgressPie.out")));
		int n= s.nextInt();
		for(int i=1; i<=n; i++){
			double r = s.nextInt()/100.0;
			double p = 2*r*Math.PI;
			// transformation to origin
			int x = s.nextInt()-50;
			int y = s.nextInt()-50;
			if(Math.sqrt(x*x + y*y) > 50){
				out.println("Case #" + i + ": white");
				continue;
			}
			//hardcoding edge cases
			if(r<0.005){
				out.println("Case #" + i + ": white");
				continue;
			}
			else if(x ==0 &&  y >=0){
				out.println("Case #" + i + ": black");
				continue;
			}
			else if(x==0 && y<0 && p >=Math.PI){
				out.println("Case #" + i + ": black");
				continue;
			}else if(y==0 && x>0 && p >=Math.PI/2){
				out.println("Case #" + i + ": black");
				continue;
			}else if(y==0 && x<0 && p>=3*Math.PI/2){
				out.println("Case #" + i + ": black");
				continue;
			}

			// four quadrants case work
			double angle =0;
			if(x>0 && y>0){
				angle = Math.atan((double)(x)/y);
			}else if(x>0 && y<0){
				angle = Math.atan((double)(Math.abs(y))/x) + Math.PI/2;
			}else if(x<0 && y<0){
				angle = Math.atan((double)(x)/y) + Math.PI;
			}else{
				angle = Math.atan((double)(y)/Math.abs(x)) + Math.PI*1.5;
			}
			// Accounting for 10^-6 error
			System.out.println(angle + " " + p);
			if(angle<=p + 0.000001){
					out.println("Case #" + i + ": black");
			}else{
					out.println("Case #" + i + ": white");
			}
		}
		out.close();                                
	}
}

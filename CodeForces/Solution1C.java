import java.io.*;
import java.util.*;

public class Solution1C{
	public static void main(String [] args) throws FileNotFoundException{
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		double[][] points = new double[3][2];
		for(int i=0; i<3; i++){
			points[i][0] = Double.parseDouble(s.next());
			points[i][1] = Double.parseDouble(s.next());
		}
		double area = 0.5*(Math.abs(points[0][0]*(points[1][1]-points[2][1]) + points[1][0]*(points[2][1]-points[0][1]) + points[2][0]*(points[0][1]-points[1][1]) ));
		double d1 = Math.sqrt((points[1][0]-points[0][0])*(points[1][0]-points[0][0]) + (points[1][1]-points[0][1])*(points[1][1]-points[0][1]));
		double d2 = Math.sqrt((points[2][0]-points[0][0])*(points[2][0]-points[0][0]) + (points[2][1]-points[0][1])*(points[2][1]-points[0][1]));
		double d3 = Math.sqrt((points[2][0]-points[1][0])*(points[2][0]-points[1][0]) + (points[2][1]-points[1][1])*(points[2][1]-points[1][1]));
		double circumradius = d1*d2*d3/(4*area);
		double angle1, angle2;
		if(d1/(2*circumradius)>1 || d1/(2*circumradius)<-1){
			angle1 = 2*Math.asin(1);
		}else{
			angle1 = 2*Math.asin(d1/(2*circumradius));
		}
		if(d2/(2*circumradius)>1 || d2/(2*circumradius)<-1){
			angle2 = 2*Math.asin(1);
		}else{
			angle2 = 2*Math.asin(d2/(2*circumradius));
		}
		double theta = gcd(gcd(angle1, angle2, Math.PI / 1000), 2 * Math.PI - angle1 - angle2, Math.PI / 1000);
		System.out.println((Math.PI/theta)*circumradius*circumradius*Math.sin(theta));
	}
	
	private static double gcd (double a, double b, double error) {
        double x = Math.max(a, b);
        double y = Math.min(a, b);
        while (y >= error) {
            do { x -= y; } while (y - error <= x);
            double t = x; x = y; y = t;
        }
        return x;
    }
}
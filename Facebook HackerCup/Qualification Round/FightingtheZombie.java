import java.io.*;
import java.util.*;

class FightingtheZombie {
	static double[][] four = new double[21][81];
	static double[][] six = new double[21][121];
	static double[][] eight = new double[21][161];
	static double[][] ten = new double[21][201];
	static double[][] twelve = new double[21][241];
	static double[][] twenty = new double[21][401];
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("fighting_the_zombie.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		//Generate the probability arrays
		HashMap<Integer, double[][]> storage = new HashMap<Integer, double[][]>();
		storage.put(4, four);
		storage.put(6, six);
		storage.put(8, eight);
		storage.put(10, ten);
		storage.put(12, twelve);
		storage.put(20, twenty);
		for(int i: storage.keySet()){
			generateprobabilities(storage.get(i), i);
		}
		int n = s.nextInt();
		foo:
		for(int i=1; i<=n; i++){
			int damage = s.nextInt();
			int numdice = s.nextInt();
			double maxprobability = 0.0;
			for(int j=0; j<numdice; j++){
				String ss = s.next();
				int d = 0;
				int w=-1;
				boolean add = false;
				for(int k=0; k<ss.length(); k++){
					if(ss.charAt(k)=='d'){
						d= k;
					}
					else if(ss.charAt(k)== '+'){
						w = k;
						add = true;
					}
					else if(ss.charAt(k) == '-'){
						w = k;
					}
				}
				int numtimes =0;
				int numsides = 0;
				int truedamage = 0;
				numtimes = Integer.parseInt(ss.substring(0, d));
				if(w==-1){
					numsides = Integer.parseInt(ss.substring(d+1));
				}else{
					numsides = Integer.parseInt(ss.substring(d+1, w));
					if(add){
						truedamage += Integer.parseInt(ss.substring(w+1));
					}else{
						truedamage -= Integer.parseInt(ss.substring(w+1));
					}
				}
				// Damage range: numtimes*1 + truedamage -> numtimes*numsides + truedamage
				// Damage
				double[][] gg = storage.get(numsides);
				double sum =0;
				if(damage <= numtimes + truedamage){
					sum = 1.0;
				}else if(damage > numtimes*numsides + truedamage){
					continue;
				}else{
					for(int k=damage - truedamage; k<=numtimes*numsides; k++){
						sum+=gg[numtimes][k];
					}
				}
				System.out.println((numtimes + truedamage) + " " + (numtimes*numsides + truedamage) + " " + damage + " "+ sum);
				if(sum > maxprobability){
					maxprobability = sum;
				}
			}
			out.print("Case #" + i + ": ");
			out.printf("%1.6f", maxprobability);
			out.println();
		}
		out.close();                                
	}

	public static void generateprobabilities(double[][] a, int b){
		for(int i=1; i<=b; i++){
			a[1][i] = 1.0/b;
		}
		for(int i=1; i<=19; i++){
			int temp = i*b;
			for(int j=i; j<=temp; j++){
				for(int k=1; k<=b; k++){
					a[i+1][j+k] += a[i][j]*a[1][k]; 
				}
			}
		}
	}
}
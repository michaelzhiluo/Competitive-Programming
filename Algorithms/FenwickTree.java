import java.util.*;

class FenwickTree {

	public static void main (String [] args){
		int[] test = {1,2,3,4,5,6,7,8};
	}

	public static int[] makeBIT(int[] original){
		for(int i=1; i<=original.length ; i<<1){
			int sum =0;
			for(int j=0; j<=i-1; j++){
				sum+=original[j];
			}
			original[i-1] = sum;
		}

		
	}
}

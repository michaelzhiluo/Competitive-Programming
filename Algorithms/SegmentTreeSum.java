import java.util.*;

// Added Lazy Propagation
class SegmentTreeSum {
	static int[] st;
	static int[] original;
	public SegmentTreeSum(int[] input){
		original = input;
		st = new int[2*(int)Math.pow(2,(int)Math.ceil(Math.log(input.length)/Math.log(2)))-1];
		createSegmentTree(input, 0, 0, input.length-1);
	}

	// input[start] to input[end]
	public static int createSegmentTree(int[] input, int segindex, int start, int end){
		if(start == end){
			st[segindex] = input[start];
		}else{
			int middle = (start + end)/2;
			st[segindex] = createSegmentTree(input, 2*segindex + 1 ,start, middle) + createSegmentTree(input, 2*segindex + 2, middle+1, end);
		}
		return st[segindex];
	}

	public static void updateValue(int origindex, int newvalue){
		UpdateMethod(0, 0, original.length-1, origindex, newvalue - original[origindex]);
	}

	public static void UpdateMethod(int index, int ststart, int stend, int origindex, int difference){
		if(origindex >=ststart && origindex <=stend){
			st[index]+=difference;
			if(ststart!= stend){
				int mid = (ststart + stend)/2;
				UpdateMethod(2*index+1, ststart, mid, origindex, difference);
				UpdateMethod(2*index+2, mid+1, stend, origindex, difference);
			}
		}

	}

	//start, end inclusive
	public static int getSum(int start, int end){
		return SumMethod(0, 0, original.length-1, start, end);
	}

	public static int SumMethod(int index, int ststart, int stend, int start, int end){
		if(ststart >=start && stend <=end){
			return st[index];
		}
		else if(start > stend || ststart > end){
			return 0;
		}
		int mid = (ststart + stend)/2;
		return SumMethod(2*index+1, ststart, mid, start, end) + SumMethod(2*index + 2, mid+1, stend, start, end);
	}

	public static void main(String[] args){
		int[] test = {1,3,5,7,9,11};
		SegmentTreeSum rip = new SegmentTreeSum(test);
		System.out.println(getSum(0, 5));
		rip.updateValue(3, 9);
		System.out.println(getSum(0,5));

	}
}

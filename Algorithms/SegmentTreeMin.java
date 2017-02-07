import java.util.*;

class SegmentTreeMin {
	static int[] st;
	static int[] original;
	public SegmentTreeMin(int[] input){
		original = input;
		st = new int[2*(int)Math.pow(2,(int)Math.ceil(Math.log(input.length)/Math.log(2)))-1];
		createSegmentTree(input, 0, 0, input.length-1);
	}

	public static int getMin(int left, int right){
		return MinMethod(0, 0, original.length-1, left, right);
	}

	public static int MinMethod(int stindex, int stleft, int stright, int left, int right){
		if(stleft >=left && stright <=right){
			return st[stindex];
		}else if(stright < left || stleft > right){
			return Integer.MAX_VALUE;
		}
		int mid = (stleft + stright)/2;
		return Math.min(MinMethod(2*stindex+1, stleft, mid, left, right), MinMethod(2*stindex+2, mid+1, stright, left, right));
	}

	// input[start] to input[end]
	public static int createSegmentTree(int[] input, int segindex, int start, int end){
		if(start == end){
			st[segindex] = input[start];
		}else{
			int mid = (start + end)/2;
			st[segindex] = Math.min(createSegmentTree(input, 2*segindex+1, start, mid), createSegmentTree(input, 2*segindex+2, mid+1, end));
		}
		return st[segindex];
	}

	public static void main(String[] args){
		int[] test = {1,3,5,-1,9001,11};
		SegmentTreeMin rip = new SegmentTreeMin(test);
		System.out.println(rip.getMin(0,3));
	}
}

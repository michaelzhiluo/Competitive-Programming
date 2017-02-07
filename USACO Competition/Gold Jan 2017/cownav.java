import java.io.*;
import java.util.*;

class cownav {
	static int[] directions = {1,3};
	static state[][][][][] coord;
	static boolean[][][][][] visited;
	static PriorityQueue<state> queue;
	static class state implements Comparable<state>{
		int x1, y1, x2, y2, dir;
		int moves = 1000;
		public state(int a, int b, int c, int d, int direction){
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
			dir = direction;
		}

		public int compareTo(state s){
			return this.moves - s.moves;
		}
	}
	public static void main (String [] args) throws IOException {
		//Scanner ss = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner ss = new Scanner(new FileReader("cownav.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));
		int n = ss.nextInt();
		boolean[][] obstacle = new boolean[n][n];
		for(int i=n-1; i>=0; i--){
			String str = ss.next();
			for(int j=0; j<n; j++){
				if(str.charAt(j)=='H'){
					obstacle[i][j] = true;
				}
			}
		}
		coord = new state[n][n][n][n][4];
		visited = new boolean[n][n][n][n][4];
		coord[0][0][0][0][0] = new state(0, 0, 0,0, 0);
		coord[0][0][0][0][0].moves =0;
		n--;
		int[] contents = new int[5];
		queue = new PriorityQueue<state>();
		queue.add(coord[0][0][0][0][0]);
		while(!queue.isEmpty()){
			state s = queue.poll();
			visited[s.x1][s.y1][s.x2][s.y2][s.dir] = true;
			if(s.x1 ==n && s.y1 == n && s.x2 ==n && s.y2 ==n){
				out.println(s.moves);
				break;
			}

			contents[0] = s.x1;
			contents[1] = s.y1;
			contents[2] = s.x2;
			contents[3] = s.y2;
			contents[4] = s.dir;
			// Going forward
			switch(s.dir){
				case 0: contents[0] = (s.x1 < n) ? s.x1 + 1 : n;
				contents[3] = (s.y2 <n) ? s.y2 + 1: n;
				break;
				case 1: contents[1] = (s.y1 >= 1) ? s.y1 -1 : 0;
				contents[2] = (s.x2 < n) ? s.x2 + 1 : n;
				break;
				case 2: contents[0] = (s.x1 >=1) ? s.x1 -1 : 0;
				contents[3] = (s.y2 >= 1) ? s.y2 -1 : 0;
				break;
				case 3: contents[1] = (s.y1 <n) ? s.y1 + 1: n;
				contents[2] = (s.x2 >=1) ? s.x2 -1 : 0;
				break;
			}

			if(obstacle[contents[0]][contents[1]] || (s.x1 == n && s.y1 ==n)){
				contents[0] = s.x1;
				contents[1] = s.y1;
			}
			if(obstacle[contents[2]][contents[3]] || (s.x2 ==n && s.y2 ==n)){
				contents[2] = s.x2;
				contents[3] = s.y2;
			}
			// Forward
			update(contents[0], contents[1], contents[2], contents[3], contents[4], s.moves+1);

			// Right and Left
			for(int i: directions){
				int temp = (s.dir+i)%4;
				update(s.x1, s.y1, s.x2, s.y2, temp, s.moves+1);
			}
		}
		out.close();                                
	}

	public static void update(int x1, int y1, int x2, int y2, int dir, int moves){
		if(coord[x1][y1][x2][y2][dir]== null){
					coord[x1][y1][x2][y2][dir] = new state(x1, y1, x2, y2, dir);
					coord[x1][y1][x2][y2][dir].moves =moves;
					queue.add(coord[x1][y1][x2][y2][dir]);
		} 
		else if(!visited[x1][y1][x2][y2][dir] && moves< coord[x1][y1][x2][y2][dir].moves){
					coord[x1][y1][x2][y2][dir].moves = moves;
					queue.remove(coord[x1][y1][x2][y2][dir]);
					queue.add(coord[x1][y1][x2][y2][dir]);
		}

	}
}

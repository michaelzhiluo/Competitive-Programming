/*
ID: michael274
LANG: JAVA
TASK: contact
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class contact{

	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("contact.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		HashMap<String, Integer> hi = new HashMap<String, Integer>();

		int a = s.nextInt();
		int b = s.nextInt();
		int n = s.nextInt();
		StringBuilder lol = new StringBuilder();
		while(s.hasNext()){
			lol.append(s.nextLine().trim());
		}

		String code = lol.toString();
		if(b > code.length()){
			b = code.length();
		}
		for(int i=a; i <= b; i++){
			for(int j=0; j<= code.length() -i; j++){
				String temp = code.substring(j, j+i);
				if(hi.containsKey(temp)){
					hi.put(temp, hi.get(temp)+1);
				}else{
					hi.put(temp, 1);
				}
			}
		}

        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(hi.entrySet());
		Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                if( (o2.getValue()).compareTo( o1.getValue()) ==0){
                	if(o2.getKey().length() > o1.getKey().length()){
                		return -1;
                	}else if(o2.getKey().length() < o1.getKey().length()){
                		return 1;
                	}
                	else{
                		if( Integer.parseInt(o2.getKey(), 2) > Integer.parseInt(o1.getKey(), 2)){
							return -1;
						}
						return 1;
                	}
                }
                return (o2.getValue()).compareTo( o1.getValue());
                
            }
        });

        int i=0; 
        int prev = 1000000000;
        ArrayList<Object[]> temp = new ArrayList<Object[]>();
        String hola = "lolol";
		for(Map.Entry<String, Integer> entry:list){
			if(entry.getValue() != prev){
				temp.add(new Object[]{prev, hola.substring(0, hola.length()-1)});
				prev = entry.getValue();
				hola = entry.getKey() + " ";
				i=0;
			}else{
				if(i%6==4){
					hola+=entry.getKey() + "\n";	
				}else{
					hola+=entry.getKey() + " ";
				}
				i++;
			}
        }
        temp.add(new Object[]{prev, hola.substring(0, hola.length()-1)});
        temp.remove(0);

        if(temp.size() < n){
        	n = temp.size();
        }
        for(int j=0; j<n; j++){
        	out.println(temp.get(j)[0]);
        	out.println(temp.get(j)[1]);
        	
        }
		out.close();                                  
	}
	

}

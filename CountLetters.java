package project;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.HashMap;
public class CountLetters {
	   public static String count(File file) throws IOException, FileNotFound{
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
	        try {
	        while (true){
	            String line= reader.readLine();
	            if(line==null){
	                break;
	            }
	            //Iterates through each line of the document until the line is null.
	            for(int i=0;i<line.length();i++){
	                char c=line.charAt(i);
	                if (c!= ' ' ){
	                    int value= letterCount.getOrDefault(c, 0);
	                    letterCount.put(c, value+1);
	                }
	            }

	        }
	        reader.close();
	        Set<Entry<Character, Integer>> set = letterCount.entrySet();
	        List<Entry<Character, Integer>> list = new ArrayList<>(set);
	        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
	            @Override
	            public int compare(Entry<Character, Integer> a,
	                    Entry<Character, Integer> b) {
	                return b.getValue() - a.getValue();
	            }
	        });
	        System.out.println("Top 10 most commonly used letters: times");
	        for (int i = 0; i < 10 && i < list.size(); i++) {
	            System.out.println("letter: "+ list.get(i)+ " times");
	        }

	        
	        return null;
	        
	    }
	    catch(IOException e) {
	    	throw new FileNotFound("File not found"+ file);
	    }
 }

}
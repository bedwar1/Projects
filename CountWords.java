package project;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
public class CountWords {
	public static String countWords (File file, File stopList) throws IOException, FileNotFound{
		
		Scanner s= new Scanner(file);
        Scanner s2= new Scanner(stopList);
        HashMap<String, Integer> wordCount= new HashMap<String, Integer>();
        HashMap<String,Integer> wordCount2= new HashMap<String,Integer>();
        
        ArrayList<String> fileLines = new ArrayList<String>();
       while (s.hasNextLine()) {
	  String temp =s.nextLine(); 
	  temp.trim();
	  if (!temp.isEmpty()) {
	  
	      fileLines.add(temp);
	  
	       } 
	  }
          for(String line: fileLines){
             Scanner scan= new Scanner(line);
             while(scan.hasNext()){
              scan.useDelimiter("[^a-zA-Z']");
              String word = scan.next();
              word=word.toLowerCase();
              //replace all leading apostrophes
              word = word.replaceAll("^'+", "");
              //replace all trailing apostrophes
              word = word.replaceAll("'+$", "");
              /* now you have a word to put in your map*/
              //Note: Make sure to check for empty String
              //don't put an empty string in the map
              if(!word.isEmpty()){
                  int value= wordCount.getOrDefault(word, 0);
                  wordCount.put(word, value+ 1);
              }

             }
          }
   

         
          s.close();
          
          Set<Entry<String, Integer>> set = wordCount.entrySet();
          List<Entry<String, Integer>> li = new ArrayList<>(set);
          Collections.sort(li, new Comparator<Entry<String, Integer>>() {
              @Override
              public int compare(Entry<String, Integer> a,
                      Entry<String, Integer> b) {
                  return b.getValue() - a.getValue();
              }
          });


          System.out.println("Top 10 most used words: ");
          for (int i = 0; i < 10 && i < li.size(); i++) {
              System.out.println("word: "+ li.get(i)+ " times");
          }
          //Create arraylist of stoplist words to be removed
          List<String> stopLines= new ArrayList<String>();
          while(s2.hasNextLine()) {
          	String temp= s2.nextLine();
          	temp.trim();
          	if(!temp.isEmpty()) {
          		stopLines.add(temp);
          	}
          }
          s2.close();
          //Create duplicate hashmap to work with for stop list just incase something breaks
          for(String line: fileLines){
              Scanner scan= new Scanner(line);
              while(scan.hasNext()){
               scan.useDelimiter("[^a-zA-Z']");
               String word = scan.next();
               word=word.toLowerCase();
               word = word.replaceAll("^'+", "");
               word = word.replaceAll("'+$", "");
               if(!word.isEmpty()){
                   int value= wordCount2.getOrDefault(word, 0);
                   wordCount2.put(word, value+ 1);
               }

              }
            
              
          }   
          //Go through duplicate list and remove words that match anything in stop list array
          for(String line: stopLines){
              Scanner scan= new Scanner(line);
              while(scan.hasNext()){
               scan.useDelimiter("[^a-zA-Z']");
               String word = scan.next();
               word=word.toLowerCase();
               word = word.replaceAll("^'+", "");
               word = word.replaceAll("'+$", "");
               if(wordCount2.containsKey(word)) {
              	 wordCount2.remove(word);
               }
              }
          }

          Set<Entry<String, Integer>> stopSet = wordCount2.entrySet();
          List<Entry<String, Integer>> stopLis= new ArrayList<>(stopSet);
          Collections.sort(stopLis, new Comparator<Entry<String, Integer>>() {
              @Override
              public int compare(Entry<String, Integer> a,
                      Entry<String, Integer> b) {
                  return b.getValue() - a.getValue();
              }
          });
     
          System.out.println("Top 10 most used words with stop list: ");
          for (int i = 0; i < 10 && i < stopLis.size(); i++) {
              System.out.println("word: " +stopLis.get(i)+ " times");
          }
		
		return null;
		
	}
}

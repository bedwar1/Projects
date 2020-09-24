//Author: Brandon Edwards
//Code works fine when text files are placed in project folder in Eclipse
package project;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Project1{
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, FileNotFound {
        File alice= new File("alice-in-wonderland.txt");
        File stopList= new File("stop-list.txt");
        
        //Handles letter count for book
        try {
			CountLetters.count(alice);}
			catch (IOException e) {
				throw new FileNotFound("File not found: "+ alice);
			}
        //Handles word count for book
        try {
        	CountWords.countWords(alice, stopList);}
        	catch(IOException e) {
        		throw new FileNotFound("File not found: " +alice);
        	}
        
    	
       
    }      
       
}  

//Finally done 



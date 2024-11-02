package javaUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class JavaLogicalMethods {
	
	//*********************reverseString**************************
    public String reverseString(String s) {
    	//String revinput = new StringBuilder(s).reverse().toString();
    	String revinput="";
    		for (int i = 0; i < s.length();i++) 
    			revinput = s.charAt(i) + revinput;
        return revinput;
    }
	//*********************getOccurrenceSingleChar**************************
	/*
	 * public void getOccurrenceSingleChar(String str, char ch) { int count=0; for
	 * (int i=0; i<str.length(); i++) if(str.charAt(i)==ch) count++;
	 * System.out.printf("Occurrence of SingleChar %s is %s\n", ch, count ); }
	 */

   public void getOccurrenceSingleChar(String str, char ch) {
   	ArrayList<Character> arr = new ArrayList<Character>();
   	for(int j=0; j < str.length(); j++)
   	arr.add(str.charAt(j));
   	
   	HashMap<Character, Integer> hash = new HashMap<Character, Integer> ();
   	
   	for(int i=0; i < str.length(); i++)
   	hash.put(arr.get(i), Collections.frequency(arr, arr.get(i)));
   	
   	for(Map.Entry<Character, Integer> e : hash.entrySet())
   		if(e.getKey()==ch) {
   			System.out.printf("Occurrence of SingleChar %s is %s\n", ch, e.getValue() );
   		}
   }
	//*********************getOccurringChar************************** 
    public void getOccurringChar(String str) {
    	
    	ArrayList<Character> arr = new ArrayList<Character>();
    	for(int j=0; j < str.length(); j++)
    	arr.add(str.charAt(j));
    	
    	HashMap<Character, Integer> hash = new HashMap<Character, Integer> ();
    	
    	for(int i=0; i < arr.size(); i++)
    	hash.put(arr.get(i), Collections.frequency(arr, arr.get(i)));
    	
    	for(Map.Entry<Character, Integer> e : hash.entrySet())
    		System.out.println("Character is :" + e.getKey() + " and its count is string is " + e.getValue());
    }
  //*********************LeftShiftString************************** 
    public void LeftShiftString (String s, int k){
    	if (k>s.length())k = k % s.length();
    	//String result=  s.substring(k)+s.substring(0,k);
    	String result=  "";
    for (int i =0; i<k;i++){
    	result = s.substring(1,s.length()) + s.charAt(0);
        s=result;
    }
        System.out.printf("Leftshifted String is: " +s );
    }
  //*********************getThirdLargest************************** 
    public int[] arraysSorting (int a[]){
    	int temp;
    	for (int i=0; i < a.length; i++) {
    		for (int k=i+1; k< a.length; k++) {
    			if(a[i] > a[k]) {
    				temp=a[i]; a[i]=a[k]; a[k]=temp;	
    			}
    		}
    	}
    	return a;
    }
    //****************removeDuplicateWords*******************************
    public String removeDuplicateWords (String input){
    	String words[] = input.split(" ");
    	String result=words[0];
    	for(String word: words) {
    		if(!result.contains(word))
    			result += " " + word;
    	}
    	return result;
    }
    //****************removeDuplicateWords*******************************
    
    public String reverseWordsofString (String input){
    	String arr[]=input.split(" ");
    	String newstr=""; 
    	for (int i=0; i < arr.length ; i++) {
			  char ch;
			  String tempstr="";
			  for(int j=0; j < arr[i].length() ; j++) {
				  ch=arr[i].charAt(j);
				  tempstr=ch+tempstr;
			  }
			  newstr = newstr  + tempstr + " ";
    	}
    	return newstr;
    }
  //****************reverseNumber*******************************
	public int reverseNumber(int Number) {
		int reverseNo=0;
		while(Number>0) {
			reverseNo=reverseNo*10+(Number%10);
			Number = Number/10;
		}
		return reverseNo;
	}
	 //****************removeDuplicateChar*******************************
	public String removeDuplicateChar(String input) {
		String result="";
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		for(int i=0; i < input.length(); i++)
			set.add(input.charAt(i));
		
	     for(char ch : set)   
	    	 result += ch;  
	     
		return result;
	}
}
package javaLearning;

import java.io.IOException;
import java.util.Arrays;

import javaUtilities.JavaLogicalMethods;

public class JavaLogical {

	public static void main (String[] args) throws IOException {
		String input = "Java is great and Java is fun and Java is powerful";
		System.out.println("Original String: " + input);
		int a[]= {16,8,33,95,12,4,90,22,36};
		//int b[]= {554,6767,878,232,656,8768,34};
		JavaLogicalMethods myobj = new JavaLogicalMethods();
		
		//System.out.println("Reversel String is: " +myobj.reverseString(input));
		//System.out.println("Reverse Number is: " +myobj.reverseNumber(1234567890));
		//myobj.getOccurrenceSingleChar(input, 'J');
		//myobj.getOccurringChar(input);
		//myobj.LeftShiftString(input, 1);
		System.out.println("Array after sorting: " +Arrays.toString(myobj.arraysSorting(a)));
		System.out.println("Third Largest of array is: " +myobj.arraysSorting(a)[a.length-3]);
		//System.out.println("String after removing duplicates: " +myobj.removeDuplicateWords(input));
		//System.out.println("String after reverse Words: " +myobj.reverseWordsofString(input));
		System.out.println("After removing Duplicate Char Name is: " +myobj.removeDuplicateChar("VVVVVVIIIIIIIMMMMLLLLLLEEESSSSHHHHHH"));
		}
}
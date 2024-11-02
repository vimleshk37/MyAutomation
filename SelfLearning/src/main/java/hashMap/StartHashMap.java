package hashMap;

import java.util.HashMap;
import java.util.Map;

public class StartHashMap {
	 public static void main(String args[]) {
	        
	        // Create a hm of Integer keys and String values
	        HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
	        
	        hm1.put(1, "vishal");
	        hm1.put(2, "sachin");
	        hm1.put(3, "vaibhav");
	        HashMap<Integer, String> hm2 = new HashMap<Integer, String>();
	        hm2.put(4, "Amit");
	        hm2.put(5, "Raju");
	        hm2.put(6, "Ritu");
	        hm2.put(7, "DeviLal");
	        
	        HashMap<Integer, String> hm = new HashMap<Integer, String>();
	        hm.putAll(hm1);
	        hm.putAll(hm2);
	        
	        System.out.println("Frist HashSet : "+hm1);
	        System.out.println("Frist HashSet : "+hm);
     

	       for (Map.Entry<Integer, String> k : hm.entrySet())
	       System.out.println(k.getKey() + "=" + k.getValue());
	    }
}
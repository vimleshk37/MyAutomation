package hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapStudent {    
		public static void main(String[] args) {   
		    //Creating HashMapStudent    
			Student b1=new Student();
			b1.StudentDetails(104, "Aaradhya Vimlesh", 5, "OLF", "Gurgaon");
			
			Student b2=new Student();
			b2.StudentDetails(102,"Kavya Singh",6,"Manav Rachna","Faridabad"); 
			
			Student b3=new Student();
			b3.StudentDetails(103,"Ritu Gurpta",7,"DAV School","Noida"); 
			
		    //Creating map of HashMapStudent    
			HashMap<Integer,Student> map=new HashMap<Integer,Student>();       
		    //Adding HashMapStudent to map   
		    map.put(1,b1);  
		    map.put(2,b2);  
		    map.put(3,b3);  
		    System.out.println(map);
		    //Traversing map  
		    for(Map.Entry<Integer, Student> entry:map.entrySet()){    
		        int key=entry.getKey();  
		        Student c=entry.getValue();  
		       System.out.println(key+" Student Details:");  
		       System.out.println(c.EnNo+" "+c.name+" "+c.standard+" "+c.school+" "+c.city);
		    }    
		}    
	} 
		class Student {
			int EnNo;    
			String name,school,city;    
			int standard;    
			public void StudentDetails(int EnNo, String name, int standard, String school, String city ) {    
			    this.EnNo = EnNo;    
			    this.name = name;
			    this.standard = standard;
			    this.school = school;    
			    this.city = city;        
			}
			void display() {System.out.println(EnNo+" "+name+" "+standard+" "+school+" "+city);}
	}
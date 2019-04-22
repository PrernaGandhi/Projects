package internalWorking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InternalWorkingOfHashSet {
	
	private transient static HashMap<String,Object> map;

    // A Dummy value(PRESENT) to associate with an Object in the Map
    private static final Object PRESENT = new Object();
    
    // default constructor of HashSet class
    // It creates a HashMap by calling 
    // default constructor of HashMap class
    public InternalWorkingOfHashSet() {
        map = new HashMap<>();
    }

    // add method 
    // it calls put() method on map object
    // and then compares it's return value with null
    public boolean add(String e) {
    	System.out.println(e + " " + PRESENT);
        return map.put(e, PRESENT)==null;
    }
 

	public static void main(String[] args) {
		InternalWorkingOfHashSet hs = new InternalWorkingOfHashSet(); 
         
	        // adding elements to hashset 
	        // using add() method 
	        boolean b1 = hs.add("Geeks"); 
	        boolean b2 = hs.add("GeeksforGeeks"); 
	          
	        // adding duplicate element 
	        boolean b3 = hs.add("Geeks"); 
	          
	        // printing b1, b2, b3 
	        System.out.println("b1 = "+b1); 
	        System.out.println("b2 = "+b2); 
	        System.out.println("b3 = "+b3); 
	        for(Map.Entry<String,Object> entry : map.entrySet())
	        System.out.println("Key :: " + entry.getKey() + " value :: " + entry.getValue().toString());
	 
	}

}

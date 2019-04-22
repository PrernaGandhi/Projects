package internalWorking;

import java.util.HashMap;

public class InternalWorkingOfHashMap {
	String key;
	public InternalWorkingOfHashMap(String key) {
		this.key = key;
	}
	
	public int hashCode() {
		int hash = (int)key.charAt(0); 
	    System.out.println("hashCode for key: "
	    		+ key + " = " + hash); 
	    return hash; 
	}
	
	public boolean equals(Object obj) { 
		System.out.println("equals() :: key :: " + ((InternalWorkingOfHashMap)obj).key);
        return key.equals(((InternalWorkingOfHashMap)obj).key); 
    } 
	
	public static void main(String[] args) {
		HashMap<InternalWorkingOfHashMap, Integer> map = new HashMap<InternalWorkingOfHashMap, Integer>(); 
        map.put(new InternalWorkingOfHashMap("vishal"), 20); 
        map.put(new InternalWorkingOfHashMap("pulkit"), 30); 
        map.put(new InternalWorkingOfHashMap("vaibhav"), 40); 
  
        System.out.println(); 
        System.out.println("Value for key pulkit: " + map.get(new InternalWorkingOfHashMap("pulkit"))); 
        System.out.println("Value for key vaibhav: " + map.get(new InternalWorkingOfHashMap("vaibhav"))); 
   
	}

}

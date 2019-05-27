package subsetOfString;

import java.util.HashSet;
import java.util.Set;
//TODO
public class CountNumberOfSubsetsForDuplicates {

	public static void main(String[] args) {
		String s = "abcdabc";
		Set<String> set = new HashSet<String>();
		for(int i=0;i<Math.pow(2,s.length());i++){
			String subset="";
			for(int j=0;j<s.length();j++){
				if((i&(1<<j))!=0){
					subset+=s.charAt(j)+"|";
				}
			}
			set.add(subset);
		}
		int c=0;
		for(String sk:set){
			//System.out.println("-----------"+sk);
			String arr[]=sk.split("\\|");
			for(String k:arr){
				System.out.print(k+" ");
			}
			c=c+1;
			System.out.println();
		}
		System.out.println(c);
	}

}

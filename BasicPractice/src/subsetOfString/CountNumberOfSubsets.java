package subsetOfString;

public class CountNumberOfSubsets {

	public static void main(String[] args) {
		String s = "abcd";int sum=0;
		for(int i=1;i<=s.length();i++){
			sum=sum+i;
		}
		System.out.println(sum);
	}

}

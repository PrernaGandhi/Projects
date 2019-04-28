package searchPractice;

public class BinarySearch {

	static int search(int arr[],int s,int indexS,int indexE){
		if(indexE >= indexS){
			int mid = ((indexE + indexS)/2);
			if(arr[mid] == s){
				return s;
			}else if(arr[mid] < s){
				return search(arr, s, mid+1, indexE);
			}else if(arr[mid] >s){
				return search(arr,s,indexS,mid);
			} 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int s = 5;
		int val = search(arr,s,0,arr.length-1);
		System.out.println(val);
	}

}

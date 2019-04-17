package arraysPractice;
/*
 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
 *	1) Store d elements in a temp array
 *  temp[] = [1, 2]
 *	2) Shift rest of the arr[]
 *  arr[] = [3, 4, 5, 6, 7, 6, 7]
 *	3) Store back the d elements
 *  arr[] = [3, 4, 5, 6, 7, 1, 2]
 *  Time complexity : O(n)
 *	Auxiliary Space : O(d)
 * @author prerna.gandhi
 * 
 */
public class ArrayRotationUsingTempArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		//rotation by 2
		int d = 2;
		int tempArr[] = new int[d];
		for(int i=0;i<d;i++) {
			tempArr[i] = arr[i];
		}
		for(int i=0;i<arr.length - d;i++) {
			arr[i] = arr[i+d];
		}
		int k=0;
		for(int i=arr.length-d;i<arr.length;i++) {
			arr[i] = tempArr[k];
			k++;
		}
		for(int i:arr) {
			System.out.println(i);
		}
	}

}

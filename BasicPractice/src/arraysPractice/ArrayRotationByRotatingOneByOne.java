package arraysPractice;

/* leftRotate(arr[], d, n)
 * start
 * For i = 0 to i < d
 * Left rotate all elements of arr[] by one
 * end
 * To rotate by one, store arr[0] in a temporary variable temp, move arr[1] to arr[0], arr[2] 
 * to arr[1] …and finally temp to arr[n-1]
 * Let us take the same example arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
 * Rotate arr[] by one 2 times
 * We get [2, 3, 4, 5, 6, 7, 1] after first rotation and [ 3, 4, 5, 6, 7, 1, 2] after second rotation.
 * 
 */

public class ArrayRotationByRotatingOneByOne extends ArrayRotationUsingTempArray{

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		int d=2;
		for(int j=0;j<d;j++) {
			int temp=arr[0];
			for(int i=1;i<arr.length;i++) {
				arr[i-1] = arr[i]; 
			}
			arr[arr.length-1]=temp;
		}
		
		ArrayRotationByRotatingOneByOne o = new ArrayRotationByRotatingOneByOne();
		o.print(arr);
		//using the print method of previous class
	}
}

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
 * 
 */
public class ArrayRotationUsingTempArray {
	
	public void approach1(int arr[],int d) {
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
	}
	
	public void print(int arr[]) {
		for(int i:arr) {
			System.out.print(i + " ");
		}	
		System.out.println();
	}
	
	public void approach2(int arr[],int d) {
		int tempArr[] = new int[d];
		int k=0;int j=0;
		for(int i=0;i<arr.length+d;i++) {
			if(i<d) {
				tempArr[i] = arr[i];
			}else if(i<arr.length){
				arr[k] = arr[i];
				k++;
			}else {
				arr[k] = tempArr[j];
				k++;
				j++;
			}
		}
	}	

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		//rotation by 2
		int d=2;
		System.out.println("Initial Array:");
		ArrayRotationUsingTempArray obj1 = new ArrayRotationUsingTempArray();
		obj1.print(arr);
		obj1.approach1(arr, d);
		System.out.println("Array after approach1");
		obj1.print(arr);
		ArrayRotationUsingTempArray obj2 = new ArrayRotationUsingTempArray();
		System.out.println("Array before approach 2");
		obj2.print(arr);
		obj2.approach2(arr, d);
		System.out.println("Array after approach 2");
		obj2.print(arr);
	}

}

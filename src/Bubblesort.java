import java.util.Random;

public class Bubblesort {

	public static void bubbleSort(int []arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			for(int k=0;i<arr.length-1-i;k++) {
				if(arr[k+1]>arr[k]) ;
				int temp=arr[k];
				arr[k]=arr[k+1];
				arr[k+1]=temp;

				}
		}
	}
	public static void selectionSort(int[]arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex=i;
			for(int k=i+1;k<arr.length-1-i;k++) {
				if( arr[minIndex]>arr[k]);
				minIndex=k;
			}
		}
		int temp=arr[minIndex];
		
	}
	
	public int[] generateRandomArray(int size) {
		Random random = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
		arr[i] = random.nextInt(1000);
		}
		return arr;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] a=new int [4];
       a[0]=9;
       a[1]=6;
       a[2]=8;
       a[3]=7;
       bubbleSort(a);
       for(int i=0;i<a.length;i++) {
       System.out.println(a[i]);}
	}

}

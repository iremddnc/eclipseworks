
public class Arrayexample {
  
	
	
	public static int sumColumn (int[][] array2,int columnIndex) { 
		int sum=0;
		for(int[] row: array2) {
			sum+=row[columnIndex];
		}
      return sum;}
			public static int sumRow(int[][]array,int rowIndex) {
				int sum=0;
				for(int column=0; column<array[rowIndex].length;column++) {
					sum+=array[rowIndex][column];
				}
				return sum;
			}
		
					
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array= {{2,3,4},{4,5,6}};
       System.out.println(sumColumn(array,2));
       System.out.println(sumRow(array,1));
	}

}
















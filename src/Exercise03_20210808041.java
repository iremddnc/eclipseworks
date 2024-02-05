
public class Exercise03_20210808041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] array2D = generateArray2D(4, 4, 0, 10);
        display2D(array2D);
        int diagonalSum = sumDiagonal(array2D);
        System.out.println("Sum of the diagonal for the given 2D array is: " + diagonalSum);*/
		
	}
	
	 public static int sumDiagonal(int[][] array2D) {
							int sum=0;
				for(int column=0; column<array2D.length;column++) {
					sum+=array2D[column];
				}
				return sum;
			}

	    public static int[][] generateArray2D(int m, int n, int start, int end) {
	        int[][] array2D = new int[m][n];
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                array2D[i][j] = random(start, end);
	            }
	        }

	        return array2D;
	    }

	    public static void display(double[] array) {
	        for (double i : array) {
	            System.out.printf("%.1f\t", i);
	        }
	        System.out.println();
	    }

	    public static void display(int[] array) {
	        for (int i : array) {
	            System.out.printf("%d\t", i);
	        }
	        System.out.println();
	    }

	    public static void display2D(int[][] array2D) {
	        for (int[] row : array2D) {
	            display(row);
	        }
	        System.out.println("--------------------------");
	    }
}

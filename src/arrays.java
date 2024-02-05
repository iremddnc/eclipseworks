
public class arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]array=generateList( 55,4,100);
		//minden maxa kadar n tane random değer yazdırır
		displayList(array);
	}
		
		
   public static void displayList(int[]list) {
	   System.out.println();
	   for(int i:list) {
		   System.out.println(i+" ");
		     }
	   
	   System.out.println();   
   }
		
	public static int[] generateList(int n,int min,int max) {
		int[] list=new int[n];
		for(int i=0;i < list.length;i++)	{
			list[i]=min+(int)(Math.random()*(max-min));
			//clone A'dakini B'ye yansıtmaz
		}	
		return list;
	}
	
	
	public static int LinearSearch(int array[],int k) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==k)
				return i;
		}
		return-1;
		
	}

}

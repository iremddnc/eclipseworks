
public class primitiveandReferancetypes {
public static void main(String[] args) {
	//primitive data types
	int sayi1=-5;
	int sayi2=10;
	sayi1=sayi2;
	sayi1=20;
	System.out.println(sayi2);
	
	//reference data types
	int [] numbers= {15,25,35,45};
	//int [] numbers2=new int[] {55,35,75,85};
	int[] numbers2= new int[numbers.length];
	for(int i=0;i<numbers.length;i++) {
		numbers2[i]=numbers[i];//deep copy 2 kopya
	}
	for(int i=0;i<numbers2.length;i++) {
		System.out.println(numbers2[i]);//birinde yapılan değişiklik diğerini etkilemicek
	}
	numbers[1]=48;
	System.out.println(numbers2[1]);//2 farklı kopya var,ramde 2 farklı yer
	//numbers2=numbers;// shallow copy tek,birinde yapılan değişiklik diğerini etkier
	///numbers[0]=5;
	System.out.println(numbers2[0]);
}
}

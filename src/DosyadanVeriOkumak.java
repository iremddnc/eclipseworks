import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DosyadanVeriOkumak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     FileInputStream fis=null;
     
     try {
		fis=new FileInputStream("dosya.txt"); 
		int değer;
		String s="";//tüm dosyayı okuyacağımız için 
		int say=0;
		fis.skip(5);
		while((değer=fis.read())!=-1) {
			s+=(char) değer;
			say++;
			if(say==10) {
				break;
			}
		}
		System.out.println("dosyanın5. yerinden itibaren 10 karakter");
		//while((değer=fis.read()) !=-1) {
			//s+=(char) değer;//s e bütün karakterleri atmış olduk
			
		//}
		System.out.println("dosya içeriği"+s);
		/*fis.skip(5);//gösterdiğim değerdeki yeri okuyor
		System.out.println("okunan karakter:"+(char)fis.read());//gösterdiğim depğerdeki yerden sonrasını okuyor
System.out.println("okunan karakter:"+(char)fis.read());*///tek bir  byte okudum ve o byte ın char halini göstermek istediğimizi söyledik
} catch (FileNotFoundException e) {
		System.out.println("file bulunamadı");
	} catch (IOException e) {
	System.out.println("dosya okunurken hata oluştu");
} 
     finally {
    	 try {
			fis.close();
		} catch (IOException e) {
			System.out.println("dosya kapatılırken hata oluştu");
		}
     }
	}

}

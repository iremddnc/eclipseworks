import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosyayaVeriYazmak {

	public static void main(String[] args) {
		
	
    FileOutputStream fos=null;
    //File file=new File("dosya.txt");
 
     try {
		fos =new FileOutputStream("dosya.txt",true);//true dosyanın içeriği varsa sona ekle
		//byte array={11,75,66,68};
		//fos.write(array);
		String s="Mustafa,Murat";
		byte[] s_array=s.getBytes();//string byte arrayine atılmış oldu.
		fos.write(66);
		fos.write(s_array);
		//Eğer dosyaya bir veri yazmak istiyorsak bunu mutlaka byte arrayine dönüştürmemiz gerekir
	} catch (FileNotFoundException e) {
      System.out.println("File Not Found Exception oluştu");	
      } catch (IOException e) {
		System.out.println("dosya yazılırken bir hata oluştu");
	}
     finally {//arka planlardaki kaynaklarda gereksiz kulllanmamak için kapattık
    	 try {
			fos.close();
		} catch (IOException e) {
     System.out.println("Dosya kapatılırken bir hata oluştu");		}
        }
	}

}

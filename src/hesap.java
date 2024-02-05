
public class hesap {
 private String kullanici_adi;
 private String parola;
 private String bakiye;
       
 public hesap(String kullanici_adi,String parola,String bakiye) {
	 this.setKullanici_adi(kullanici_adi);
	 this.setParola(parola);
	 this.setBakiye(bakiye);
	 
 }

public String getKullanici_adi() {
	return kullanici_adi;
}

public void setKullanici_adi(String kullanici_adi) {
	this.kullanici_adi = kullanici_adi;
}

public String getParola() {
	return parola;
}

public void setParola(String parola) {
	this.parola = parola;
}

public String getBakiye() {
	return bakiye;
}

public void setBakiye(String bakiye) {
	this.bakiye = bakiye;
}
 public void paraYatir(int tutar) {//para yatırma methodu
 bakiye+=tutar;
 System.out.println("yeni bakiyeniz"+bakiye);
 }
public void paraCek(int tutar) {
	if ((bakiye - tutar) < 0) {
		System.out.println("yeterli bakiye yok");
	}
	else {
		bakiye-=tutar;
	}
	}
	
	
	

 
 
 
 
 
 
}

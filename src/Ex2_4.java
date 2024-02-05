import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex2_4 {
	
}
class Computer {
	protected CPU cpu;
	protected RAM ram;
	public Computer(CPU cpu, RAM ram) {
		this.cpu = cpu;
		this.ram = ram;
	}
	public void run() {
		int sum=0;
		 for(int i=0; i<ram.getCapacity();i++) {
             sum+= ram.getValue(i,i);
         }
         ram.setValue(0,0,sum);
         cpu.compute(0,sum);
     }
	public String toString() {
		return "Computer: "+cpu+" "+ram;
	}

}
class Laptop extends Computer{
    private int milliAmp;
    private int battery;
    
	public Laptop(CPU cpu, RAM ram,int milliAmp) {
		super(cpu, ram);
		this.milliAmp=milliAmp;
		this.battery=milliAmp*30/100;
	}
	public int batteryPercentage() {
		return battery*100/milliAmp;
	}
	public void charge() {
		 while (battery<milliAmp*90/100) {
             battery+= milliAmp*2/100;
             if(battery>=milliAmp*90/100) {
               break;  }
             } 
     }
	public void run() {
		if(battery>milliAmp*5/100) {
			battery-=milliAmp*3/100;
		}
		if(battery<milliAmp*5/100) {
			charge();
		}
	}
	public String toString() {
		return super.toString()+" "+battery;
	}
}
class Desktop extends Computer{
	ArrayList<String>peripherals;

	public Desktop(CPU cpu,RAM ram,String...peripherals) {
		super(cpu, ram);
        this.peripherals=new ArrayList<>(Arrays.asList(peripherals));
	}
	public void run() { 
		
	}
	public void plugIn(String peripheral) {
		peripherals.add(peripheral);
	}
	public String plugOut() {
		return peripherals.remove(peripherals.size()-1);
	}
	public String plugOut(int index) {
		  return peripherals.remove(index);}
	
	public String toString() {
		return super.toString()+" "+peripherals;
	}
}
class CPU{
	private String name;
	private double clock;
	public CPU(String name, double clock) {
		this.name = name;
		this.clock = clock;
	}
	public String getName() {
		return name;
	}

	public double getClock() {
		return clock;
	}
	public int compute(int a,int b) {
		return a+b;
	}
	public String toString() {
		return "CPU: "+name+" "+clock+"Ghz";
	}
}
class RAM{
	private String type;  
	private int capacity;
	private int[][] memory;
	public RAM(String type,int capacity) {
		this.type=type;
		this.capacity=capacity;
		initMemory();
	}
	public String getType() {
		return type;
	}

	public int getCapacity() {
		return capacity;
	}

  public String toString() {
	return "RAM: "+type+" "+capacity+"GB";
}
   private void initMemory() {
	 memory=new int[capacity][capacity];
     Random fill=new Random();
    	 for (int i=0;i<capacity;i++){
	       for (int j=0;j<capacity;j++) {
	       memory[i][j]=fill.nextInt(11);
	     }
	        } 
    }
   private boolean check(int i,int j) {
    return (i>=0 && i<capacity && j>=0 && j<capacity); 
   }
   public int getValue(int i,int j) {
	if(!check(i,j)) { 
		return -1;
	  }
	return memory[i][j];
} 
    public void setValue(int i,int j,int value) {
	if(check(i,j)) {
		memory[i][j]=value;
	} }



}


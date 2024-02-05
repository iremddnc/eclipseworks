import java.lang.Math;

public class Physic {
    public static void main(String[] args) {
     double distance = 1.0; 
     double charge = 1e-9;
     double rod = 1.0;
     double V0, V1, V2, V4, V6, V8, VN;
     
      V0 = calculatePotential(distance,charge,rod);
        System.out.println("V0: " + V0);
        
      V1 = calculatePotential(distance,charge, 0.0);
        System.out.println("V1: " + V1);
        
      double Q2 = charge / 2.0;
      V2 = calculatePotential(distance, Q2,rod);
        System.out.println("V2: " + V2);
        
      double Q4 = charge / 4.0;
      V4 = calculatePotential(distance, Q4, rod);
        System.out.println("V4: " + V4);
        
      double Q6 = charge / 6.0;
      V6 = calculatePotential(distance, Q6, rod);
        System.out.println("V6: " + V6);
        
      double Q8 = charge / 8.0;
      V8 = calculatePotential(distance, Q8, rod);
        System.out.println("V8: " + V8);
        
      int N = 1000000; 
      double QN = charge / N;
        VN = calculatePotential(distance, QN, rod);
        System.out.println("VN: " + VN);
    }
    
  public static double calculatePotential(double x, double q, double l) {
        double coulomb = 9e9; 
        return coulomb*q/(Math.sqrt(x * x + l * l));
    }
}

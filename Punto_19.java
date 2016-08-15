package Taller_1;
import java.util.Scanner;
public class Punto_19 {
    
     public static void main(String[] args) {
         Scanner numero=new Scanner (System.in);
         System.out.println("Ingrese su edad");
         int edad=numero.nextInt();
         if(0<=edad&&edad<=120){
             System.out.println("La edad de "+edad+" es posible");
         }
         else{
             System.out.println("La edad de "+edad+" es imposible");
         }
     }
    
}
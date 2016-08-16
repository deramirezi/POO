package Taller_1;
import java.util.Scanner;
public class Punto_22 {
    
    
    public static void main(String[] args) {
        
      Scanner contraseña=new Scanner (System.in);      
      String password="carrot";
      char a=(';'+13);
      char b=('b'+13);
      char c=('_'+13);
      char d=('T'+13);
      boolean verificar=false;
      
      do{
         System.out.println("Ingrese la contraseña:");
         String Password=contraseña.nextLine();
           if(password.compareTo(Password)==0){
             verificar=true;
           }
      }   
      while(verificar==false);
      
      System.out.println("la contraseña es CORRECTA"); 
      System.out.println("El mensaje secreto es:"+a+b+c+d);
      
    }
    
}

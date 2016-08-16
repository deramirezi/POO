package Taller_1;
import java.util.Scanner;
public class Punto_20 {
    
     public static void main(String[] args) {
         
         Scanner ingresar=new Scanner (System.in);
         
         String Username_1="alex";
         String Username_2="emily";
         String Password_1="mightyducks";
         String Password_2="cat";
         
         System.out.println("Ingrese su usuario:");
         String Username=ingresar.nextLine();
         System.out.println("Ingrese su contraseña:");
         String Password=ingresar.nextLine();
         
         if(((Username_1.compareTo(Username)==0)&&(Password_1.compareTo(Password)==0))
          ||((Username_2.compareTo(Username)==0)&&(Password_2.compareTo(Password)==0))){
             System.out.println("Usuario y Contraseña correctas");
         }
         else{
             System.out.println("Usuario o contraseña INCORRECTA");
         }
     }
    
}
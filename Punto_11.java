package Taller_1;
import java.util.Scanner;
public class Punto_11 {
    
    public static void main(String[] args) {
        
        Scanner numero=new Scanner (System.in);
      
        System.out.println("Ingrese el primer numero");
        int numero_1=numero.nextInt();
        System.out.println("Ingrese el segundo numero");
        int numero_2=numero.nextInt();
        
        if(numero_1>numero_2){
            System.out.println("El "+numero_1+" es el numero mas grande");
        }
        else{
            if(numero_1==numero_2){
                System.out.println("Los 2 numeros son iguales");
            }
            else{
                System.out.println("El "+numero_2+"es el numero mayor");
            }
        }      

    }
}
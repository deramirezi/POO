package Taller_1;
import java.util.Scanner;
public class Punto_16 {
    
    public static void main(String[] args) {
        Scanner ingresar=new Scanner (System.in);
        System.out.println("Ingrese un numero");
        int numero=ingresar.nextInt();
        
        if(numero%2==0){
            System.out.println("El numero "+numero+" es par");
        }
        else{
            System.out.println("El "+numero+" es impar");
        }
    }
}
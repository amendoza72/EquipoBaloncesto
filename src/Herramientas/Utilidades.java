package Herramientas;

import java.util.Scanner;

public class Utilidades {
    static Scanner scanner = new Scanner(System.in);
 
    public static int leerEntero(String dato){
        while (true){
            try{
                System.out.println("Dar " + dato);
                String datoLeido = scanner.nextLine();
                int numeroLeido = Integer.parseInt(datoLeido);
                return numeroLeido;
            }
            catch (Exception e){
                System.out.println("Valor erroneo");
            }
        }
    }

    public static double leerDouble(String dato){
        while (true){
            try{
                System.out.println("Dar " + dato);
                String datoLeido = scanner.nextLine();
                double numeroLeido = Double.parseDouble(datoLeido);
                return numeroLeido;
            }
            catch (Exception e){
                System.out.println("Valor erroneo");
            }
        }
    }
    
}

/*  Quiero hacer el comentario aca de que he decidido hacer el metodo main de modo que me ejecute la interfaz
aparte de la clase JuegoBatalla dado que en la anterior asignacion intente hacer tanto la interfaz como los metodos a 
ejecutarse en una misma y el resultado fue improductivo   */

import java.util.Scanner;

public class Main {
    static JuegoBatalla constructorVacio = new JuegoBatalla(); // Para poder vincular los metodos de la clase JuegoBatalla
    static int respuesta;

    public static void main (String [] args) {

        while(respuesta !=2) {

            Scanner input = new Scanner(System.in);
            System.out.println("                  Menu \n         Simulador de batalla de Robots " + "\n");
            System.out.println(" 1. Iniciar nueva simulacion " + "\n" + " 2. Salir del simulador " );   
            respuesta = input.nextInt();

            switch (respuesta) {
                case 1:
                    constructorVacio.datosPartida();
                    constructorVacio.iniciarBatalla();
                    
                    break;
                case 2:
                    input.close(); 
                    break;
            
                default:
                    System.out.println(" Ingrese una opcion valida ");
                    break;
            }
        }
    }
}

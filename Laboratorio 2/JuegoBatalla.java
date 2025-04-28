// Clase juego de batalla aca vamos a crear los metodos a ejecutar en la interfaz interativa
import java.util.Scanner; // traemos la libreria lectora de entradas

public class JuegoBatalla {

    private Robot robots []; // hacemos el arreglo multidimensional 
    private int numeroRobots;



    public void datosPartida () { // Metidi oara  el  registro de los datos con los que la batalla sera ejecutada 

        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println(" Ingrese la unidad entera positiva de robots que habran en la batalla, maximo 10 ");
            numeroRobots = input.nextInt();
             input.nextLine(); 
            System.out.println(" La cantidad de robots que digito es incorrecta ");

            /* Limpio buffer, este mismo comando lo estare respitiendo varias veces porque del proyecto pasado se me 
            caia el programa si no lo ponia por entrada cada que el usuario interactua con el programa desde consola,  
            por simplicidad, no voy a denotar mas en adelante la aclaracion de que limpiare el buffer*/
        } while (numeroRobots > 10 || numeroRobots <= 0);

        System.out.println();
        System.out.println(" Ingrese los datos de cada robot participante, nombre, ataque y defensa  ");

        robots = new Robot [10]; // Este vector, es un arreglo que contiene la informacion para 10 robots maximo
        // Ciclo for para el instanciamiento desde la interfaz de la clase robot
        for (int i = 0; i < numeroRobots; i++) {

            // Registramos el nombre
            System.out.println(" Este es el robot numero " + (i+1) + "\n Ingrese el nombre del robot ");
            String nombre = input.nextLine(); 
            

            // Registro de puntos de vida
            int puntosVida; //declaramos fuera del do/while para ponerlo de argumento en el operador bucle 
            do {
                System.out.println(" Ingrese los puntos de vida de " + nombre + " debe  ser un valor entre 50 y 100, incluidos ");
                puntosVida = input.nextInt();
                input.nextLine();
                if (puntosVida < 50 || puntosVida > 100) {  
                    System.out.println("\nIngrese un valor valido para los puntos de vida, un valor entre 50 y 100 ");
                }
            }  while(puntosVida < 50 || puntosVida > 100); 


            int ataque; 
            do {
                System.out.println(" Registre la cantidad de ataque de " + nombre + " debe ser una cantidad entre 10 y 20 ");
                ataque = input.nextInt();
                input.nextLine();
                if (ataque > 20 || ataque < 10 ) {
                    System.out.println(" Ingrese un valor valido entre 10 y 20 ");
                }
            } while (ataque > 20 || ataque < 10 );

            int defensa;
            do {
                System.out.println(" Ingrese el valor del escudo de defensa de " + nombre + " debe ser una cantidad entre 0 y 10");
                defensa = input.nextInt();
                input.nextLine();
                if( defensa > 10 || defensa < 0){
                    System.out.println(" Ingrese un valor valor entre 0 y 10 ");
                }
                } while (defensa > 10 || defensa < 0);
            
        robots[i] = new Robot (nombre, puntosVida, ataque, defensa);   

        }

    }

    // Metodo incicializar batalla 
    public void iniciarBatalla() {

    // Agregar metodo 
    // Ejecucion de la batalla
        while (validacionRondas() > 1) {

            
            for (int i = 0; i < numeroRobots; i++) {
                if (robots[i].estaVivo())  {
                    // Seleccion arbitraria de objetivo
                    int indiceAtaque; 
                    do {
                        indiceAtaque = (int) (Math.random() * numeroRobots);
                    } while (indiceAtaque == i || !robots[indiceAtaque].estaVivo());
                    // Accion de ataque
                    robots[i].atacar(robots[indiceAtaque]);
                    // Eliminacion de robot 
                    if (!robots[indiceAtaque].estaVivo()) {
                        System.out.println(" El robot " + robots[indiceAtaque].getNombre() + " ha sido destruido por " + robots[i].getNombre());
                        // Acomodamos arreglo, desplazando a la derecha a los robots eliminados 
                        for (int j = indiceAtaque ; j < numeroRobots - 1; j++) {
                            robots[j] = robots [j + 1];
                        }
                    robots[numeroRobots - 1] = null; // Agregado para descartar que un robot que fuera eliminado siga apareciendo y tenga vida negativa 
                    numeroRobots--; // Actualizamos numero de robots en batalla

                    if (indiceAtaque < i) { // Agregado para actualizar el tamanio del arreglo que almacena la informacion de los robots activos, y descartar que sigan siendo objetivos los robots eliminados 
                        i--;
                    }
                    } // Nota adicional, es posible hallar robots cuya vida caiga a valores negativos pero se debe a que el ataque final que reciben les hace bajar sus puntos de vida  a dichos valores, no obstante se eliminan satisfactoriamente del array al momento de ser eliminados  

                }               
            } 
        }
        mostrarGanador();
    }

    /* Realizo metodo auxiliar para contar cuantos robots hay y garantizar que se vuelva a ejecutar for anidado en el while y 
    se puedan dar todas las rondas hasta que solo quede un robot, anteriormente tenia solo el for sin anidarlo en el while y solo se daba una simulacion */
    private int validacionRondas() {
        int robotActivo = 0;
        for (int i = 0; i < numeroRobots; i++) {
            if (robots[i].estaVivo()) robotActivo++;
        }
        return robotActivo;
    }

    // Metodo para mostrar ganador 
    public void mostrarGanador() {
        for (int i = 0; i <numeroRobots; i ++) {
            if (robots[i].estaVivo()) {
            System.out.println(" El robot ganador es " + robots[i].getNombre() + " su videa restante es de " + robots[i].getPuntosVida());
            return;
            }
        }
    }
        







}
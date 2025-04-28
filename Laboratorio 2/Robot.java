// CLase robot 

public class Robot {

    // Encapsulamos los atributos 

    private String nombre; // nombre que llevara cada robot
    private int puntosVida, ataque, defensa; //puntos vida esta entre 50 y 100, ataque entre 10 y 20 & defensa entre 1 y 10 , los extremos de los intervalos estan incluidos 


    // Metodos 


    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void setPuntosVida (int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setAtaque (int ataque) {

        this.ataque = ataque;

    }
    public void setDefensa (int defensa) {
        this.defensa = defensa;

    }

    // Getters 

    public String getNombre() {
        return nombre;
    
    }

    public int getPuntosVida () {
        return puntosVida;

    }
    public int getAtaque() {
        return ataque;
    }

    // Constructor 

    public Robot (String nombre, int puntosVida, int ataque, int defensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;

    }

    // Atacar robot a otro robot

    public void atacar (Robot otroRobot) {

        System.out.println("El robot " + this.nombre + " ataca al robot " + otroRobot.nombre );
        int danio = this.ataque - otroRobot.defensa;
        if (danio >0) {
            otroRobot.puntosVida -= danio; // implementamos logica de defensa para parte opcional de puntos extra
            System.out.println(" La vida de " + otroRobot.nombre + " es de " + otroRobot.puntosVida);
        }


    }


    // Verificar si Robot esta vivo
    public boolean estaVivo () {
        return this.puntosVida > 0; // retorna valor true o false 

    }



}

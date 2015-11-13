package practica1;

import java.util.Scanner;
/**
 *
 * @author Emilio y Noelia
 */
public class Jugador extends Personas{
   
    private int salario;
    private String posicion;
    private boolean titular;
    private int num;
    Scanner scanf = new Scanner(System.in);

    public Jugador (int id,String nombre){
        super(id,nombre);
    }
    public Jugador(int id, String nombre, String posicion) {
        super(id, nombre);
        this.salario = salario;
        this.posicion = posicion;
        this.titular = titular;
        this.num = num;
    }
    public void DatosJugador(){
    	System.out.print("id: ");
    	this.id = scanf.nextInt();
    	System.out.print("nombre: ");
    	this.nombre = scanf.next();
    	System.out.print("Salario: ");
    	this.salario = scanf.nextInt();
    	System.out.print("Posicion: ");
    	this.posicion = scanf.next();
    	System.out.print("Titular[S/N]: ");
    	this.titular = scanf.nextBoolean();
    	System.out.print("Numero de Camiseta: ");
    	this.num = scanf.nextInt();
    }
    public void ListarJugador(){
    	System.out.println("id: "+this.id);
        System.out.println("nombre: "+this.nombre);
        System.out.println("Salario: "+this.salario);
        System.out.println("Posicion: "+this.posicion);
        System.out.println("Titular:[S/N]: "+this.titular);
        System.out.println("Numero de Camiseta: "+this.num);
    }
    
    
}

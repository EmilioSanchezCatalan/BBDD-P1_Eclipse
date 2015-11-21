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
    private Scanner scanf = new Scanner(System.in);

    public Jugador (int id,String nombre){
        super(id,nombre);
    }
    public void SetData(){
    	System.out.print("id: ");
    	this.id = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("nombre: ");
    	this.nombre = scanf.nextLine();
    	System.out.print("Salario: ");
    	this.salario = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("Posicion: ");
    	this.posicion = scanf.nextLine();
    	System.out.print("Titular[S/N]: ");
    	this.titular = scanf.nextBoolean();
    	System.out.print("Numero de Camiseta: ");
    	this.num = scanf.nextInt();
    }
	
    
}

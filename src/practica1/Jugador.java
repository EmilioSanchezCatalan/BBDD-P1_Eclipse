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
    	System.out.print("Id: ");
    	id = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("Nombre: ");
    	nombre = scanf.nextLine();
    	System.out.print("Salario: ");
    	salario = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("Posicion: ");
    	posicion = scanf.nextLine();
    	System.out.print("Titular[S/N]: ");
    	titular = scanf.nextBoolean();
    	System.out.print("Numero de Camiseta: ");
    	num = scanf.nextInt();
    	System.out.print("Email: ");
    	
    }
    
    public int getSalario() {
		return salario;
	}
    public String getPosicion() {
		return posicion;
	}
    public boolean getTitular() {
		return titular;
	}
    public int getNum() {
		return num;
	}
   
	
    
}

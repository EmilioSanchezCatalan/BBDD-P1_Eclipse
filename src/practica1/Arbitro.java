package practica1;

import java.util.Scanner;

/**
 *
 * @author Emilio y Noelia
 */
public class Arbitro extends Personas {
    
    private String tipo;
    private Scanner scanf = new Scanner(System.in);
    public Arbitro(int id, String nombre) {
        super(id, nombre);
    }
    public void SetData(){
    	System.out.print("id: ");
    	this.id = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("nombre: ");
    	this.nombre = scanf.nextLine();
    	System.out.print("tipo: ");
    	this.tipo = scanf.nextLine();
    }
	public String getTipo() {
		return tipo;
	}
    

    
}

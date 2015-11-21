package practica1;

import java.util.Scanner;

/**
 *
 * @author Emilio y Noelia
 */
public class Estadio {
    
    private int idestadio;
    private String nombre;
    private String Direccion;
    private String Ciudad;
    private int Capacidad;
    private Scanner scanf = new Scanner(System.in);
    public Estadio() {
        
    }
    public void SetData(){
    	System.out.print("id: ");
    	this.idestadio = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("nombre: ");
    	this.nombre = scanf.nextLine();
    	System.out.print("direccion: ");
    	this.Direccion = scanf.nextLine();
    	System.out.print("ciudad: ");
    	this.Ciudad = scanf.nextLine();
    	System.out.print("capacidad: ");
    	this.Capacidad = scanf.nextInt();
    	
    }
	public int getIdestadio() {
		return idestadio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public int getCapacidad() {
		return Capacidad;
	}
    
}

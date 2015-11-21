package practica1;

import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Emilio y Noelia
 */
public class Equipo {
    
    private int idequipo;
    private String nombre;
    private Estadio esta;
    private int posicion;//posicion que esta en la liga
    public Collection <Jugador> ljuga;
    private Scanner scanf = new Scanner(System.in);
    public Equipo(){
    	ljuga = new ArrayList<Jugador>();
    }
    
    public void SetData(){
    	System.out.print("id: ");
    	idequipo = scanf.nextInt();
    	scanf.nextLine();
    	System.out.print("nombre: ");
    	nombre = scanf.nextLine();
    	System.out.print("posicion de la liga: ");
    	posicion = scanf.nextInt();
    }
    public void AltaEstadio(Estadio e){
    	esta = e;
    }
    public void AltaJugador(Jugador j){
    	
        ljuga.add(j);
        
    }
    
    public void BajaJugador(Jugador j){
        ljuga.remove(j);
    }

	public int getIdequipo() {
		return idequipo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEsta() {
		return esta.getIdestadio();
	}
	public int getPosicion() {
		return posicion;
	}
	
}

package practica1;

import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author Emilio y Noelia
 */
public class Equipo {

	private int idequipo;
	private String nombre;
	private Estadio esta;
	private int posicion;// posicion que esta en la liga
	private int partidos_ganados;
	public Collection<Jugador> ljuga;

	public Equipo() {
		ljuga = new ArrayList<Jugador>();
	}

	public void AltaEstadio(Estadio e) {
		esta = e;
	}

	public void AltaJugador(Jugador j) {

		ljuga.add(j);
	}

	public void BajaJugador(Jugador j) {
		ljuga.remove(j);
	}

	public boolean Pertenecia(Jugador j) {
		if (ljuga.contains(j))
			return true;
		else
			return false;
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

	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEsta(Estadio esta) {
		this.esta = esta;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getPartidos_ganados() {
		return partidos_ganados;
	}

	public void setPartidos_ganados(int partidos_ganados) {
		this.partidos_ganados = partidos_ganados;
	}
}

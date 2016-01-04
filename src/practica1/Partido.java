package practica1;

import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author Emilio y Noelia
 */
public class Partido {

	private int idpartido;
	private Estadio e;
	private String X;
	private Equipo eq1;
	private Equipo eq2;
	private boolean ida;
	private Collection<Arbitro> larbitros;
	private Collection<Jugador> leq1;
	private Collection<Jugador> leq2;
	private int golesA;
	private int golesB;

	// id;idestadio;X;idequipo1;idequipo2;ida;golesA;golesB
	public Partido() {
		larbitros = new ArrayList<Arbitro>();
		leq1 = new ArrayList<Jugador>();
		leq2 = new ArrayList<Jugador>();
	}

	public int getIdpartido() {
		return idpartido;
	}

	public void setIdpartido(int idpartido) {
		this.idpartido = idpartido;
	}

	public Estadio getE() {
		return e;
	}

	public void setE(Estadio e) {
		this.e = e;
	}

	public String getX() {
		return X;
	}

	public void setX(String X) {
		this.X = X;
	}

	public Equipo getEq1() {
		return eq1;
	}

	public void setEq1(Equipo eq1) {
		this.eq1 = eq1;
	}

	public Equipo getEq2() {
		return eq2;
	}

	public void setEq2(Equipo eq2) {
		this.eq2 = eq2;
	}

	public boolean isIda() {
		return ida;
	}

	public void setIda(boolean ida) {
		this.ida = ida;
	}

	public int getGolesA() {
		return golesA;
	}

	public void setGolesA(int golesA) {
		this.golesA = golesA;
	}

	public int getGolesB() {
		return golesB;
	}

	public void setGolesB(int golesB) {
		this.golesB = golesB;
	}

	public Collection<Arbitro> getLarbitros() {
		return larbitros;
	}

	public void setLarbitros(Arbitro a) {
		larbitros.add(a);
	}

	public Collection<Jugador> getLeq1() {
		return leq1;
	}

	public void setLeq1(Collection<Jugador> leq1) {
		this.leq1 = leq1;
	}

	public Collection<Jugador> getLeq2() {
		return leq2;
	}

	public void setLeq2(Collection<Jugador> leq2) {
		this.leq2 = leq2;
	}

}

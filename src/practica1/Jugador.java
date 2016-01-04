package practica1;

/**
 *
 * @author Emilio y Noelia
 */

public class Jugador extends Personas {

	private int salario;
	private String posicion;
	private boolean titular;
	private int num;

	public Jugador(int id, String nombre, String email, String Tlf) {
		super(id, nombre, email, Tlf);
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

	public void setSalario(int salario) {
		this.salario = salario;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

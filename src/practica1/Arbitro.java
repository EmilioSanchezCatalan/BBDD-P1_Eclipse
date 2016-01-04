package practica1;

/**
 *
 * @author Emilio y Noelia
 */
public class Arbitro extends Personas {

	private String tipo;

	public Arbitro(int id, String nombre, String email, String Tlf, String tipo) {
		super(id, nombre, email, Tlf);
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

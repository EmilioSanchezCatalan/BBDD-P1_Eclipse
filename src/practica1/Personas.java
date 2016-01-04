package practica1;

/**
 *
 * @author Emilio y Noelia
 */
public class Personas {
	protected int id;
	protected String nombre;
	protected String email;
	protected String Tlf;

	public Personas() {

	}

	public Personas(int id, String nombre, String email, String Tlf) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.Tlf = Tlf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlf() {
		return Tlf;
	}

	public void setTlf(String tlf) {
		Tlf = tlf;
	}

}

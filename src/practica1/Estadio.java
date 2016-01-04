package practica1;

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

	public Estadio() {

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

	public void setIdestadio(int idestadio) {
		this.idestadio = idestadio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}

}

package practica1;
/**
 *
 * @author Emilio y Noelia
 */
public class Personas {
    public int id;
    public String nombre;
    private String email;
    private String Tlf;

    public Personas(){
        
    }
    public Personas(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }

    public void SetEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return Tlf;
    }

    public void SetTlf(String Tlf) {
        this.Tlf = Tlf;
    }
    
    
}

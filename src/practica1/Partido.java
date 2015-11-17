package practica1;
import java.util.Collection;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Emilio y Noelia
 */
public class Partido {
    
    private int idpartido;
    private Estadio e;
    private Date X;
    private Equipo eq1;
    private Equipo eq2;
    private boolean ida;
    private Collection<Arbitro> larbitros;
    private Collection<Jugador> leq1;
    private Collection<Jugador> leq2;
    private int golesA;
    private int golesB;
    
    public Partido(){
        X = new Date();
        larbitros = new ArrayList<Arbitro>();
        leq1 = new ArrayList<Jugador>();
        leq2 = new ArrayList<Jugador>();
    }
    
}

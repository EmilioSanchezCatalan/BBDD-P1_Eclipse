package practica1;

import java.util.Collection;

/**
 *
 * @author Emilio y Noelia
 */
public class Equipo {
    
    private int idequipo;
    private Estadio esta;
    private int posicion;//posicion que esta en la liga
    public Collection <Jugador> ljuga;
    
    public Equipo(int ideq, Estadio esta){
        idequipo = ideq;
        this.esta = esta;
    }
    public void AltaJugador(Jugador j){
        
    }
    public void BajaJugador(Jugador j){
        
    }
}

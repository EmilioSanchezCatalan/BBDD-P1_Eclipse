package practica1;

import java.util.Map;
import java.util.Collection;
import java.util.Scanner;
/**
 *
 * @author Emilio y Noelia
 */
public class AppFutbol {
    
    private Map<Integer, Equipo> lEquipos; //el integer será el idequipo
    private Map<Integer, Jugador> lJugadores; //Integer será idjugador
    private Map<Integer, Arbitro> lArbitros ; // ..igual
    private Map<Integer, Estadio> lEstadios ; //..igual
    private Collection<Partido> lpartidos;
    private Scanner scanf = new Scanner(System.in);
    public AppFutbol() {
    }
   /* public Equipo altaEquipo(){
        
    }
    public boolean bajaEquipo(){
        
    }
    */
    public Jugador altaJugador(){
       
        Jugador j = new Jugador(0,null);
        j.DatosJugador();
        return j;
        
    }
    /*
    public boolean bajaJugador(){
        
    }
    public Arbitro altaArbitro(){
        
    }
    public boolean bajaArbitro(){
        
    }
    public Arbitro altaEstadio(){
        
    }
    public Partido altaPartido(){
        
    }
    public boolean bajaPartido(){
        
    }
    public void listarEstadios(){
        
    }
    public void listarEquipos(){
        
    }
    public void listarArbitros(){
        
    }
    public int ContarPartidos(){
       
    }
    void listarPartidos(dada una fecha){
        
    }
    void listarPartidos(dado un equipo){
        
    }
    void listarJugadores(..dada una psicion ene le campo..){
        
    }
    void listarJugadoresEquipo(..dado un equipo){
        
    }
    
    public void Salvar(){
        
    }
    public void CargarDatos(){
        
    }
    public void CalcularCampeonTemporada(){
        
    }
    public void CalcularPosicionesEquipos(lequipos){
        
    }
    */
}   

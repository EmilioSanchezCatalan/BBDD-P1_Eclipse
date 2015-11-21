package practica1;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
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
    	lEquipos = new HashMap<Integer, Equipo>();
    	lJugadores = new HashMap<Integer, Jugador>();
    	lArbitros = new HashMap<Integer, Arbitro>();
    	lEstadios = new HashMap<Integer, Estadio>();
    	lpartidos = new ArrayList<Partido>();
    }
    public Equipo altaEquipo(){
    	Equipo e = new Equipo();
    	e.SetData();
    	return e;
    } 
    
    public void bajaEquipo(Equipo e){
    	lEquipos.remove(e.getIdequipo());
    	
    }
    
    public Jugador altaJugador(Equipo e){
       
        Jugador j = new Jugador(0,null);
        j.SetData();
        e.AltaJugador(j);
        
        return j;
     }
    
    public void bajaJugador(Jugador j){
    	    	
    	lJugadores.remove(j.getId());
    }
    
    public Arbitro altaArbitro(){
        Arbitro a = new Arbitro(0,null);
        a.SetData();
        return a;
    }
	
    public void bajaArbitro(Arbitro a){
    	lArbitros.remove(a.id);
    	
    }
    
    public Estadio altaEstadio(){
    	Estadio e = new Estadio();
    	e.SetData();
    	return e;
    }
    /*public Partido altaPartido(){
        
    }
    public boolean bajaPartido(){
        
    }*/
    public void listarEstadios(){
    	Collection <Estadio> e = new ArrayList<Estadio>();
    	e.addAll(lEstadios.values());
    	for (Estadio estadio:e){
    		System.out.println("------------------------------------------------------------");
    		System.out.println("id: "+estadio.getIdestadio());
    		System.out.println("direccion: "+estadio.getDireccion());
    		System.out.println("Ciudad: "+estadio.getCiudad());
    		System.out.println("Capacidad: "+estadio.getCapacidad());
    	}
    	
        
    }
    public void listarEquipos(){
    	Collection <Equipo> e = new ArrayList<Equipo>();
    	e.addAll(lEquipos.values());
    	for (Equipo equipos:e){
    		System.out.println("id: "+equipos.getIdequipo());
    		System.out.println("posicion: "+equipos.getPosicion());
    	}
    	
    }
    public void listarArbitros(){
    	Collection <Arbitro> a = new ArrayList<Arbitro>();
    	a.addAll(lArbitros.values());
    	for (Arbitro arbitros:a){
    		System.out.println("id: "+arbitros.getId());
    		System.out.println("nombre: "+arbitros.getNombre());
    		System.out.println("tipo: "+arbitros.getTipo());
    	}
    }
    /*
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
	public void setlEquipos(Equipo e) {
		lEquipos.put(e.getIdequipo(), e);
	}
	public void setlJugadores(Jugador j) {
		lJugadores.put(j.id, j);
	}
	public void setlArbitros(Arbitro a) {
		lArbitros.put(a.id, a);
	}
	public void setlEstadios(Estadio e) {
		
		lEstadios.put(e.getIdestadio(), e);
	}
	public void setLpartidos(Partido p) {
		lpartidos.add(p);
	}
	public Equipo getEquipo(int id){//metemos el id y devuelve el equipo
		return lEquipos.get(id);
	}
	public Jugador getJugador(int id){//metemos el id y devuelve el jugador
		return lJugadores.get(id);
	}
	public Arbitro getArbitros(int id){//metemos el id y devuelve el arbitro
		return lArbitros.get(id);		
	}
}   


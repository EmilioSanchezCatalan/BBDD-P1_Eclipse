package practica1;

import java.util.Scanner;

/**
 * 
 * @author Emilio y Noelia
 */
public class AppFutbolMenu {
	public static void main(String[] args) {
    	 int opcionw1; //opcion switch1
    	 do{
    		 System.out.println("Menu: Introduzca Opcion(0 para salir):");
    		 System.out.println("1:  Alta Equipo");
    		 System.out.println("2:  Baja Equipo");
    		 System.out.println("3:  Alta Jugador");
    		 System.out.println("4:  Baja Jugador");
    		 System.out.println("5:  Alta Arbitro");
    		 System.out.println("6:  Baja Arbitro");
    		 System.out.println("7:  Alta Estadio");
    		 System.out.println("8:  Alta Partido");
    		 System.out.println("9:  Baja Partido");
    		 System.out.println("10: Listar Equipo");
    		 System.out.println("11: Listar Estadios");
    		 System.out.println("12: Listar Arbitros");
    		 System.out.println("13: Devolver Total de Partidos");
    		 System.out.println("14: Listar Informacion de Partidos dada una fecha");
    		 System.out.println("15: Listar los partidos hechos por un equipo");
    		 System.out.println("16: Listar los jugadores que hay de una posicion");
    		 System.out.println("17: Listar los jugadores de un equipo y sus posiciones");
    		 System.out.println("18: Cargar Sistema");
    		 System.out.println("19: Salvar los datos");
    		 System.out.println("20: Calcular el campeón");
    		 System.out.println("21: Calcular posiciones");
    		 System.out.print("Opcion: ");

            Scanner scanf= new Scanner(System.in);
            opcionw1 = scanf.nextInt();

            //switch1
            switch (opcionw1){
            
            	case 1:
            		AppFutbol ap = new AppFutbol();
            		Jugador otro = new Jugador(0,null);
            		otro = ap.altaJugador();
            		otro.ListarJugador();
            		break;
            	default:
            		System.out.println("Opcion incorrecta");
                    break;
            }
        
        
        }while(opcionw1!=0);//fin switch1
        
    }
}

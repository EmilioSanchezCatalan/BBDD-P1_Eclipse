package practica1;

import java.util.Scanner;

/**
 * 
 * @author Emilio y Noelia
 */
public class AppFutbolMenu {
	public static void main(String[] args) {
		int opcionw1; // opción switch1
		int id;
		Scanner scanf = new Scanner(System.in);
		AppFutbol app = new AppFutbol();

		do {
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
			System.out
					.println("14: Listar Informacion de Partidos dada una fecha");
			System.out.println("15: Listar los partidos hechos por un equipo");
			System.out
					.println("16: Listar los jugadores que hay de una posicion");
			System.out
					.println("17: Listar los jugadores de un equipo y sus posiciones");
			System.out.println("18: Cargar Sistema");
			System.out.println("19: Salvar los datos");
			System.out.println("20: Calcular el campeon");
			System.out.println("21: Calcular posiciones");
			System.out.println("0: Salir");
			System.out.print("Opcion: ");

			opcionw1 = scanf.nextInt();

			// switch1
			switch (opcionw1) {
			case 0:
				System.out.println("Vuelva pronto!!! :-)");
				break;
			case 1:
				app.setlEquipos(app.altaEquipo());
				break;
			case 2:
				System.out.print("id del equipo: ");
				id = scanf.nextInt();
				app.bajaEquipo(id);
				break;
			case 3:
				System.out.print("id del equipo(en caso de que no tenga -1): ");
				id = scanf.nextInt();
				app.setlJugadores(id, app.altaJugador(id));
				break;
			case 4:
				System.out.print("id del jugador: ");
				app.bajaJugador(scanf.nextInt());
				break;
			case 5:
				//app.setlArbitros(app.altaArbitro());
				app.altaArbitro();
				break;
			case 6:
				System.out.print("id del arbitro: ");
				id = scanf.nextInt();
				app.bajaArbitro(id);
				break;
			case 7:
				app.setlEstadios(app.altaEstadio());
				break;
			case 8:
				app.setLpartidos(app.altaPartido());
				break;
			case 9:
				System.out.print("id del partido: ");
				app.bajaPartido(scanf.nextInt());
				break;
			case 10:
				app.listarEquipos();
				break;
			case 11:
				app.listarEstadios();
				break;
			case 12:
				app.listarArbitros();
				break;
			case 13:
				System.out.println("Numero total de partidos: "
						+ app.ContarPartidos());
				break;
			case 14:
				scanf.nextLine();
				System.out.print("fecha del partido: ");
				app.listarPartidos(scanf.nextLine());
				break;
			case 15:
				System.out.print("id del equipo: ");
				app.listarPartidos(scanf.nextInt());
				break;
			case 16:
				System.out.println("----------Posiciones---------");
				System.out.println("1.Portero");
				System.out.println("2.Defensa");
				System.out.println("3.Medio");
				System.out.println("4.Ataque");
				System.out.print("Posicion del Jugador: ");
				app.listarJugadores(app.posicionesj[(scanf.nextInt())-1]);
				break;
			case 17:
				System.out.print("id del equipo: ");
				app.listarJugadoresEquipo(scanf.nextInt());
				break;
			case 18:
				//app.CargarDatos();
				break;
			case 19:
				//app.Salvar();
				break;
			case 20:
				app.CalcularCampeonTemporada();
				break;
			case 21:
				System.out.print("id Equipo: ");
				System.out.println("Posicion: "+app.CalcularPosicionesEquipos(scanf.nextInt()));
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcionw1 != 0);// fin switch1
		scanf.close();
	}
}

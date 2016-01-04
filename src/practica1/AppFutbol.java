package practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

import practica1.ConexionBD;

/**
 *
 * @author Emilio y Noelia
 */
public class AppFutbol {
	final String posicionesj[] = { "Portero", "Defensa", "Medio", "Ataque" };
	final String tiposa[] = { "Principal", "Asistente" };
	private Map<Integer, Equipo> lEquipos; // el integer será el idequipo
	private Map<Integer, Jugador> lJugadores; // Integer será idjugador
	private Map<Integer, Arbitro> lArbitros; // ..igual
	private Map<Integer, Estadio> lEstadios; // ..igual
	private Collection<Partido> lpartidos;
	private boolean Error;
	private Scanner scanf = new Scanner(System.in);
	ConexionBD conn;

	public AppFutbol() {
		conn.getInstancia();
		lEquipos = new HashMap<Integer, Equipo>();
		lJugadores = new HashMap<Integer, Jugador>();
		lArbitros = new HashMap<Integer, Arbitro>();
		lEstadios = new HashMap<Integer, Estadio>();
		lpartidos = new ArrayList<Partido>();
	}

	public Equipo altaEquipo() {
		Equipo e = new Equipo();
		boolean existe = false;
		int auxi;
		System.out.print("id: ");
		auxi = scanf.nextInt();
		for (Equipo equipos : lEquipos.values()) {
			if (equipos.getIdequipo() == auxi) {
				Error = true;
			}
		}
		e.setIdequipo(auxi);
		scanf.nextLine();
		System.out.print("nombre: ");
		e.setNombre(scanf.nextLine());
		System.out.print("posicion de la liga(1|2): ");
		auxi = scanf.nextInt();
		if (auxi == 1 || auxi == 2) {
		} else {
			Error = true;
		}
		e.setPosicion(auxi);
		System.out.print("id de su estadio: ");
		auxi = scanf.nextInt();
		for (Estadio estadios : lEstadios.values()) {
			if (estadios.getIdestadio() == auxi) {
				existe = true;
			}
		}
		if (existe == false) {
			Error = true;
		}
		//e.AltaEstadio(lEstadios.get(auxi));
		//e.setPartidos_ganados(0);

		return e;
	}

	public void bajaEquipo(int id) {
		conn.getInstancia().ejecutar("DELETE FROM test.equipo WHERE ID = '"+ id +"';");
	}

	public Jugador altaJugador(int id) {
		Jugador j = new Jugador(0, null, null, null);
		int auxi;
		boolean existe = false;
		System.out.print("Id: ");
		auxi = scanf.nextInt();
		for (Jugador jugadores : lJugadores.values()) {
			if (auxi == jugadores.getId()) {
				Error = true;
			}
		}
		j.setId(auxi);
		scanf.nextLine();
		System.out.print("Nombre: ");
		j.setNombre(scanf.nextLine());
		System.out.print("Email: ");
		j.setEmail(scanf.nextLine());
		System.out.print("Tlf: ");
		j.setTlf(scanf.nextLine());
		System.out.print("Salario: ");
		auxi = scanf.nextInt();
		if (auxi <= 0) {
			Error = true;
		}
		j.setSalario(auxi);
		scanf.nextLine();
		System.out.println("---------Posiciones------");
		System.out.println("1.Portero");
		System.out.println("2.Defensa");
		System.out.println("3.Medio");
		System.out.println("4.Ataque");
		System.out.print("Posicion: ");
		auxi = scanf.nextInt();
		if (auxi < 1 || auxi > 4) {
			Error = true;
			auxi = 1;
		}
		j.setPosicion(posicionesj[auxi - 1]);
		scanf.nextLine();
		System.out.print("Titular[S/N]: ");
		if (scanf.nextLine().equalsIgnoreCase("s")) {
			j.setTitular(true);
		} else
			j.setTitular(false);
		System.out.print("Numero de Camiseta: ");
		j.setNum(scanf.nextInt());
		for (Equipo equipos : lEquipos.values()) {
			if (equipos.getIdequipo() == id) {
				existe = true;
			}
		}
		if (existe == false && id != -1) {
			Error = true;
		}
		return j;
	}

	public void bajaJugador(int idjugador) {
		conn.getInstancia().ejecutar("DELETE FROM test.jugador WHERE ID = '"+ idjugador +"';");
	}

	public Arbitro altaArbitro() {
		Arbitro a = new Arbitro(0, null, null, null,null);
		int auxi;
		System.out.print("id: ");
		int a1 = scanf.nextInt();
		scanf.nextLine();
		System.out.print("nombre: ");
		String a2 = scanf.nextLine();
		System.out.print("email: ");
		String a3 = scanf.nextLine();
		System.out.print("Tlf: ");
		String a4 = scanf.nextLine();
		System.out.println("------Tipos-----");
		System.out.println("1.Principal");
		System.out.println("2.Asistente");
		System.out.print("tipo: ");
		auxi = scanf.nextInt();
		if (auxi < 1 || auxi > 2) {
			Error = true;
			auxi = 2;
		}
		a.setTipo(tiposa[auxi - 1]);
		a = new Arbitro(a1,a2,a3,a4,tiposa[auxi - 1]);
		String cadena= "INSERT INTO test.arbitro (ID,NOMBRE,EMAIL,TLF,TIPO) VALUES ('"+a.getId()+"','"+a.getNombre()+"','"+a.getEmail()+"','"+a.getTlf()+"','"+a.getTipo()+"') ;";
		conn.getInstancia().ejecutar(cadena);
		return a;
	}

	public void bajaArbitro(int id) {
		
		conn.getInstancia().ejecutar("DELETE FROM test.arbitro WHERE ID = '"+ id +"';");
	}

	public Estadio altaEstadio() {
		Estadio e = new Estadio();
		int auxi;
		System.out.print("id: ");
		auxi = scanf.nextInt();
		for (Estadio estadios : lEstadios.values()) {
			if (estadios.getIdestadio() == auxi) {
				Error = true;
			}
		}
		e.setIdestadio(auxi);
		scanf.nextLine();
		System.out.print("nombre: ");
		e.setNombre(scanf.nextLine());
		System.out.print("direccion: ");
		e.setDireccion(scanf.nextLine());
		System.out.print("ciudad: ");
		e.setCiudad(scanf.nextLine());
		System.out.print("capacidad: ");
		auxi = scanf.nextInt();
		if (auxi <= 0) {
			Error = true;
		}
		e.setCapacidad(auxi);
		return e;
	}

	public Partido altaPartido() {
		Partido p = new Partido();
		int cont, auxi;
		boolean existe = false;
		System.out.print("id: ");
		auxi = scanf.nextInt();
		for (Partido partidos : lpartidos) {
			if (partidos.getIdpartido() == auxi) {
				Error = true;
			}
		}
		p.setIdpartido(auxi);
		System.out.print("id del Estadio: ");
		auxi = scanf.nextInt();
		for (Estadio estadios : lEstadios.values()) {
			if (estadios.getIdestadio() == auxi) {
				existe = true;
			}
		}
		if (existe == false) {
			Error = true;
		} else {
			existe = false;
			p.setE(lEstadios.get(auxi));
		}

		scanf.nextLine();
		System.out.print("Fecha[xx/xx/yyyy]: ");
		p.setX(scanf.nextLine());
		System.out.print("id del equipo1 :");
		auxi = scanf.nextInt();
		for (Equipo equipos : lEquipos.values()) {
			if (equipos.getIdequipo() == auxi) {
				existe = true;
			}
		}
		if (existe == false) {
			Error = true;
		} else {
			existe = false;
			p.setEq1(lEquipos.get(auxi));
		}
		System.out.print("id del equipo2 :");
		auxi = scanf.nextInt();
		for (Equipo equipos : lEquipos.values()) {
			if (equipos.getIdequipo() == auxi) {
				existe = true;
			}
		}
		if (existe == false) {
			Error = true;
		} else {
			existe = false;
			p.setEq2(lEquipos.get(auxi));
		}

		scanf.nextLine();
		System.out.print("Es[ida/vuelta]: ");
		if (scanf.nextLine().equalsIgnoreCase("ida")) {
			p.setIda(true);
		} else
			p.setIda(false);
		System.out.print("Numero de arbitros: ");
		cont = scanf.nextInt();
		for (int i = 0; i < cont; i++) {
			System.out.print("id del arbitro " + (i + 1) + ": ");
			p.setLarbitros(lArbitros.get(scanf.nextInt()));
		}
		p.setLeq1(p.getEq1().ljuga);
		p.setLeq2(p.getEq2().ljuga);
		System.out.print("goles del equipo1: ");
		auxi = scanf.nextInt();
		if (auxi <= 0) {
			Error = true;
		}
		p.setGolesA(auxi);
		System.out.print("goles del equipo2: ");
		auxi = scanf.nextInt();
		if (auxi <= 0) {
			Error = true;
		}
		p.setGolesB(auxi);
		if (p.getGolesA() > p.getGolesB() && Error == false) {
			lEquipos.get(p.getEq1().getIdequipo()).setPartidos_ganados(
					lEquipos.get(p.getEq1().getIdequipo())
							.getPartidos_ganados() + 1);
		} else if (p.getGolesA() < p.getGolesB() && Error == false) {
			lEquipos.get(p.getEq2().getIdequipo()).setPartidos_ganados(
					lEquipos.get(p.getEq2().getIdequipo())
							.getPartidos_ganados() + 1);
		}
		return p;

	}

	public void bajaPartido(int idpartido) {
		conn.getInstancia().ejecutar("DELETE FROM test.partido WHERE ID = '"+ idpartido +"';");

	}

	public void listarEstadios() {
		System.out.println("ID - Nombre - Direccion - Ciudad - Capacidad");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, NOMBRE, DIRECCION, CIUDAD, Capacidad FROM test.estadio ;");	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarEquipos() {

		System.out.println("ID - Nombre - Estadio - Posicion");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, NOMBRE, ESTADIO, POSICION FROM test.equipo ;");	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarArbitros() {
		
		System.out.println("ID - Nombre - Email - Tlf - Tipo");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, NOMBRE, EMAIL, TLF, TIPO FROM test.arbitro ;");	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4) + " - " + rs.getString (5)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int ContarPartidos() {
		int Contador = 0;
		for (int i = 0; i < lpartidos.size(); i++) {
			Contador++;
		}
		return Contador;
	}

	void listarPartidos(String fecha) {
		System.out.println("ID - Estadio - Fecha - Equipo1 - Equipo2 - Ida - Goles1 -Goles2");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, ESTADIO, FECHA, EQUIPO1, EQUIPO2, IDA, GOLES1, GOLES2 FROM test.partido WHERE fecha = '"+ fecha +"';");	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	void listarPartidos(int idequipo) {
		System.out.println("ID - Estadio - Fecha - Equipo1 - Equipo2 - Ida - Goles1 -Goles2");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, ESTADIO, FECHA, EQUIPO1, EQUIPO2, IDA, GOLES1, GOLES2 FROM test.partido WHERE EQUIPO1 = '"+ idequipo +"' || EQUIPO2 = '"+ idequipo +"';" );	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4)+ " - " + rs.getString (5) + " - " + rs.getString (6) + " - " + rs.getString (7) + " - " +rs.getString(8)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void listarJugadores(String posicion) {

		System.out.println("ID - Nombre - Email - TLF - Salario - Posicion - Titular - Num - Equipo");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, NOMBRE, EMAIL, TLF, SALARIO, POSICION, TITULAR, NUM, EQUIPO FROM test.jugador WHERE posicion = '"+ posicion +"';");	
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4) + " - " + rs.getString (5) + " - " + rs.getString (6) + " - " + rs.getString (7)+ rs.getString (8) + " - " + rs.getString (9)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void listarJugadoresEquipo(int idequipo) {
		
		System.out.println("ID - Nombre - Email - TLF - Salario - Posicion - Titular - Num - Equipo");
		ResultSet rs=conn.getInstancia().ejecutarConsulta("SELECT ID, NOMBRE, EMAIL, TLF, SALARIO, POSICION, TITULAR, NUM, EQUIPO FROM test.jugador WHERE equipo = '"+ idequipo+"';");
		try {
			while (rs.next()) 
			{ 
			    System.out.println (rs.getString (1) + " - " + rs.getString (2) + " - " + rs.getString (3) + " - " + rs.getString (4) + " - " + rs.getString (5) + " - " + rs.getString (6) + " - " + rs.getString (7)+ rs.getString (8) + " - " + rs.getString (9)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	public void Salvar() {
		boolean ninguno = true;
		try {

			// Guardando Equipos
			BufferedWriter b = new BufferedWriter(
					new FileWriter("lEquipos.csv"));
			Collection<Equipo> e = new ArrayList<Equipo>();
			e.addAll(lEquipos.values());
			b.write("idequipo;nombre;idestadio;posicion;ganados");
			b.newLine();
			for (Equipo equipo : e) {

				b.write(new Integer(equipo.getIdequipo()).toString());
				b.write(";" + equipo.getNombre());
				b.write(";" + new Integer(equipo.getEsta()).toString());
				b.write(";" + new Integer(equipo.getPosicion()).toString());
				b.write(";"
						+ new Integer(equipo.getPartidos_ganados()).toString());
				b.newLine();
			}
			b.close();

			// Guardando Estadios
			b = new BufferedWriter(new FileWriter("lEstadios.csv"));
			Collection<Estadio> es = new ArrayList<Estadio>();
			es.addAll(lEstadios.values());
			b.write("idestadio;nombre;direccion;ciudad;capacidad");
			b.newLine();
			for (Estadio estadio : es) {
				b.write(new Integer(estadio.getIdestadio()).toString());
				b.write(";" + estadio.getNombre());
				b.write(";" + estadio.getDireccion());
				b.write(";" + estadio.getCiudad());
				b.write(";" + new Integer(estadio.getCapacidad()).toString());
				b.newLine();
			}
			b.close();

			// Guardando Jugadores
			b = new BufferedWriter(new FileWriter("lJugadores.csv"));
			Collection<Jugador> j = new ArrayList<Jugador>();
			j.addAll(lJugadores.values());
			b.write("id;nombre;email;Tlf;salario;posicion;titular;num;idequipo");
			b.newLine();
			for (Jugador jugador : j) {
				ninguno = true;
				b.write(new Integer(jugador.getId()).toString());
				b.write(";" + jugador.getNombre());
				b.write(";" + jugador.getEmail());
				b.write(";" + jugador.getTlf());
				b.write(";" + jugador.getSalario());
				b.write(";" + jugador.getPosicion());
				b.write(";" + new Boolean(jugador.getTitular()).toString());
				b.write(";" + new Integer(jugador.getNum()).toString());
				for (Equipo equipo : e) {
					if (equipo.Pertenecia(jugador) == true) {
						b.write(";"
								+ new Integer(equipo.getIdequipo()).toString());
						ninguno = false;
					}
				}
				if (ninguno == true) {
					b.write(";-1");
				}
				b.newLine();
			}
			b.close();

			// Guardando Arbitros
			b = new BufferedWriter(new FileWriter("lArbitros.csv"));
			Collection<Arbitro> a = new ArrayList<Arbitro>();
			a.addAll(lArbitros.values());
			b.write("id;nombre;email;Tlf;tipo");
			b.newLine();
			for (Arbitro arbitro : a) {
				b.write(new Integer(arbitro.getId()).toString());
				b.write(";" + arbitro.getNombre());
				b.write(";" + arbitro.getEmail());
				b.write(";" + arbitro.getTlf());
				b.write(";" + arbitro.getTipo());
				b.newLine();
			}
			b.close();

			// Guardando Partidos
			b = new BufferedWriter(new FileWriter("lPartidos.csv"));
			b.write("id;idestadio;X;idequipo1;idequipo2;ida;golesA;golesB");
			b.newLine();
			for (Partido partidos : lpartidos) {
				b.write(new Integer(partidos.getIdpartido()).toString());
				b.write(";"
						+ new Integer(partidos.getE().getIdestadio())
								.toString());
				b.write(";" + partidos.getX());
				b.write(";"
						+ new Integer(partidos.getEq1().getIdequipo())
								.toString());
				b.write(";"
						+ new Integer(partidos.getEq2().getIdequipo())
								.toString());
				b.write(";" + new Boolean(partidos.isIda()).toString());
				b.write(";" + new Integer(partidos.getGolesA()).toString());
				b.write(";" + new Integer(partidos.getGolesB()).toString());
				b.newLine();
			}
			b.close();

			// Guardando Partidos.Arbitros
			b = new BufferedWriter(new FileWriter("Partidos.Arbitros.csv"));
			b.write("idpartidos;idarbitros");
			b.newLine();
			for (Partido partidos : lpartidos) {
				for (Arbitro arbitros : partidos.getLarbitros()) {
					b.write(new Integer(partidos.getIdpartido()).toString());
					b.write(";" + new Integer(arbitros.getId()).toString());
					b.newLine();
				}
			}
			b.close();

		} catch (IOException e) {
			System.out.println("ERROR NO SE HA PODIDO SAlVAR EL ARCHIVO");
		}

	}

	public void CargarDatos() {
		try {
			String linea;
			String linea_formateada[];
			BufferedReader b;

			// lee Los estadios
			b = new BufferedReader(new FileReader("lEstadios.csv"));
			b.readLine();
			do {
				Estadio es = new Estadio();

				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					es.setIdestadio(Integer.parseInt(linea_formateada[0]));
					es.setNombre(linea_formateada[1]);
					es.setDireccion(linea_formateada[2]);
					es.setCiudad(linea_formateada[3]);
					es.setCapacidad(Integer.parseInt(linea_formateada[4]));
					lEstadios.put(es.getIdestadio(), es);
				}
			} while (linea != null);
			b.close();

			// lee los equipos
			b = new BufferedReader(new FileReader("lEquipos.csv"));
			b.readLine();
			do {
				Equipo e = new Equipo();

				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					e.setIdequipo(Integer.parseInt(linea_formateada[0]));
					e.setNombre(linea_formateada[1]);
					e.setEsta(lEstadios.get(Integer
							.parseInt(linea_formateada[2])));
					e.setPosicion(Integer.parseInt(linea_formateada[3]));
					e.setPartidos_ganados(Integer.parseInt(linea_formateada[4]));
					lEquipos.put(e.getIdequipo(), e);
				}
			} while (linea != null);
			b.close();

			// lee los jugadores
			b = new BufferedReader(new FileReader("lJugadores.csv"));
			b.readLine();
			do {
				Jugador j = new Jugador(0, null, null, null);

				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					j.setId(Integer.parseInt(linea_formateada[0]));
					j.setNombre(linea_formateada[1]);
					j.setEmail(linea_formateada[2]);
					j.setTlf(linea_formateada[3]);
					j.setSalario(Integer.parseInt(linea_formateada[4]));
					j.setPosicion(linea_formateada[5]);
					j.setTitular(Boolean.parseBoolean((linea_formateada[6])));
					j.setNum(Integer.parseInt(linea_formateada[7]));
					if (Integer.parseInt(linea_formateada[8]) != -1) {
						lEquipos.get(Integer.parseInt(linea_formateada[8]))
								.AltaJugador(j);
					}

					lJugadores.put(j.getId(), j);

				}
			} while (linea != null);
			b.close();

			// lee los partidos
			b = new BufferedReader(new FileReader("lPartidos.csv"));
			b.readLine();
			do {
				Partido p = new Partido();

				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					p.setIdpartido(Integer.parseInt(linea_formateada[0]));
					p.setE(lEstadios.get(Integer.parseInt(linea_formateada[1])));
					p.setX(linea_formateada[2]);
					p.setEq1(lEquipos.get(Integer.parseInt(linea_formateada[3])));
					p.setLeq1(lEquipos.get(Integer
							.parseInt(linea_formateada[3])).ljuga);
					p.setEq2(lEquipos.get(Integer.parseInt(linea_formateada[4])));
					p.setLeq2(lEquipos.get(Integer
							.parseInt(linea_formateada[4])).ljuga);
					p.setIda(Boolean.parseBoolean(linea_formateada[5]));
					p.setGolesA(Integer.parseInt(linea_formateada[6]));
					p.setGolesB(Integer.parseInt(linea_formateada[7]));
					lpartidos.add(p);
				}
			} while (linea != null);
			b.close();

			// lee los arbitros
			b = new BufferedReader(new FileReader("lArbitros.csv"));
			b.readLine();
			do {
				Arbitro a = new Arbitro(0, null, null, null,null);

				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					a.setId(Integer.parseInt(linea_formateada[0]));
					a.setNombre(linea_formateada[1]);
					a.setEmail(linea_formateada[2]);
					a.setTlf(linea_formateada[3]);
					a.setTipo(linea_formateada[4]);
					lArbitros.put(a.getId(), a);
				}
			} while (linea != null);
			b.close();

			// lee partidos.arbitros
			b = new BufferedReader(new FileReader("Partidos.Arbitros.csv"));
			b.readLine();
			do {
				linea = b.readLine();
				if (linea != null) {
					linea_formateada = linea.split(";");
					for (Partido partidos : lpartidos) {
						if (partidos.getIdpartido() == Integer
								.parseInt(linea_formateada[0])) {
							partidos.setLarbitros(lArbitros.get(Integer
									.parseInt(linea_formateada[1])));
						}
					}
				}

			} while (linea != null);
		} catch (IOException e) {
			System.out.println("ERROR NO SE HA PODIDO CARGAR EL ARCHIVO");
		}
	}

	*/
	public void CalcularCampeonTemporada() {
		Equipo campeon1 = new Equipo();
		Equipo campeon2 = new Equipo();
		int maximo_ganados1 = 0, maximo_ganados2 = 0;
		Collection<Equipo> e = new ArrayList<Equipo>();
		e.addAll(lEquipos.values());
		for (Equipo equipos : e) {
			if (equipos.getPosicion() == 1
					&& maximo_ganados1 < equipos.getPartidos_ganados()) {
				maximo_ganados1 = equipos.getPartidos_ganados();
				campeon1 = equipos;
			}
			if (equipos.getPosicion() == 2
					&& maximo_ganados2 < equipos.getPartidos_ganados()) {
				maximo_ganados2 = equipos.getPartidos_ganados();
				campeon2 = equipos;
			}

		}
		System.out
				.println("----------Equipo Campeon de la liga de primera---------------");
		System.out.println("id: " + campeon1.getIdequipo());
		System.out.println("nombre: " + campeon1.getNombre());
		System.out
				.println("----------Equipo Campeon de la liga de primera---------------");
		System.out.println("id: " + campeon2.getIdequipo());
		System.out.println("nombre: " + campeon2.getNombre());
	}

	public int CalcularPosicionesEquipos(int idequipo) {
		int cont = 0;
		Collection<Equipo> e = new ArrayList<Equipo>();
		e.addAll(lEquipos.values());
		for (Equipo equipos : e) {
			if (lEquipos.get(idequipo).getPartidos_ganados() >= equipos
					.getPartidos_ganados()) {
				cont++;
			}
		}
		return (lEquipos.size() + 1 - cont);

	}

	public void setlEquipos(Equipo e) {
		if (Error == true) {
			System.out.println("Ha habido un error al dar de alta");
			Error = false;
		} else {
			lEquipos.put(e.getIdequipo(), e);
		}

	}

	public void setlJugadores(int id, Jugador j) {
		if (Error == true) {
			System.out.println("Ha habido un error al dar de alta");
			Error = false;
		} else {
			if (id != -1) {
				lEquipos.get(id).AltaJugador(j);

			}
			lJugadores.put(j.getId(), j);
		}

	}

	public void setlArbitros(Arbitro a) {
		if (Error == true) {
			System.out.println("Ha habido un error al dar de alta");
			Error = false;
		} else {
			lArbitros.put(a.getId(), a);
		}

	}

	public void setlEstadios(Estadio e) {
		if (Error == true) {
			System.out.println("Ha habido un error al dar de alta");
			Error = false;
		} else {
			lEstadios.put(e.getIdestadio(), e);
		}

	}

	public void setLpartidos(Partido p) {
		if (Error == true) {
			System.out.println("Ha habido un error al dar de alta");
			Error = false;
		} else {
			lpartidos.add(p);
		}

	}
}

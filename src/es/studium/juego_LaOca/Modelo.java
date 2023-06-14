package es.studium.juego_LaOca;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Modelo
{
	// En esta clase todo lo relacionado a la conexión con la base de datos.
	// Y la lógica.

	// Constructor para luego crear objetos de esta clase.
	// Para conectar JAVA con MYSQL.
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/la_oca"; // Aquí nombre de la base de datos.
	String login = "eva";
	String password = "eva";
	String sentencia = ""; // Vacío para que sirva para otros elementos luego, se ve en toda la clase.

	Connection connection = null; // Objeto "connection", para conectarnos a la base de datos.
	Statement statement = null; // Objeto, permite ejecutar sentencias SQL.
	ResultSet rs = null; // Objeto, para guardar toda la información que nos devuelve la base de datos.

	int i;
	
	public Modelo()
	{
		connection = this.conectar();
	}

	
	// Método CONECTAR.
	public Connection conectar()
	{
		// Aquí la conexión con la base de datos.
		try
		{
			// Cargar los controladores para el acceso a la BD.
			Class.forName(driver);

			// Aquí se conectan.
			// Establecer la conexión con la BD Empresa.
			return (DriverManager.getConnection(url, login, password)); // Devolver un objeto de la clase conexión.
		}

		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-" + cnfe.getMessage());
		}

		catch (SQLException sqle)
		{
			System.out.println("Error 2-" + sqle.getMessage());
		}
		
		return null; // Si no conseguimos conectarnos, no devuelve una conexión nula, no se conecta.
	}
	
	
	
	//Aleatorio
	public int aleatorio()
	{
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(6)+1;
		
		return numero;
	}
	
	
	
	//Reproducir sonido dado
	public void reproducirSonido()
	{
		//Primero guardar el archivo de sonido en una carpeta
		File sf = new File("sonido\\dado.wav");

	    AudioFileFormat aff;
	    AudioInputStream ais;

	    try 
	    {
	    	aff = AudioSystem.getAudioFileFormat(sf);
	        ais = AudioSystem.getAudioInputStream(sf);

	        AudioFormat af = aff.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(),((int) ais.getFrameLength() * af.getFrameSize()));

	        Clip ol = (Clip) AudioSystem.getLine(info);
	        ol.open(ais);
	        ol.loop(1); //Se reproduce una vez.

	        Thread.sleep(1000); 

	        ol.close();
	    } 
	    
	    catch (UnsupportedAudioFileException ee) 
	    {
	    	System.out.println(ee.getMessage());
	    }
	    catch (IOException ea) 
	    {
	        System.out.println(ea.getMessage());
	    } 
	    catch (LineUnavailableException LUE)
	    {
	    	System.out.println(LUE.getMessage());
		}    
	    catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	//Ranking: consultar
	public String[][] rellenarRanking()
	{
		String ranking [][] = new String[10][2]; 
		i=0;
		
		sentencia = "SELECT nombreJugador, tiradasJugador FROM jugadores ORDER BY tiradasJugador ASC LIMIT 10;";
		
		//Hacer la consulta SELECT pero desde JAVA. 
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
			// Crear un objeto ResultSet para guardar lo obtenido
			// y ejecutar la sentencia SQL.
			
			rs = statement.executeQuery(sentencia); //Donde está toda la información "rs".
			
			//"append": para añadir.
			while (rs.next())
			{
	            ranking[i][0] = rs.getString("nombreJugador");
	            ranking[i][1] = rs.getString("tiradasJugador");
	            
	            i++;
			}
		}	
		
		catch (SQLException sqle) 
		{
			System.out.println("Error 3-"+sqle.getMessage());
		}
		
		return ranking;
	}
		
	
	
	//Insertar ganador
	public void insertarJugador( String nombre, int tiradas)
	{
		sentencia = "INSERT INTO jugadores VALUES(null, '"+nombre+"',"+tiradas+");";
		
		//Hacer la consulta SELECT pero desde JAVA. 
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
			// Crear un objeto ResultSet para guardar lo obtenido
			// y ejecutar la sentencia SQL.
			
			statement.executeUpdate(sentencia); //Donde está toda la información "rs".
		}	
		
		catch (SQLException sqle) 
		{
			System.out.println("Error 4-"+sqle.getMessage());
		}
	}
}
	
	

	
	/* Para comprobar que se realiza la conexión con la base de datos.
	
	public static void main(String[] args)
	{
		Modelo modelo = new Modelo();
		
		if(modelo.conectar() != null
		{
			System.out.println("Conexión realizada a la base de datos");
		}
		else
		{
			System.out.println("Error al conectar a la base de datos");
		}
	}
	
	*/


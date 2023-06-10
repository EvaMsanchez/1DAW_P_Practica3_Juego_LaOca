package es.studium.juego_LaOca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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


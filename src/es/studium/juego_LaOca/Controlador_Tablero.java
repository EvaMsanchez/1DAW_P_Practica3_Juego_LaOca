package es.studium.juego_LaOca;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador_Tablero implements WindowListener
{
	Modelo modelo;
	Tablero tablero;
	
	public Controlador_Tablero(Modelo m, Tablero t)
	{
		this.modelo = m;
		this.tablero = t;
		
		//Añadir Listeners
		this.tablero.addWindowListener(this); //También se puede por nj en vez de numeroJugadores.
		//Botones
	

	}

	
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0); //Para cerrar la ventana con la "X". 
	}
	@Override
	public void windowClosed(WindowEvent e){}
	@Override
	public void windowIconified(WindowEvent e){}
	@Override
	public void windowDeiconified(WindowEvent e){}
	@Override
	public void windowActivated(WindowEvent e){}
	@Override
	public void windowDeactivated(WindowEvent e){}


	
}

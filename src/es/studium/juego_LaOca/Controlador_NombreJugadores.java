package es.studium.juego_LaOca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador_NombreJugadores implements WindowListener, ActionListener
{
	Modelo modelo;
	NombreJugadores nombreJugadores;
	
	public Controlador_NombreJugadores(Modelo m, NombreJugadores nomj)
	{
		this.modelo = m;
		this.nombreJugadores = nomj;
		
		//Añadir Listeners
		this.nombreJugadores.ventana.addWindowListener(this); //También se puede por nj en vez de numeroJugadores.
		//Botones	
		this.nombreJugadores.btnAtras.addActionListener(this);
		this.nombreJugadores.btnComenzar.addActionListener(this);
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


	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Pulsamos ATRÁS.
		if(e.getSource().equals(nombreJugadores.btnAtras))
		{
			nombreJugadores.ventana.setVisible(false);
		}
		
		//Pulsamos COMENZAR.
		else if(e.getSource().equals(nombreJugadores.btnComenzar))
		{
			new TableroJuego();
		}
	}
}

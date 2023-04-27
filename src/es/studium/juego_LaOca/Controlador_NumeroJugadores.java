package es.studium.juego_LaOca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador_NumeroJugadores implements WindowListener, ActionListener
{
	Modelo modelo;
	NumeroJugadores numeroJugadores;
	
	public Controlador_NumeroJugadores(Modelo m, NumeroJugadores numj)
	{
		this.modelo = m;
		this.numeroJugadores = numj;
		
		//Añadir Listeners
		this.numeroJugadores.ventana.addWindowListener(this); //También se puede por nj en vez de numeroJugadores.
		//Botones
		this.numeroJugadores.btn2Jugadores.addActionListener(this);
		this.numeroJugadores.btn3Jugadores.addActionListener(this);
		this.numeroJugadores.btn4Jugadores.addActionListener(this);
		
		this.numeroJugadores.btnAtras.addActionListener(this);
		//this.numeroJugadores.btnContinuar.addActionListener(this);
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
		//Como en la clase Principal del main.
		NombreJugadores nombreJugadores = new NombreJugadores();
		new Controlador_NombreJugadores(modelo, nombreJugadores);
		
		//Pulsamos ATRÁS.
		if(e.getSource().equals(numeroJugadores.btnAtras))
		{
			numeroJugadores.ventana.setVisible(false);
		}
		
		//Pulsamos 2JUGADORES.
		else if(e.getSource().equals(numeroJugadores.btn2Jugadores))
		{
	        nombreJugadores.ventana.setVisible(true);
			
	        nombreJugadores.txtJugador1.setEnabled(true);
	        nombreJugadores.txtJugador2.setEnabled(true);
	        nombreJugadores.txtJugador3.setEnabled(false);
	        nombreJugadores.txtJugador4.setEnabled(false);
		}
		
		//Pulsamos 3JUGADORES.
		else if(e.getSource().equals(numeroJugadores.btn3Jugadores))
		{
			nombreJugadores.ventana.setVisible(true);
			
			nombreJugadores.txtJugador1.setEnabled(true);
	        nombreJugadores.txtJugador2.setEnabled(true);
	        nombreJugadores.txtJugador3.setEnabled(true);
	        nombreJugadores.txtJugador4.setEnabled(false);
		}
		
		//Pulsamos 4JUGADORES.
		else if(e.getSource().equals(numeroJugadores.btn4Jugadores))
		{
			nombreJugadores.ventana.setVisible(true);
			
			nombreJugadores.txtJugador1.setEnabled(true);
	        nombreJugadores.txtJugador2.setEnabled(true);
	        nombreJugadores.txtJugador3.setEnabled(true);
	        nombreJugadores.txtJugador4.setEnabled(true);
		}
	}
}

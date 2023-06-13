package es.studium.juego_LaOca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class Controlador_MenuPrincipal implements WindowListener, ActionListener
{
	Modelo modelo;
	MenuPrincipal menuPrincipal;
	
	public Controlador_MenuPrincipal(Modelo m, MenuPrincipal mp)
	{
		this.modelo = m;
		this.menuPrincipal = mp;
		
		//Añadir Listeners
		this.menuPrincipal.addWindowListener(this); //También se puede por mp en vez de menuPrincipal.
		//Botones
		this.menuPrincipal.btnIniciarPartida.addActionListener(this);
		this.menuPrincipal.btnRanking.addActionListener(this);
		this.menuPrincipal.btnAyuda.addActionListener(this);
		this.menuPrincipal.btnSalir.addActionListener(this);
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
		//Pulsamos INICIAR PARTIDA.
		if(e.getSource().equals(menuPrincipal.btnIniciarPartida))
		{
			//Como en la clase Principal del main.
			NumeroJugadores numeroJugadores = new NumeroJugadores();
			new Controlador_NumeroJugadores(modelo, numeroJugadores, menuPrincipal);
			
	        numeroJugadores.ventana.setVisible(true);
		}
		
		//Pulsamos RANKING.
		else if(e.getSource().equals(menuPrincipal.btnRanking))
		{
			Ranking ranking = new Ranking();
			new Controlador_Ranking(modelo, ranking);
			
	        ranking.setVisible(true);
		}
		
		//Pulsamos AYUDA.
		else if(e.getSource().equals(menuPrincipal.btnAyuda))
		{
			try 
			{
				Runtime.getRuntime().exec("hh.exe Ayuda Oca.chm");
			}
			catch (IOException ee) 
			{
				ee.printStackTrace();
			}
		}
		
		//Pulsamos SALIR.
		else if(e.getSource().equals(menuPrincipal.btnSalir))
		{
			menuPrincipal.setVisible(false);
		}
	}
}

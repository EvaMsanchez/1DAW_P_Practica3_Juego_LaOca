package es.studium.juego_LaOca;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador_Ranking implements WindowListener
{
	Modelo modelo;
	Ranking ranking;
	
	public Controlador_Ranking(Modelo m, Ranking r)
	{
		this.modelo = m;
		this.ranking = r;
		
		//Añadir Listeners
		this.ranking.addWindowListener(this); 
		
		String[][] resultadoRanking = modelo.rellenarRanking();
		
		ranking.recibirRanking(resultadoRanking);
	}

	
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		if(ranking.isActive())
		{
			ranking.setVisible(false);
		}
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

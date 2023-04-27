package es.studium.juego_LaOca;

import java.awt.Frame;
import java.awt.Label;

public class Ranking
{
	Frame ventana = new Frame("La Oca: Ranking");
	
	Label lblTop10 = new Label("TOP 10");
	
	public Ranking()
	{
		ventana.setLayout(null);
		//setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB.
		ventana.setSize(430, 335);
		
		
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}

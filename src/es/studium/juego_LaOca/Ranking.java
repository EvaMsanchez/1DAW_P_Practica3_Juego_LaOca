package es.studium.juego_LaOca;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class Ranking extends Frame
{
	private static final long serialVersionUID = 1L; //Por haber heredado de la clase Frame.
	
	Label lblTop = new Label("TOP 10");
	
	String[][] resultadoRanking ;
	
	//Objeto para manipulación de imágenes
	Toolkit herramienta;
	
	Image oro, plata, bronce;
	
	public Ranking()
	{
		setLayout(null);
		//setBackground(Color.decode("#E1E7E5")); //"decode": para personalizar el color en RGB.
		setSize(300, 450);
		
		// Crear una nueva fuente con el tamaño.
        Font font = new Font("Broadway", Font.BOLD, 18);
        // Establecer la fuente en el JLabel
        lblTop.setFont(font);
		
		lblTop.setBounds(105, 30, 80, 50);
		add(lblTop);
		

		//Activamos la herramienta
		herramienta = getToolkit();
		//Cargar imagen
		oro = herramienta.getImage("img/oro.png");
		plata = herramienta.getImage("img/plata.png");
		bronce = herramienta.getImage("img/bronce.png");
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	public void paint(Graphics g)
	{
		Font font = new Font("SansSerif", Font.PLAIN, 15);
		g.setFont(font);
		
		int xt = 200;
		int x = 80;
		int y = 100;
		
		for (int i = 0; i<resultadoRanking.length; i++)
		{
	        String nombreJugador = resultadoRanking[i][0];
	        String tiradasJugador = resultadoRanking[i][1];
	        
	        // Dibujar el nombre del jugador y sus tiradas en la posición actual
	        g.drawString(nombreJugador, x, y);
	        g.drawString(tiradasJugador, xt, y);
	        
	        // Incrementar las coordenadas para la siguiente posición
	        y += 35; 
		}
		
		//Dibujar la imagen
		g.drawImage(oro, 35, 75, this);
		g.drawImage(plata, 35, 112, this);
		g.drawImage(bronce, 35, 150, this);
	}
	
	
	
	public void recibirRanking(String[][] r)
	{
		resultadoRanking = r;
		
		repaint();
	}
	
	/*public static void main(String[] args)
	{
		new Ranking();
	}*/
}

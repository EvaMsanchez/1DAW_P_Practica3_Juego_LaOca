package es.studium.juego_LaOca;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Tablero extends Frame //Hereda de Frame.
{
	private static final long serialVersionUID = 1L; //Por haber heredado de la clase Frame.
	
	//Objetos que contienen imágenes
	Image imagenTablero;
	Image imagenDado;
	Image imagenFichas;
	Image imagenTurno;
	//Objeto para manipulación de imágenes
	Toolkit herramienta;
	
	Button btnFinalizarPartida = new Button("Finalizar Partida");
	
	public Tablero()
	{
		setLayout(null);
		setTitle("La Oca: Juego");
		//setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB. FFFFD3 - C5E3E1
		setSize(1280, 670);
		
		//Activamos la herramienta
		herramienta = getToolkit();
		//Cargar la imagen
		imagenTablero = herramienta.getImage("tableroOca.png");
		imagenDado = herramienta.getImage("");
		imagenFichas = herramienta.getImage("");
		imagenTurno = herramienta.getImage("");
		
		
		btnFinalizarPartida.setBounds(110, 620, 120, 30);
		add(btnFinalizarPartida);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//Dibujar la imagen
		g.drawImage(imagenTablero, 349, 10, this);
		g.drawImage(imagenDado, 58, 66, this);
		g.drawImage(imagenFichas, 58, 66, this);
		g.drawImage(imagenTurno, 58, 66, this);
	}
	
	
	/*public static void main(String[] args)
	{
		new Tablero();
	}
	*/
}

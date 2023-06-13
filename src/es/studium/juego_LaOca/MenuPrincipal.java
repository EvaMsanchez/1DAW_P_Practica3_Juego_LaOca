package es.studium.juego_LaOca;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MenuPrincipal extends Frame //Hereda de Frame.
{
	private static final long serialVersionUID = 1L; //Por haber heredado de la clase Frame.
	
	//Objetos que contienen imágenes
	Image imagenOca;
	//Objeto para manipulación de imágenes
	Toolkit herramienta;
	
	Button btnIniciarPartida = new Button("Iniciar Partida");
	Button btnAyuda = new Button("Ayuda");
	Button btnRanking = new Button("Ranking");
	Button btnSalir = new Button("Salir");
	
	public MenuPrincipal()
	{
		setLayout(null);
		setTitle("Juego - La Oca");
		setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB. FFFFD3 - C5E3E1
		setSize(550, 357);
		
		//Activamos la herramienta
		herramienta = getToolkit();
		//Cargar la imagen
		imagenOca = herramienta.getImage("img/ocaPrincipal.png");
		
		btnIniciarPartida.setBounds(370, 100, 120, 30);
		add(btnIniciarPartida);
		btnAyuda.setBounds(370, 200, 120, 30);
		add(btnAyuda);
		btnRanking.setBounds(370, 150, 120, 30);
		add(btnRanking);
		btnSalir.setBounds(370, 250, 120, 30);
		add(btnSalir);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//Dibujar la imagen
		g.drawImage(imagenOca, 58, 66, this);
	}
}

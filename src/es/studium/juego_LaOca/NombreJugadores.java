package es.studium.juego_LaOca;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class NombreJugadores
{
	Frame ventana = new Frame("La Oca: Nombre Jugadores");
	
	Label lblJugador1 = new Label("Jugador 1:");
	Label lblJugador2 = new Label("Jugador 2:");
	Label lblJugador3 = new Label("Jugador 3:");
	Label lblJugador4 = new Label("Jugador 4:");
	
	TextField txtJugador1 = new TextField();
	TextField txtJugador2 = new TextField();
	TextField txtJugador3 = new TextField();
	TextField txtJugador4 = new TextField();
	
	Button btnAtras = new Button("Atrás");
	Button btnComenzar = new Button("Comenzar");
	
	public NombreJugadores()
	{
		ventana.setLayout(null);
		//setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB.
		ventana.setSize(350, 335);
		
		lblJugador1.setBounds(60, 60, 70, 25);
		ventana.add(lblJugador1);
		txtJugador1.setBounds(140, 60, 150, 25);
		ventana.add(txtJugador1);
		
		lblJugador2.setBounds(60, 110, 70, 25);
		ventana.add(lblJugador2);
		txtJugador2.setBounds(140, 110, 150, 25);
		ventana.add(txtJugador2);
		
		lblJugador3.setBounds(60, 160, 70, 25);
		ventana.add(lblJugador3);
		txtJugador3.setBounds(140, 160, 150, 25);
		ventana.add(txtJugador3);
		
		lblJugador4.setBounds(60, 210, 70, 25);
		ventana.add(lblJugador4);
		txtJugador4.setBounds(140, 210, 150, 25);
		ventana.add(txtJugador4);
		
		btnAtras.setBounds(50, 280, 100, 30);
		ventana.add(btnAtras);
		btnComenzar.setBounds(200, 280, 100, 30);
		ventana.add(btnComenzar);
		
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		//ventana.setVisible(false);
	}
}

package es.studium.juego_LaOca;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class NumeroJugadores
{
	Frame ventana = new Frame("La Oca: Número Jugadores");
	
	Label lblJugadores = new Label("Selecciona número de jugadores:");
	
	Button btn2Jugadores = new Button("2");
	Button btn3Jugadores = new Button("3");
	Button btn4Jugadores = new Button("4");
	
	Font letra = new Font("Arial", Font.BOLD, 32); //Para poner los números más grandes y en negrita.
	
	Button btnAtras = new Button("Atrás");
	//Button btnContinuar = new Button("Continuar");
	
	public NumeroJugadores()
	{
		ventana.setLayout(null);
		//setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB.
		ventana.setSize(430, 335);
		
		lblJugadores.setBounds(125, 42, 180, 30);
		ventana.add(lblJugadores);
		
		btn2Jugadores.setBounds(70, 85, 100, 70);
		btn2Jugadores.setFont(letra); //Aplicando el estilo de los números.
		ventana.add(btn2Jugadores);
		
		btn3Jugadores.setBounds(260, 85, 100, 70);
		btn3Jugadores.setFont(letra);
		ventana.add(btn3Jugadores);
		
		btn4Jugadores.setBounds(165, 180, 100, 70);
		btn4Jugadores.setFont(letra);
		ventana.add(btn4Jugadores);
		
		btnAtras.setBounds(50, 280, 100, 30);
		ventana.add(btnAtras);
		//btnContinuar.setBounds(250, 280, 100, 30);
		//ventana.add(btnContinuar);
		
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(false);
	}
}

package es.studium.juego_LaOca;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class Tablero extends Frame //Hereda de Frame.
{
	private static final long serialVersionUID = 1L; //Por haber heredado de la clase Frame.
	
	int[][] coordenadas;//int[][] coordenadas = new int[60][2]; 
	
	int nJugadores; //número jugadores.
	int turno = 1;
	
	Label lblNombreJugador1 = new Label();
	Label lblNombreJugador2 = new Label();
	Label lblNombreJugador3 = new Label();
	Label lblNombreJugador4 = new Label();
	
	
	//Objeto para manipulación de imágenes
	Toolkit herramienta;
	//Objetos que contienen imágenes
	Image imagenTablero;
	Image imagenDado;
	Image imagenTurnoA;
	Image imagenTurnoAz;
	Image imagenTurnoV;
	Image imagenTurnoR;
	
	Image uno, dos, tres, cuatro, cinco, seis;
	
	
	//Posiciones número de casilla
	int posicionVerde = 0;
	int posicionAmarilla = 0;
	int posicionAzul = 0;
	int posicionRoja = 0;
	
	
	//Posicion inicio coordenadas
	int xVerde = 300;
    int yVerde = 540;
    int xAmarilla = 300;
    int yAmarilla = 570;
    int xAzul = 300;
    int yAzul = 600;
    int xRojo = 300;
    int yRojo = 630;
	
    	
	Button btnTirada = new Button("Tirada");
	
	Button btnFinalizarPartida = new Button("Finalizar Partida");
	
	//Diálogo Confirmación
	Dialog dlgConfirmacion = new Dialog(this, "Confirmación", true);
	Label lblMensaje= new Label("");
	Button btnAceptar = new Button("Aceptar");
	Button btnCancelar = new Button("Cancelar");
	
	//Diálogo Fin Juego
	Dialog dlgFin = new Dialog(this, "Fin del Juego", true);
	Button btnVolverJugar = new Button("Volver a jugar");
	Button btnFinalizar = new Button("Finalizar");
	
	//Diálogo Volver a Jugar
	Dialog dlgNuevaPartida = new Dialog(this, "Nueva Partida", true);
	Button btnSi = new Button("Si");
	Button btnNo = new Button("No");
	
	
	
	public Tablero(int nJugadores)
	{
		//addMouseListener(this);
		this.nJugadores = nJugadores;
		
		coordenadas = new int[61][2]; 
		inicializarCoordenadas();
		
		setLayout(null);
		setTitle("La Oca: Juego");
		//setBackground(Color.decode("#C5E3E1")); //"decode": para personalizar el color en RGB. FFFFD3 - C5E3E1
		setSize(1280, 670);
		
		//Activamos la herramienta
		herramienta = getToolkit();
		//Cargar la imagen
		imagenTablero = herramienta.getImage("img/tableroOca.png");
		imagenDado = herramienta.getImage("img/dado.png");
		
		imagenTurnoA = herramienta.getImage("img/flechaA.png");
		imagenTurnoAz = herramienta.getImage("img/flechaAz.png");
		imagenTurnoV = herramienta.getImage("img/flechaV.png");
		imagenTurnoR = herramienta.getImage("img/flechaR.png");
		
		lblNombreJugador1.setBounds(150, 82, 150, 25);
		add(lblNombreJugador1);
		lblNombreJugador2.setBounds(150, 152, 150, 25);
		add(lblNombreJugador2);
		lblNombreJugador3.setBounds(150, 222, 150, 25);
		add(lblNombreJugador3);
		lblNombreJugador4.setBounds(150, 292, 150, 25);
		add(lblNombreJugador4);		
		
		btnTirada.setBounds(50, 450, 80, 30);
		add(btnTirada);
		
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
		
		g.drawImage(imagenDado, 175, 420, this);

		
		
		// Turno
		switch(turno)
		{
			case 1:
				g.drawImage(imagenTurnoV, 30, 65, this);
				break;
				
			case 2:
				g.drawImage(imagenTurnoA, 30, 135, this);
				break;
				
			case 3:
				g.drawImage(imagenTurnoAz, 30, 205, this);
				break;
				
			case 4:
				g.drawImage(imagenTurnoR, 30, 275, this);
				break;
		}
				
		
		// Jugadores fichas
		g.setColor(Color.green);
		g.fillOval(xVerde, yVerde, 25, 25); // Ficha verde
		g.setColor(Color.yellow);
		g.fillOval(xAmarilla, yAmarilla, 25, 25); // Ficha amarilla
		
		switch(nJugadores)
		{
			case 3:
				g.setColor(Color.blue);
				g.fillOval(xAzul, yAzul, 25, 25); // Ficha azul
				break;
				
			case 4:
				g.setColor(Color.blue);
				g.fillOval(xAzul, yAzul, 25, 25);
				g.setColor(Color.red);
				g.fillOval(xRojo, yRojo, 25, 25); // Ficha rojo
				break;
		}
	}
	
	
	
	//Actualizar tuno
	public void actualizarTurno(int t)
	{
		turno = t;
		repaint();
	}
	
	
	
	//Imagen dado según el número que haya salido.
	public void tiradaDado(int aleatorio)
	{
		switch(aleatorio)
		{
			case 1:
				imagenDado = herramienta.getImage("img/uno.png");
				break;
			case 2:
				imagenDado = herramienta.getImage("img/dos.png");
				break;
			case 3:
				imagenDado = herramienta.getImage("img/tres.png");
				break;
			case 4:	
				imagenDado = herramienta.getImage("img/cuatro.png");
				break;
			case 5:	
				imagenDado = herramienta.getImage("img/cinco.png");
				break;
			case 6:	
				imagenDado = herramienta.getImage("img/seis.png");
				break;
		}
		
		repaint();
	}
	
	
	
	//Guardar coordenadas
	private void inicializarCoordenadas()
	{
		//Coordenadas
		coordenadas[0][0] = 300;
		coordenadas[0][1] = 540;
				
		coordenadas[1][0] = 487;
		coordenadas[1][1] = 566;
				
		coordenadas[2][0] = 574;
		coordenadas[2][1] = 579;
						
		coordenadas[3][0] = 646;
		coordenadas[3][1] = 583;
								
		coordenadas[4][0] = 719;
		coordenadas[4][1] = 586;
				
		coordenadas[5][0] = 791;
		coordenadas[5][1] = 587;
						
		coordenadas[6][0] = 872;
		coordenadas[6][1] = 584;
						
		coordenadas[7][0] = 941;
		coordenadas[7][1] = 579;
								
		coordenadas[8][0] = 1013;
		coordenadas[8][1] = 596;
										
		coordenadas[9][0] = 1093;
		coordenadas[9][1] = 569;
						
		coordenadas[10][0] = 1162;
		coordenadas[10][1] = 529;
						
		coordenadas[11][0] = 1182;
		coordenadas[11][1] = 461;
						
		coordenadas[12][0] = 1178;
		coordenadas[12][1] = 388;
								
		coordenadas[13][0] = 1182;
		coordenadas[13][1] = 314;
										
		coordenadas[14][0] = 1177;
		coordenadas[14][1] = 247;
						
		coordenadas[15][0] = 1179;
		coordenadas[15][1] = 169;
								
		coordenadas[16][0] = 1139;
		coordenadas[16][1] = 103;
								
		coordenadas[17][0] = 1067;
		coordenadas[17][1] = 81;
								
		coordenadas[18][0] = 1001;
		coordenadas[18][1] = 73;
										
		coordenadas[19][0] = 924;
		coordenadas[19][1] = 89;
												
		coordenadas[20][0] = 855;
		coordenadas[20][1] = 83;	
				
		coordenadas[21][0] = 787;
		coordenadas[21][1] = 61;
					
		coordenadas[22][0] = 707;
		coordenadas[22][1] = 80;
							
		coordenadas[23][0] = 633;
		coordenadas[23][1] = 67;
							
		coordenadas[24][0] = 557;
		coordenadas[24][1] = 83;	
							
		coordenadas[25][0] = 491; 
		coordenadas[25][1] = 71;
									
		coordenadas[26][0] = 411;
		coordenadas[26][1] = 107;	
									
		coordenadas[27][0] = 385;
		coordenadas[27][1] = 173;
											
		coordenadas[28][0] = 419; 
		coordenadas[28][1] = 260;	
											
		coordenadas[29][0] = 405;
		coordenadas[29][1] = 321;
													
		coordenadas[30][0] = 404; 
		coordenadas[30][1] = 400;
													
		coordenadas[31][0] = 471; 
		coordenadas[31][1] = 449;
															
		coordenadas[32][0] = 550;
		coordenadas[32][1] = 467;	
														
		coordenadas[33][0] = 623;
		coordenadas[33][1] = 465;
																
		coordenadas[34][0] = 699;
		coordenadas[34][1] = 469;
																
		coordenadas[35][0] = 761;
		coordenadas[35][1] = 465;
																		
		coordenadas[36][0] = 840; 
		coordenadas[36][1] = 459;								
			
		coordenadas[37][0] = 920; 
		coordenadas[37][1] = 457;
										
		coordenadas[38][0] = 998; 
		coordenadas[38][1] = 451;
				
		coordenadas[39][0] = 1047; 
		coordenadas[39][1] = 397;
				
		coordenadas[40][0] = 1057; 
		coordenadas[40][1] = 335;
				
		coordenadas[41][0] = 1066; 
		coordenadas[41][1] = 287;
				
		coordenadas[42][0] = 1026; 
		coordenadas[42][1] = 163;
				
		coordenadas[43][0] = 969; 
		coordenadas[43][1] = 193;
				
		coordenadas[44][0] = 921; 
		coordenadas[44][1] = 189;
				
		coordenadas[45][0] = 867; 
		coordenadas[45][1] = 185;
										
		coordenadas[46][0] = 811; 
		coordenadas[46][1] = 197;
				
		coordenadas[47][0] = 761; 
		coordenadas[47][1] = 179;
				
		coordenadas[48][0] = 707; 
		coordenadas[48][1] = 174;
				
		coordenadas[49][0] = 650; 
		coordenadas[49][1] = 183;
				
		coordenadas[50][0] = 569; 
		coordenadas[50][1] = 185;
				
		coordenadas[51][0] = 529; 
		coordenadas[51][1] = 253;
				
		coordenadas[52][0] = 543; 
		coordenadas[52][1] = 355;
				
		coordenadas[53][0] = 602; 
		coordenadas[53][1] = 354;
										
		coordenadas[54][0] = 654; 
		coordenadas[54][1] = 342;
				
		coordenadas[55][0] = 711; 
		coordenadas[55][1] = 343;
				
		coordenadas[56][0] = 767; 
		coordenadas[56][1] = 349;
				
		coordenadas[57][0] = 815; 
		coordenadas[57][1] = 349;
				
		coordenadas[58][0] = 867; 
		coordenadas[58][1] = 334;
				
		coordenadas[59][0] = 923; 
		coordenadas[59][1] = 343;
				
		coordenadas[60][0] = 979; 
		coordenadas[60][1] = 342;
	}
	
	
	
	//Métodos mover fichas
	public void moverFichaVerde(int aleatorio) 
	{
	    int nuevaPosicion = posicionVerde + aleatorio;
	    
	    if (nuevaPosicion <= 60)
	    {
	        xVerde = coordenadas[nuevaPosicion][0];
	        yVerde = coordenadas[nuevaPosicion][1];
	        
	        posicionVerde = nuevaPosicion;
	    }
	    
	    repaint();
	}
	

	public void moverFichaAmarilla(int aleatorio) 
	{
	    int nuevaPosicion = posicionAmarilla + aleatorio;
	    
	    if (nuevaPosicion <= 60)
	    {
	        xAmarilla = coordenadas[nuevaPosicion][0];
	        yAmarilla = coordenadas[nuevaPosicion][1];
	        
	        posicionAmarilla = nuevaPosicion;
	    }
	    
	    repaint();
	}
	
	
	public void moverFichaAzul(int aleatorio) 
	{
	    int nuevaPosicion = posicionAzul + aleatorio;
	    
	    if (nuevaPosicion <= 60)
	    {
	        xAzul = coordenadas[nuevaPosicion][0];
	        yAzul = coordenadas[nuevaPosicion][1];
	        
	        posicionAzul = nuevaPosicion;
	    }
	    
	    repaint();
	}
	
	
	public void moverFichaRoja(int aleatorio) 
	{
	    int nuevaPosicion = posicionRoja + aleatorio;
	    
	    if (nuevaPosicion <= 60)
	    {
	        xRojo = coordenadas[nuevaPosicion][0];
	        yRojo = coordenadas[nuevaPosicion][1];
	        
	        posicionRoja = nuevaPosicion;
	    }
	    
	    repaint();
	}
	
	
	
	/*public int obtenerCasillaOca(int posicion)
	{
    	int[] casillasOca = {1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59}; 
    	    
    	    for (int i = 0; i < casillasOca.length - 1; i++)
    	    {
    	        if (posicion == casillasOca[i])
    	        {
    	           int nuevaPosicion = casillasOca[i + 1]; // Retorna la siguiente casilla de la Oca
    	        }
    	        
    	    }
    	    
    	    return -1; // No hay más casillas de la Oca después de la posición actual
    }*/
	
	
	
	/*public static void main(String[] args)
	{
		new Tablero(nJugadores);
	}*/

	
	
	
	/*@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("x:"+e.getX()+"   "+"y:"+e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}*/

	
	
}

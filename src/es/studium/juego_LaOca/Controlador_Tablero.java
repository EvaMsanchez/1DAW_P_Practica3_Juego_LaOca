package es.studium.juego_LaOca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador_Tablero implements WindowListener, ActionListener
{
	Modelo modelo;
	Tablero tablero;
	MenuPrincipal menuPrincipal;
	NumeroJugadores numeroJugadores;
	
	//Nombre de los jugadores.
	String j1; 
	String j2;
	String j3;
	String j4;
	
	int nJugadores; //número jugadores.
	
	int turno = 1; //turno.

	//Número de tiradas para el ranking.
	int tiradasVerde = 0;
	int tiradasAmarillo = 0;
	int tiradasAzul = 0;
	int tiradasRojo = 0;
		
	
	public Controlador_Tablero(Modelo m, Tablero t, MenuPrincipal mn, int nJugadores, NumeroJugadores nJ, String j1, String j2, String j3, String j4)
	{	
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.j4 = j4;
		
		this.nJugadores = nJugadores;
		this.modelo = m;
		this.tablero = t;
		this.menuPrincipal = mn;
		this.numeroJugadores = nJ;
		
		//Añadir Listeners.
		this.tablero.addWindowListener(this); //También se puede por nj en vez de numeroJugadores.
		//Botones.
		this.tablero.btnFinalizarPartida.addActionListener(this);
		this.tablero.btnTirada.addActionListener(this);
		//Botones confirmación.
		this.tablero.btnAceptar.addActionListener(this);
		this.tablero.btnCancelar.addActionListener(this);
		//Botones Fin Juego.
		this.tablero.btnFinalizar.addActionListener(this);
		this.tablero.btnVolverJugar.addActionListener(this);
		//Botones Volver a Jugar.
		this.tablero.btnSi.addActionListener(this);
		this.tablero.btnNo.addActionListener(this);
		
		
		//Nombre de los jugadores en el tablero.
		tablero.lblNombreJugador1.setText(j1);
	    tablero.lblNombreJugador2.setText(j2);
	    tablero.lblNombreJugador3.setText(j3);
	    tablero.lblNombreJugador4.setText(j4);
	}

	
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
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
		//Botón tirada del dado.
		if(e.getSource().equals(tablero.btnTirada))
		{
			int tirada =modelo.aleatorio();
			
			tablero.tiradaDado(tirada);
			
			//Sonido del dado.
			modelo.reproducirSonido();
			
			
			//Diálogo ganador
			tablero.dlgFin.setLayout(null);
			tablero.dlgFin.setSize(380,150);
			tablero.lblMensaje.setBounds(100, 35, 300, 50);
			tablero.btnFinalizar.setBounds(70, 90, 100, 30);
			tablero.btnVolverJugar.setBounds(210, 90, 100, 30);
			tablero.dlgFin.add(tablero.lblMensaje);
			tablero.dlgFin.add(tablero.btnFinalizar);
			tablero.dlgFin.add(tablero.btnVolverJugar);
		    tablero.dlgFin.setResizable(false);
		    tablero.dlgFin.setLocationRelativeTo(null);
			
		        
	        switch (turno)
	        {      
	            case 1:
	            	tablero.moverFichaVerde(tirada);// Mover ficha del jugador verde
	            	tiradasVerde++;        	
	    
	            	if(tablero.posicionVerde==60)
					{
	            		tablero.lblMensaje.setText("¡¡¡"+tablero.lblNombreJugador1.getText().toUpperCase()+" ha ganado el juego!!!");
	            		tablero.dlgFin.setVisible(true);
	            		
	            		modelo.insertarJugador(j1.toUpperCase(), tiradasVerde);
					}
	                break;
	                
	            case 2:
	            	tablero.moverFichaAmarilla(tirada);
	            	tiradasAmarillo++;
	            	
	            	if(tablero.posicionAmarilla==60)
					{
	            		tablero.lblMensaje.setText("¡¡¡"+tablero.lblNombreJugador2.getText().toUpperCase()+" ha ganado el juego!!!");
	            		tablero.dlgFin.setVisible(true);
	            		
	            		modelo.insertarJugador(j2.toUpperCase(), tiradasAmarillo);
					}
	                break;
	                
	            case 3:
	                tablero.moverFichaAzul(tirada);
	                tiradasAzul++;
	                
	                if(tablero.posicionAzul==60)
					{
	                	tablero.lblMensaje.setText("¡¡¡"+tablero.lblNombreJugador3.getText().toUpperCase()+" ha ganado el juego!!!");
	            		tablero.dlgFin.setVisible(true);
	            		
	            		modelo.insertarJugador(j3.toUpperCase(), tiradasAzul);
					}
	                break;
	                
	            case 4:
	            	tablero.moverFichaRoja(tirada);
	            	tiradasRojo++;
	            	
	            	if(tablero.posicionRoja==60)
					{
	            		tablero.lblMensaje.setText("¡¡¡"+tablero.lblNombreJugador4.getText().toUpperCase()+" ha ganado el juego!!!");
	            		tablero.dlgFin.setVisible(true);
	            		
	            		modelo.insertarJugador(j4.toUpperCase(), tiradasRojo);
					}
	                break;
	        }
	        
	        
	        
	        if(tirada!=6)
	        {
	    	  turno++;
	        }
	       
	        
	        
			if(turno>nJugadores)
			{
				turno = 1; // Vuelve al primer jugador si ya se alcanzó el último
			}
			
			tablero.actualizarTurno(turno);
			tablero.repaint();
	        
		}
		
		
		//Botón Finalizar.
		else if(e.getSource().equals(tablero.btnFinalizarPartida))
		{
			tablero.dlgConfirmacion.setLayout(null);
			tablero.dlgConfirmacion.setSize(380,150);
			tablero.lblMensaje.setBounds(55, 35, 300, 50);
			tablero.lblMensaje.setText("¿Estás seguro/a que desea abandonar la partida?");
			tablero.btnAceptar.setBounds(70, 90, 100, 30);
			tablero.btnCancelar.setBounds(210, 90, 100, 30);
			tablero.dlgConfirmacion.add(tablero.lblMensaje);
			tablero.dlgConfirmacion.add(tablero.btnAceptar);
			tablero.dlgConfirmacion.add(tablero.btnCancelar);
			
			tablero.dlgConfirmacion.setResizable(false);
			tablero.dlgConfirmacion.setLocationRelativeTo(null);
			tablero.dlgConfirmacion.setVisible(true);
		}
		
		
		//Botón Cancelar.
		else if(e.getSource().equals(tablero.btnCancelar))
		{
			tablero.dlgConfirmacion.setVisible(false);
		}
		
		
		//Botón Aceptar.
		else if(e.getSource().equals(tablero.btnAceptar))
		{
			tablero.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		
		//Botón Finalizar.
		else if(e.getSource().equals(tablero.btnFinalizar))
		{
			tablero.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		
		//Botón Aceptar.
		else if(e.getSource().equals(tablero.btnVolverJugar))
		{
			tablero.dlgNuevaPartida.setLayout(null);
			tablero.dlgNuevaPartida.setSize(380,150);
			tablero.lblMensaje.setBounds(65, 35, 300, 50);
			tablero.lblMensaje.setText("¿Quieres continuar con los mismos jugadores?");
			tablero.btnSi.setBounds(70, 90, 100, 30);
			tablero.btnNo.setBounds(210, 90, 100, 30);
			tablero.dlgNuevaPartida.add(tablero.lblMensaje);
			tablero.dlgNuevaPartida.add(tablero.btnSi);
			tablero.dlgNuevaPartida.add(tablero.btnNo);
			
			tablero.dlgNuevaPartida.setResizable(false);
			tablero.dlgNuevaPartida.setLocationRelativeTo(null);
			tablero.dlgNuevaPartida.setVisible(true);
		}
		
		
		//Botón No. Nos dirige a la ventana numero de jugadores.
		else if(e.getSource().equals(tablero.btnNo))
		{
			tablero.setVisible(false);
			numeroJugadores.ventana.setVisible(true);
		}		
		
		
		//Botón Si. Carga de nuevo la partida con los mismo jugadores.
		else if(e.getSource().equals(tablero.btnSi))
		{
			tablero.setVisible(false);
			
			Tablero tablero = new Tablero(nJugadores); //provisional
			new Controlador_Tablero(modelo, tablero, menuPrincipal, nJugadores, numeroJugadores, j1, j2, j3, j4);
			
			tablero.setVisible(true);
		}	
	}
}	
	
		
			
			
			
			
			
			
			
			
			

			
			
		
		
	
	
	
		


	


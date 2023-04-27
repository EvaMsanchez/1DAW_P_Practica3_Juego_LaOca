package es.studium.juego_LaOca;

public class Principal
{

	public static void main(String[] args)
	{
		//MVC
		Modelo modelo = new Modelo();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		//NumeroJugadores numeroJugadores = new NumeroJugadores();
		
		new Controlador_MenuPrincipal(modelo, menuPrincipal); //Se quita el objeto del controlador porque no se va a utilizar.
		//new Controlador_NumeroJugadores(modelo, numeroJugadores);
	}

}

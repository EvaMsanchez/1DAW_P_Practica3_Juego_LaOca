package es.studium.juego_LaOca;

public class Principal
{

	public static void main(String[] args)
	{
		//MVC
		Modelo modelo = new Modelo();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
		new Controlador_MenuPrincipal(modelo, menuPrincipal); //Se quita el objeto del controlador porque no se va a utilizar.
	}

}

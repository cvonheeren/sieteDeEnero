import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerDatos {
	
	public String IntroducirNombre(Scanner reader) {
		System.out.println("Introduce nombre: ");		
		return reader.next();
	}
	
	
	
	public char IntroducirValidarSexo(Scanner reader) {
		//Declaracion e inicializaci�n de variables
		char sexo = 'M';
		//Inicio de programa
		System.out.println("Introduce sexo (M � H): ");
		sexo = reader.next().charAt(0);
		while(sexo != 'M' && sexo != 'm' && sexo != 'H' && sexo != 'h')
		{
			System.out.println("Introduce sexo (M � H): ");
			sexo = reader.next().charAt(0);
		}
		if(sexo == 'm' || sexo == 'M')
			sexo = 'M';
		else
			sexo = 'H';
	
		return sexo;
	}
	
	public int RecogerOpcionInt(Scanner reader,int valorMin,int valorMax, String texto ) {
		
		//Declaracion e inicializaci�n de variables
		int opcion = 0;
		boolean opcionCorrecta = false; 
		//Inicio de programa
		while(!opcionCorrecta)
		{
			try
			{ 
				System.out.println(texto);
				opcion=reader.nextInt();
				while(opcion < valorMin || opcion > valorMax)
				{
					System.out.println("Introduce un valor n�merico entre "+valorMin+" y "+valorMax);
					opcion=reader.nextInt();
				}
				reader.nextLine();
				opcionCorrecta = true;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Introduce un valor n�merico entre "+valorMin+" y "+valorMax);
				reader.nextLine();
			}
			
		}
		return opcion;
	}
	
	public float RecogerOpcionFloat(Scanner reader,float valorMin,float valorMax, String texto ) {
		
		//Declaracion e inicializaci�n de variables
		float opcion = 0;
		boolean opcionCorrecta = false; 
		//Inicio de programa
		while(!opcionCorrecta)
		{
			try
			{
				System.out.println(texto);
				opcion=reader.nextFloat();
				while(opcion < valorMin || opcion > valorMax)
				{
					System.out.println("Introduce un valor n�merico entre "+valorMin+" y "+valorMax);
					opcion=reader.nextFloat();
				}
				reader.nextLine();
				opcionCorrecta = true;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Introduce un valor n�merico entre "+valorMin+" y "+valorMax);
				reader.nextLine();
			}
			
		}
		return opcion;
	}
}

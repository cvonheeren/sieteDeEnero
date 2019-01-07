import java.util.Scanner;

public class MainAlumnos {

	public static void main(String[] args) {
		
 
		// Declaracion e inicializacion de variables
		FuncionesAlumnos funcionesAlumnos = new FuncionesAlumnos();
		LeerDatos leerDatos = new LeerDatos();
		int opcion = -1;
		Scanner reader = new Scanner(System.in);
		Alumno [] alumnos = null;
		FuncionesMain funciones = new FuncionesMain();

		
		//Inicio de programa
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: alumnos = funciones.CargarDatos(reader, leerDatos);
					break;
				case 2: if(alumnos != null) funciones.ProcesarDatos(alumnos, funcionesAlumnos);
					break;
				case 3: if(alumnos != null) funciones.MostrarDatos(alumnos);
					break;
				case 4: if(alumnos != null) funciones.MostrarDatosAlumno(alumnos,reader);
				break;
	
			}
			funciones.MostrarMenu();
			opcion = leerDatos.RecogerOpcionInt(reader,0,4, "Introduce una opci�n: ");
		}
		
		reader.close();

	}

	

}

import java.util.Scanner;

public class FuncionesMain {
	 
	public void MostrarDatosAlumno(Alumno[] alumnos,Scanner reader) {
		// Declaracion e inicializacion de variables
		StringBuilder sb = new StringBuilder();
		String nombre = "";
		boolean encontrado = false;
		//Inicio de programa
		System.out.println("Introduce en nombre completo del alumno: ");
		nombre = reader.nextLine();
		for(int i = 0;i<alumnos.length;i++)
		{
			if(alumnos[i].getNombre().equalsIgnoreCase(nombre))
			{
				System.out.println(alumnos[i].toStringCustom(sb));
				encontrado = true;
			}
		}
		if(!encontrado)
			System.out.println("Alumno no encontrado");
		
		
	}

	public void MostrarDatos(Alumno[] alumnos) {
		//Inicio de programa
		System.out.println("\t Listado de alumnos");
		System.out.println("---------------------------");
		System.out.println("Nombre    \t Sexo\tEdad\t Altura (m)\t Peso (kg)\t ");
		System.out.println("----------\t-----\t -----\t ---------\t---------\t ");
		
		for(int i = 0;i<alumnos.length;i++)
		{
			System.out.println(alumnos[i].getNombre()+"\t "+alumnos[i].getSexo()+"\t "+alumnos[i].getEdad()+"\t "+alumnos[i].getAltura()+"\t \t"+alumnos[i].getPeso()+"\t ");
		}
		
	}

	public void ProcesarDatos(Alumno[] alumnos, FuncionesAlumnos funcionesAlumnos) {
		// Declaracion e inicializacion de variables
		float promedio = 0;
		int contadorPersonas = 0;
		//Inicio de programa
		promedio = funcionesAlumnos.CalcularPromedio(alumnos);
		contadorPersonas = funcionesAlumnos.CalcularTotal(alumnos);
		System.out.println("El promedio de alumnos masculinos es " + promedio);
		System.out.println("Las personas que miden mas de 1,65 son " + contadorPersonas);
	}

	

	public Alumno[] CargarDatos(Scanner reader, LeerDatos leerDatos) {
		
		//Declaracion e inicializaci�n de variables
		Alumno [] alumnos = null;
		String nombre;
		char sexo;
		int edad;
		float altura;
		float peso;
		int numeroAlumnos = 0;
		//Inicio de programa
		numeroAlumnos = leerDatos.RecogerOpcionInt(reader,0,100,"Introduce la cantidad de alumnos: ");
		alumnos = new Alumno[numeroAlumnos];
		
		for(int i = 0;i<numeroAlumnos;i++)
		{
			nombre = leerDatos.IntroducirNombre(reader);
			sexo = leerDatos.IntroducirValidarSexo(reader);
			edad= leerDatos.RecogerOpcionInt(reader,0,200,"Introduce la edad: ");
			altura= leerDatos.RecogerOpcionFloat(reader,0,(float) 2.5,"Introduce la altura: ");
			peso= leerDatos.RecogerOpcionFloat(reader,0,150,"Introduce el peso: ");
			
			Alumno alumno = new Alumno(nombre,sexo,edad,altura,peso);
			alumnos[i] = alumno;
		}
		
		return alumnos;
	}

	

	

	public void MostrarMenu() {
	 
		//Inicio de programa
		System.out.println("\t Menu Principal");
		System.out.println("1.- Cargar datos alumnos");
		System.out.println("2.- Procesar los datos");
		System.out.println("3.- Mostrar datos de los alumnos");
		System.out.println("4.- Mostrar datos de un alumno");
		System.out.println("0.- Fin");
	}

}


public class FuncionesAlumnos
{
	public int CalcularTotal(Alumno[] alumnos) {
		// Declaracion e inicializacion de variables
		int contador = 0;
		//Inicio de programa
		for(int i = 0;i<alumnos.length;i++)
		{
			if(alumnos[i].getAltura() > 1.65)
				contador++;
		}
		return contador;
	}

	public float CalcularPromedio(Alumno[] alumnos) {
		// Declaracion e inicializacion de variables
		float promedio = 0;
		int contador = 0;
		//Inicio de programa
		for(int i = 0;i<alumnos.length;i++)
		{
			if(alumnos[i].getSexo() == 'H')
			{
				promedio = promedio + alumnos[i].getEdad();
				contador++;
			}
		}
		promedio = promedio/contador;
		return promedio;
	}
}

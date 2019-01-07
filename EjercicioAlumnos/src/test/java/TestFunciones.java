import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Scanner;

public class TestFunciones
{
	/*Declaracion de variables (se declaran arriba para poder 
	 usarlas en todos los tests*/
	
	//Crear una instancia de la clase que se va a testear
	private FuncionesMain funcionesMain = new FuncionesMain();
	private Scanner reader = new Scanner(System.in);
	//Crear instancias de las clases que necesitamos mockear
	private LeerDatos leerDatosMock = mock(LeerDatos.class);
	private FuncionesAlumnos funcionesAlumnosMock = mock(FuncionesAlumnos.class);
	
	//Crear un alumno con atributos
	private String nombre = "Carlos gonzalez";
	private char sexo = 'H';
	private int edad = 34;
	private float altura = 1.78f;
	private float peso = 67.6f;
	private Alumno alumno = new Alumno(nombre,sexo,edad,altura,peso);
	
	@Test
	public void testProcesarDatos()
	{
		//Crear un array de Alumno 
		Alumno[] alumnos = new Alumno[1];
		alumnos[0] = alumno;
		
		/*La funcion que vamos a testear llama a dos funciones de la clase
		FuncionesAlumnos que ya se han testeado asique le hacemos un mock*/
		funcionesMain.ProcesarDatos(alumnos, funcionesAlumnosMock);
		
		/*Lo unico que podemos testear en esta funcion es que se esta llamando
		a las dos funciones de la clase mockeada*/
		//Verificar que las funciones son llamadas 1 vez (y solo una)
		verify(funcionesAlumnosMock, times(1)).CalcularPromedio(alumnos);
		verify(funcionesAlumnosMock, times(1)).CalcularTotal(alumnos);
	}

	
	/*La funcion CargarDatos tiene un bucle for. Puede que entre en el bucle o
	puede que no, asique hay que hacer dos tests para comprobar ambas opciones*/
	@Test
	public void testCargarDatos1() {
		//Mockear el resultado de la funcion RecogerOpcionInt, en este caso queremos que nos devuelva un 0	
		when(leerDatosMock.RecogerOpcionInt(reader, 0,100,"Introduce la cantidad de alumnos: ")).thenReturn(0);
		
		//Llamamos a la funcion y guardamos el array de alumnos que devuelve en resultado
		Alumno[] resultado = funcionesMain.CargarDatos(reader,leerDatosMock);
		
		/*Como hemos mockeado la funcion para que devuelva un 0 (en este caso el 0 
		es la longitud del array, no entra en el bucle y pasa a devolver el resultado.
		Comprobamos que devuelve un array de longitud 0 con assertEquals*/
		assertEquals(resultado.length, 0);
	}
	
	@Test
	public void testCargarDatos2() {
		/*Mockear los resultados de las funciones*/
		//Mock del total de alumnos. Para el test con uno vale
		when(leerDatosMock.RecogerOpcionInt(reader, 0,100,"Introduce la cantidad de alumnos: ")).thenReturn(1);
		
		//Mock de los datos del alumno
		when(leerDatosMock.IntroducirNombre(reader)).thenReturn("Sara");
		when(leerDatosMock.IntroducirValidarSexo(reader)).thenReturn('M');
		when(leerDatosMock.RecogerOpcionInt(reader,0,200,"Introduce la edad: ")).thenReturn(20);
		when(leerDatosMock.RecogerOpcionFloat(reader,0,(float) 2.5,"Introduce la altura: ")).thenReturn(1.6f);
		when(leerDatosMock.RecogerOpcionFloat(reader,0,150,"Introduce el peso: ")).thenReturn(52f);
		
		//Llamamos a la funcion y guardamos el array de alumnos que devuelve en resultado
		Alumno[] resultado = funcionesMain.CargarDatos(reader,leerDatosMock);

		//Comprobamos que los datos del resultado coinciden con los mockeados
		assertEquals(resultado[0].getNombre(), "Sara");
		assertEquals(resultado[0].getSexo(), 'M');
		assertEquals(resultado[0].getEdad(), 20);
		assertEquals(resultado[0].getAltura(), 1.6f, 0);
		assertEquals(resultado[0].getPeso(), 52f, 0);
		
		//Tambien se pueden comprobar el resto del codigo para aumentar el coverage
		verify(leerDatosMock, times(1)).RecogerOpcionInt(reader, 0,100,"Introduce la cantidad de alumnos: ");
		verify(leerDatosMock, times(1)).IntroducirNombre(reader);
		verify(leerDatosMock, times(1)).IntroducirValidarSexo(reader);
		verify(leerDatosMock, times(1)).RecogerOpcionInt(reader, 0, 200, "Introduce la edad: ");
		verify(leerDatosMock, times(1)).RecogerOpcionFloat(reader, 0, 2.5f, "Introduce la altura: ");
		verify(leerDatosMock, times(1)).RecogerOpcionFloat(reader, 0, 150, "Introduce el peso: ");
		assertEquals(resultado.length, 1);
	}

}

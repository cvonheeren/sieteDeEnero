import static org.junit.Assert.*;
import org.junit.Test;

public class TestAlumnos { 

	
	private String nombre = "Carlos gonzalez";
	private char sexo = 'H';
	private int edad = 34;
	private float altura = (float) 1.78;
	private float peso = (float) 67.6;
	private Alumno alumno = new Alumno(nombre,sexo,edad,altura,peso);
	
	
	@Test
	public void testContructorAlumno() {
		Alumno alumnoprueba = new Alumno(nombre,sexo,edad,altura,peso);
		assertEquals(nombre,alumnoprueba.getNombre());
		assertEquals(sexo,alumnoprueba.getSexo());
		assertEquals(edad, alumnoprueba.getEdad());
		assertEquals(altura,alumnoprueba.getAltura(),0.2);
		assertEquals(peso,alumnoprueba.getPeso(),0.2);
	}
	@Test
	public void testEdad() {
		alumno.setEdad(edad);
		assertEquals(edad,alumno.getEdad());
	}
	@Test
	public void testNombre() {
		alumno.setNombre(nombre);
		assertEquals(nombre,alumno.getNombre());
	}
	@Test
	public void testSexo() {
		alumno.setSexo(sexo);
		assertEquals(sexo,alumno.getSexo());
	}
	@Test
	public void testAltura() {
		alumno.setAltura(altura);
		assertEquals(altura,alumno.getAltura(),0.2);
	}
	@Test
	public void testPeso() {
		alumno.setPeso(peso);
		assertEquals(peso,alumno.getPeso(),0.2);
	}
	@Test
	public void testToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		String resultado = alumno.toStringCustom(stringBuilder);
		String expected ="Datos del alumno:\r\nNombre: Carlos "
		+ "gonzalez\r\nEdad: 34\r\nAltura:"
		+ " 1.78 m\r\nPeso: 67.6 Kg\r\n";	
		
		assertEquals(resultado, expected);
	}
	
}

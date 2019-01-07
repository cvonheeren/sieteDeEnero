import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;


public class LeerDatosTest {

	String resultado = null;
	@Test
	public void test() {
		LeerDatos leerDatos = new LeerDatos();
		
		String input = "Iker";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner reader = new Scanner(System.in);
	    
	    resultado = leerDatos.IntroducirNombre(reader);
	    assertEquals("Iker", resultado);	
	}

}

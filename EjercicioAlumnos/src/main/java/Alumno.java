
public class Alumno {
	
	private String nombre;
	private char sexo;
	private int edad;
	private float altura;
	private float peso;
	
	public Alumno(String nombre, char sexo, int edad, float altura, float peso)
	{
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) { 
		this.edad = edad;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public String toStringCustom(StringBuilder sb)
	{
		
	    sb.append("Datos del alumno:").append(System.getProperty("line.separator")); 
	    sb.append("Nombre: "+ nombre).append(System.getProperty("line.separator")); 
	    sb.append("Edad: "+ edad).append(System.getProperty("line.separator"));
	    sb.append("Altura: "+ altura + " m").append(System.getProperty("line.separator"));
	    sb.append("Peso: "+ peso + " Kg").append(System.getProperty("line.separator"));
		return sb.toString();
		
	}

}

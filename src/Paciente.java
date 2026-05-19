public class Paciente {
    
    private String nombre;
    private int edad;
    private double peso;
    private double altura;

    public Paciente() {

    }

    public Paciente(String nombre, int edad, double peso, double altura) {

        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        setAltura(altura);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
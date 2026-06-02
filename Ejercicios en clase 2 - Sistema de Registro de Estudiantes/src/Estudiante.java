public class Estudiante {

    private String nombre;
    private String edad;
    private double indiceAcademico;

    public Estudiante(String nombre, String edad, int indiceAcademico) {
        setNombre(nombre);
        setEdad(edad);
        setIndiceAcademico(indiceAcademico);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setIndiceAcademico(int indiceAcademico) {
        this.indiceAcademico = indiceAcademico;
    }   
}

public class EstudianteService {

    public static void validarEstudiante(String nombre, int edad, double indiceAcademico) throws Exception {
        validarNombre(nombre);
        validarEdad(edad);
        validarIndiceAcademico(indiceAcademico);
    }

    public static void validarNombre(String nombre) throws EstudianteInvalidoException {

        if (nombre.isBlank() || nombre.isEmpty()) {
            throw new EstudianteInvalidoException("El nombre no puede estar vacio. ");
        }
    }

    public static void validarEdad(int edad) throws EstudianteInvalidoException {

        if (edad < 18 || edad > 100) {
            throw new EstudianteInvalidoException("La edad debe ser mayor o igual a 18 años. ");
        }
    }

    public static void validarIndiceAcademico(double indiceAcademico) throws EstudianteInvalidoException {

        if (indiceAcademico < 0.0 || indiceAcademico > 4.0) {
            throw new EstudianteInvalidoException("El indice debe estar entre 0 y 4. ");
        }
    }
}
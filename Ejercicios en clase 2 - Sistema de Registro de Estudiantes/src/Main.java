public class Main {
    public static void main(String[] args) {

        try {
            EstudianteService.validarEstudiante("Juan Perez", 25, 3.8);

            System.out.println("Estudiante registrado correctamente. ");
        }

        catch(Exception e) {

            System.out.println(e.getMessage());
        }

        finally {

            System.out.println("Proceso finalizado. ");
        }

        try {
            EstudianteService.validarEstudiante("Pedro Gomez", 15, 3.5);

            System.out.println("Estudiante registrado correctamente. ");
        }

        catch(Exception e) {

            System.out.println(e.getMessage());
        }

        finally {

            System.out.println("Proceso finalizado. ");
        }

        try {
            EstudianteService.validarEstudiante("Ana Rodriguez", 20, 5.2);

            System.out.println("Estudiante registrado correctamente. ");
        }

        catch(Exception e) {

            System.out.println(e.getMessage());
        }

        finally {

            System.out.println("Proceso finalizado. ");
        }
    

        try {
            EstudianteService.validarEstudiante("",25, 3.8);

            System.out.println("Estudiante registrado correctamente. ");
        }

        catch(Exception e) {

            System.out.println(e.getMessage());
        }

        finally {

            System.out.println("Proceso finalizado. ");
        }
    }
}

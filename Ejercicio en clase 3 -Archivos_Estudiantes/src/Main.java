import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    private  static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) {

        int opcion;

        do {

            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;

                case 2:
                    mostrarEstudiantes();
                    break;
            
                default:
                    break;
            }

        } while (opcion != 2);
    }

    public static int mostrarMenu() {

        int opcion;

        System.out.println("\n1. Agregar estudiante ");
        System.out.println("2. Mostrar estudiantes ");
        System.out.println("3. Salir \n");

        System.out.print("Opcion: ");

        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    public static void agregarEstudiante() {

        try {

        FileWriter fw = new FileWriter("estudiantes.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        System.out.print("\nNOMBRE ESTUDIANTE: ");
        String nombre = sc.nextLine();

        System.out.print("MATRICULA ESTUDIANTE: ");
        String matricula = sc.nextLine();

        System.out.print("CARRERA ESTUDIANTE: ");
        String carrera = sc.nextLine();

        bufferedWriter.write("\n" + nombre.toUpperCase() + " | " + matricula.toUpperCase() + " | " + carrera.toUpperCase());
        bufferedWriter.newLine();
        bufferedWriter.close();

        }

        catch (Exception e) {

        }
    }

    public static void mostrarEstudiantes() {

        try {

        FileReader read = new FileReader("estudiantes.txt");
        String linea;

        BufferedReader buffer = new BufferedReader(read);

        while ((linea=buffer.readLine()) != null) {
            System.out.println(linea);
        }

        read.close();

        }

        catch (Exception e) {

        }
    }
}   
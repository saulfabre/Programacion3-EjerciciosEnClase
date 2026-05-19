import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaMedico sistemaMedico = new SistemaMedico();
        Paciente paciente = new Paciente();

        int opcion;

        do {

            menu();

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    sistemaMedico.registrarPaciente();
                    break;

                case 2:
                    System.out.print("-> Nombre Paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    sistemaMedico.mostrarInformacionPaciente(nombrePaciente);
                    break;

                case 3:
                    System.out.print("-> Peso Paciente: ");
                    double pesoPaciente = scanner.nextDouble();

                    System.out.print("-> Altura Paciente: ");
                    double alturaPaciente = scanner.nextDouble();

                    System.out.println("-> IMC: " + sistemaMedico.calculadoraIMC(alturaPaciente, pesoPaciente));
                    break;

                case 4:
                    System.out.print("-> Nombre Paciente: ");
                    String nombreDetIMC = scanner.nextLine();

                    paciente = sistemaMedico.buscarPacienteRegistrado(nombreDetIMC);

                    if (paciente != null) {

                        System.out.println(sistemaMedico.determinarCondicionPeso(paciente));
                    }

                    else {

                        System.out.println("Paciente No Encontrado, Intente De Nuevo ");
                    }
                    break;

                case 5:
                    sistemaMedico.mostrarInformacionPacientes();
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }

    public static void menu() {

        System.out.println("================================");
        System.out.println("         SISTEMA MEDICO");
        System.out.println("================================");

        System.out.println("[1] Registrar Paciente ");
        System.out.println("[2] Mostrar Informacion Paciente ");
        System.out.println("[3] Calculadora IMC" );
        System.out.println("[4] Determinar IMC");
        System.out.println("[5] Mostrar Pacientes Registrados");
        System.out.println("[6] Salir Del Sistema \n");

        System.out.print("-> Opcion: ");
    }
    
}

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMedico {

    Scanner scanner = new Scanner(System.in);

    ArrayList <Paciente> pacientes = new ArrayList<>();

    public void registrarPaciente() {

        Paciente paciente = new Paciente();

        System.out.print("-> Nombre: ");
        paciente.setNombre(scanner.nextLine());

        System.out.print("-> Edad: ");
        paciente.setEdad(scanner.nextInt());

        System.out.print("-> Peso: ");
        paciente.setPeso(scanner.nextDouble());

        System.out.print("-> Altura: ");
        paciente.setAltura((scanner.nextDouble()));

        scanner.nextLine();

        pacientes.add(paciente);
    
    }

    public void mostrarInformacionPaciente(String nombrePaciente) {

        for (Paciente paciente : pacientes) {

        if (nombrePaciente.equals(paciente.getNombre())) {
    
        System.out.println("================================");
        System.out.println("-> Nombre: " + paciente.getNombre());
        System.out.println("-> Edad: " + paciente.getEdad());
        System.out.println("-> Peso: " + paciente.getPeso());
        System.out.println("-> Altura: " + paciente.getAltura());
        System.out.println("-> IMC: " + calcularIMC(paciente));
        System.out.println("-> Condicion: " + determinarCondicionPeso(paciente));
        System.out.println("================================");

        }
        else {
            System.out.println("-> Paciente No Encontrado, Intente De Nuevo ");
        }
    }      
}

    public double calcularIMC(Paciente paciente) {

        if (paciente.getPeso() < 0 || paciente.getAltura() <= 0) {

            System.out.println("-> Datos Invalidos, Intente De Nuevo ");
            return -1;
        }

        return paciente.getPeso() / (paciente.getAltura() * paciente.getAltura());
    }

    public double calculadoraIMC(double altura, double peso) {

        return peso / (altura * altura);
    }

    public String determinarCondicionPeso(Paciente paciente) {

        double imc = calcularIMC(paciente);

        if (imc < 18.5) {
            return "-> Bajo peso ";
        }

        else if (imc >= 18.5 && imc <= 24.9) {
            return "-> Peso normal ";
        }

        else if (imc >= 25.0 && imc <= 29.9) {
            return "-> Sobrepeso ";
        }

        else {
            return "-> Obesidad";
        }
    }

    public void mostrarInformacionPacientes() {

        for (Paciente paciente : pacientes) {

        System.out.println("================================");
        System.out.println("-> Nombre: " + paciente.getNombre());
        System.out.println("-> Edad: " + paciente.getEdad());
        System.out.println("-> Peso: " + paciente.getPeso());
        System.out.println("-> Altura: " + paciente.getAltura());
        System.out.println("-> IMC: " + calcularIMC(paciente));
        System.out.println("-> Condicion: " + determinarCondicionPeso(paciente));
        System.out.println("================================");

        }
    }

    public Paciente buscarPacienteRegistrado(String nombrePaciente) {

        for (Paciente paciente : pacientes) {
            if (nombrePaciente.equals(paciente.getNombre())) {
                return paciente;
            }
        }
        return null;
    }
}

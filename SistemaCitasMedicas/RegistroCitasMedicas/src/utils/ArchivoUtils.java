package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Cita;

public class ArchivoUtils {

    public static void registrarCita(Cita cita) {

        try {

            FileWriter archivo = new FileWriter("Citas.txt", true);

            archivo.write(cita.getCodigo() + ";" + cita.getNombrePaciente() + ";" + cita.getCedulaPaciente() + ";" + cita.getTelefonoPaciente() + ";" + cita.getNombreMedico() + ";" + cita.getEspecialidadMedico() + ";" + cita.getFecha() + ";" + cita.getHora() + ";" + cita.getMotivoConsulta() + ";" + cita.getEstado() + "\n");

            archivo.close();
                          
        } catch (Exception e) {

            System.out.println("Error al guardar en archivo: " + e);
        }
    }

    public static ArrayList<Cita> consultarCitas() {

        ArrayList<Cita> citas = new ArrayList<>();

        try {

            FileReader archivo = new FileReader("Citas.txt");

            BufferedReader lector = new BufferedReader(archivo);

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(";");

                citas.add(

                    new Cita(

                        Integer.parseInt(partes[0]),
                        partes[1],
                        Long.parseLong(partes[2]),
                        Long.parseLong(partes[3]),
                        partes[4],
                        partes[5],
                        LocalDate.parse(partes[6]),
                        LocalTime.parse(partes[7]),
                        partes[8],
                        partes[9]
                ));
            }
            archivo.close();

            lector.close();

        } catch (IOException e) {

            System.out.println("Error al cargar el archivo. " + e);
        }

        return citas;
    }
}

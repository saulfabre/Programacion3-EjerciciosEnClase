package controller;

import java.time.DateTimeException;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Cita;
import utils.ArchivoUtils;

public class RegistroCitaController {

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextArea taMotivoConsulta;

    @FXML
    private Label lblEstado;

    @FXML
    private TextField tfCodigoCita;

    @FXML
    private TextField tfNombrePaciente;

    @FXML
    private TextField tfCedulaPaciente;

    @FXML
    private TextField tfTelefonoPaciente;

    @FXML
    private TextField tfHoraCita;

    @FXML
    private ComboBox<String> cbMedico;

    @FXML
    private ComboBox<String> cbEspecialidad;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    public void initialize() {

        ObservableList<String> medicos = FXCollections.observableArrayList("Juan Perez", "Jose Lopez", "Maria Altagracia");

        cbMedico.setItems(medicos);

        ObservableList<String> especialidades = FXCollections.observableArrayList("Pediatra", "Ginecologia", "Dermatologia");

        cbEspecialidad.setItems(especialidades);

        ObservableList<String> estados = FXCollections.observableArrayList("Programada", "Atendida", "Cancelada");

        cbEstado.setItems(estados);
    }

    @FXML
    private void guardarCita() {

        if (tfCodigoCita.getText().isBlank()) {

            lblEstado.setText("Es obligatorio ingresar un código de cita.");
            return;
        }

        else if (tfNombrePaciente.getText().isBlank()) {

            lblEstado.setText("Es obligatorio ingresar un nombre de paciente.");
            return;
        }

        else if (tfCedulaPaciente.getText().isBlank()) {

            lblEstado.setText("Es obligatorio ingresar una cédula de paciente.");
            return;
        }

        else if (tfTelefonoPaciente.getText().isBlank()) {

            lblEstado.setText("Es obligatorio ingresar un teléfono de paciente.");
            return;
        }

        else if (tfHoraCita.getText().isBlank()) {

            lblEstado.setText("Es obligatorio ingresar una hora de cita.");
            return;
        }

        else if (cbMedico.getValue() == null) {

            lblEstado.setText("Debe seleccionar un médico.");
            return;
        }

        else if (cbEspecialidad.getValue() == null) {

            lblEstado.setText("Debe seleccionar una especialidad.");
            return;
        }

        else if (cbEstado.getValue() == null) {

            lblEstado.setText("Debe seleccionar un estado.");
            return;
        }

        else if (dpFecha.getValue() == null) {

            lblEstado.setText("Debe seleccionar una fecha.");
            return;
        }

        else if (taMotivoConsulta.getText().isBlank()) {

            lblEstado.setText("Debe ingresar el motivo de consulta.");
            return;
        }

        try {

            int codigo = Integer.parseInt(tfCodigoCita.getText());

            long cedula = Long.parseLong(tfCedulaPaciente.getText());

            long numero = Long.parseLong(tfTelefonoPaciente.getText());

            LocalTime hora = LocalTime.parse(tfHoraCita.getText());
            
            ObservableList<Cita> citas = FXCollections.observableArrayList(ArchivoUtils.consultarCitas());


            for (Cita cita : citas) {

                if (cita.getCodigo() == codigo) {

                    lblEstado.setText("El código de la cita ya existe.");
                    return;
                }
            }

            ArchivoUtils.registrarCita(

                new Cita(

                    codigo,
                    tfNombrePaciente.getText(),
                    cedula,
                    numero,
                    cbMedico.getValue(),
                    cbEspecialidad.getValue(),
                    dpFecha.getValue(),
                    hora,
                    taMotivoConsulta.getText(),
                    cbEstado.getValue()
                ));

            lblEstado.setText("Cita registrada correctamente.");

        } catch (NumberFormatException | DateTimeException e) {

            lblEstado.setText("Formato de dato inválido.");
        }
    }   
}

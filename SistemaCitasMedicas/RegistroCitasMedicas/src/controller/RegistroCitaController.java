package controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import exception.CitaDuplicadaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Cita;
import utils.ArchivoUtils;
import utils.Navegacion;

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

            mostrarAviso("Es obligatorio ingresar un código de cita.");
            lblEstado.setText("Es obligatorio ingresar un código de cita.");
            return;
        }

        else if (tfNombrePaciente.getText().isBlank()) {

            mostrarAviso("Es obligatorio ingresar un nombre de paciente.");
            lblEstado.setText("Es obligatorio ingresar un nombre de paciente.");
            return;
        }

        else if (tfCedulaPaciente.getText().isBlank()) {

            mostrarAviso("Es obligatorio ingresar una cédula de paciente.");
            lblEstado.setText("Es obligatorio ingresar una cédula de paciente.");
            return;
        }

        else if (tfTelefonoPaciente.getText().isBlank()) {

            mostrarAviso("Es obligatorio ingresar un teléfono de paciente.");
            lblEstado.setText("Es obligatorio ingresar un teléfono de paciente.");
            return;
        }

        else if (tfHoraCita.getText().isBlank()) {

            mostrarAviso("Es obligatorio ingresar una hora de cita.");
            lblEstado.setText("Es obligatorio ingresar una hora de cita.");
            return;
        }

        else if (cbMedico.getValue() == null) {

            mostrarAviso("Debe seleccionar un médico.");
            lblEstado.setText("Debe seleccionar un médico.");
            return;
        }

        else if (cbEspecialidad.getValue() == null) {

            mostrarAviso("Debe seleccionar una especialidad.");
            lblEstado.setText("Debe seleccionar una especialidad.");
            return;
        }

        else if (cbEstado.getValue() == null) {

            mostrarAviso("Debe seleccionar un estado.");
            lblEstado.setText("Debe seleccionar un estado.");
            return;
        }

        else if (dpFecha.getValue() == null) {

            mostrarAviso("Debe seleccionar una fecha.");
            lblEstado.setText("Debe seleccionar una fecha.");
            return;
        }

        else if (dpFecha.getValue().isBefore(LocalDate.now())) {

            mostrarAviso("La fecha es menor que la actual.");
            lblEstado.setText("La fecha es menor que la actual.");
            return;
        }

        else if (taMotivoConsulta.getText().isBlank()) {

            mostrarAviso(("Debe ingresar el motivo de consulta."));
            lblEstado.setText("Debe ingresar el motivo de consulta.");
            return;
        }

        try {

            int codigo = Integer.parseInt(tfCodigoCita.getText());

            long cedula = Long.parseLong(tfCedulaPaciente.getText());

            long numero = Long.parseLong(tfTelefonoPaciente.getText());

            LocalTime hora = LocalTime.parse(tfHoraCita.getText());
            
            ObservableList<Cita> citas = FXCollections.observableArrayList(ArchivoUtils.consultarCitas());

            try {

            for (Cita cita : citas) {

                if (cita.getCodigo() == codigo) {

                    throw new CitaDuplicadaException("El código de la cita ya existe.");
                }

                    else if (cita.getNombreMedico().equals(cbMedico.getValue()) && cita.getFecha().equals(dpFecha.getValue()) && cita.getHora().equals(hora)) {

                        throw new CitaDuplicadaException("Espacio ocupado.");
                    }
                }

            } catch (CitaDuplicadaException e) {

                mostrarAviso(e.getMessage());
                lblEstado.setText(e.getMessage());
                return;
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

            mostarInformacion("Cita registrada correctamente.");

            lblEstado.setText("Cita registrada correctamente.");

        } catch (NumberFormatException | DateTimeException e) {

            mostrarError("Formato de dato inválido.");

            lblEstado.setText("Formato de dato inválido.");
        }
    }   


    @FXML
    private void limpiarRegistro() {

        tfCodigoCita.clear();
        tfNombrePaciente.clear();
        tfCedulaPaciente.clear();
        tfTelefonoPaciente.clear();
        tfHoraCita.clear();
        cbMedico.setValue(null);;
        cbEspecialidad.setValue(null);
        cbEstado.setValue(null);
        dpFecha.setValue(null);
        taMotivoConsulta.clear();
    }

    @FXML
    private void abrirCitas() {

        Navegacion.abrirVentana("/view/consulta_cita.fxml", "Citas");
    }

    @FXML
    private void mostrarError(String mensaje) {

        Alert alerta = new Alert(AlertType.ERROR);

        alerta.setTitle("Error");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    @FXML
    private void mostarInformacion(String mensaje) {

        Alert alerta = new Alert(AlertType.INFORMATION);

        alerta.setTitle("Información");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    @FXML
    private void mostrarAviso(String mensaje) {

        Alert alerta = new Alert(AlertType.WARNING);

        alerta.setTitle("Aviso");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}

package controller;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cita;
import utils.ArchivoUtils;
import utils.Navegacion;

public class ConsultaCitaController {

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private TableColumn<Cita, Integer> colCodigo;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    private TableColumn<Cita, LocalTime> colHora;

    @FXML
    private TableColumn<Cita, String> colEstado;

    @FXML
    private Label lblEstado;

    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("nombrePaciente"));
        colMedico.setCellValueFactory(new PropertyValueFactory<>("nombreMedico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidadMedico"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    @FXML
    private void consultarCitas() {

        ObservableList<Cita> citas = FXCollections.observableArrayList(ArchivoUtils.consultarCitas());

        tablaCitas.setItems(citas);
    }

    @FXML
    private void cancelarCita() {

        Cita cita = tablaCitas.getSelectionModel().getSelectedItem();

        if (cita == null) {

            mostrarAviso("Debe seleccionar una cita.");
            lblEstado.setText("Debe seleccionar una cita.");
            return;
        }

        cita.setEstado("Cancelada");

        tablaCitas.refresh();

        mostarInformacion("Cita cancelada correctamente.");
        lblEstado.setText("Cita cancelada correctamente.");    
    }

    @FXML
    private void abrirRegistro() {

        Navegacion.abrirVentana("/view/registro_cita.fxml", "Registro");
    }

    @FXML
    private void mostrarAviso(String mensaje) {

        Alert alerta = new Alert(AlertType.WARNING);

        alerta.setTitle("Aviso");

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
    
}

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ConversorMonedasController {

    @FXML
    private TextField tfMonto;

    @FXML
    private ComboBox<String> cbMonedas;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblEstado;

    @FXML
    private void convertirMoneda() {

        if (tfMonto.getText().isEmpty()) {
            lblEstado.setText("Debe ingresar un monto.");
            return;
        }

        double monto;

        try {
            monto = Double.parseDouble(tfMonto.getText());
        } catch (NumberFormatException e) {
            lblEstado.setText("El monto debe ser numérico.");
            return;
        }

        String monedaDestino = cbMonedas.getValue();

        if (monedaDestino == null) {
            lblEstado.setText("Debe seleccionar una moneda.");
            return;
        }

        double resultado = 0;

        if (monedaDestino.equals("USD")) {
            resultado = monto / 59.00;
        }

        if (monedaDestino.equals("EUR"))  {
            resultado = monto / 64.00;
        }

        lblResultado.setText("Resultado: " + String.format("%.2f", resultado));
        lblEstado.setText("Conversión realizada correctamente.");
    }

    @FXML
    private void ejecutarConversionEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            convertirMoneda();
        }
    }

    @FXML
    private void limpiar() {

        tfMonto.clear();
        cbMonedas.getSelectionModel().clearSelection();
        lblResultado.setText("");
        lblEstado.setText("Esperando información...");
    }

    @FXML
    private void mouseEntrandoConvertir(MouseEvent event) {
        
        lblEstado.setText("Presione para realizar la conversión.");
    }

    @FXML
    private void mouseSaliendoConvertir(MouseEvent event) {

        lblEstado.setText("Esperando información...");
    }
}

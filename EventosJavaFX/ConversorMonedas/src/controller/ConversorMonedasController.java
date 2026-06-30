package controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void convertirMoneda() {

        if (tfMonto.getText().isEmpty()) {
            lblEstado.setText("Debe ingresar un monto.");
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

        lblResultado.setText("Resultado: " + resultado);
        lblEstado.setText("Conversión realizada correctamente.");
    }
}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class compra implements Initializable {

    @FXML
    private TextField tfNombre;

    @FXML
    private ComboBox<String> cbBebidas;

    @FXML
    private TextField tfCantidad;

    @FXML
    private CheckBox cbPostre;

    @FXML
    private Label lblResumen;

    @FXML
    private Label lblEstado;

    @FXML 
    private Button btnCalcular;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbBebidas.setItems(FXCollections.observableArrayList("Café americano | RD$100", "Cappuccino | RD$150", "Chocolate caliente | RD$130", "Jugo natural | RD$120"));
    }

    @FXML
    private void calcularCompra() {

        if (tfNombre.getText().isEmpty()) {

            lblEstado.setText("Debe ingresar un nombre.");
            return;
        }

        if (cbBebidas.getValue() == null) {

            lblEstado.setText("Debe seleccionar una bebida.");
            return;
        }

        if (tfCantidad.getText().isEmpty()) {

            lblEstado.setText("Debe ingresar una cantidad.");
        }

        int cantidad = 0;

        try {

            cantidad = Integer.parseInt(tfCantidad.getText());

        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }

        } catch(NumberFormatException e) {

            lblEstado.setText("La cantidad debe ser numérica.");
            return;
        }

        int subtotal = 0;

        switch (cbBebidas.getValue()) {
            case "Café americano | RD$100":
                subtotal = cantidad * 100;
                break;

            case ("Cappuccino | RD$150"):
                subtotal = cantidad * 150;
                break;

            case ("Chocolate caliente | RD$130"):
                subtotal = cantidad * 130;
                break;

            case ("Jugo natural | RD$120"):
                subtotal = cantidad * 120;
                break;
        }

        if (cbPostre.isSelected()) {
            lblResumen.setText("Total: " + (subtotal + 75));
        }

        else {
            lblResumen.setText(("Total: " + subtotal));
        }
    }

    @FXML
    private void mouseEntrandoCalcular(MouseEvent event) {

        lblEstado.setText("Presione para calcular el total de la compra.");
    }

    @FXML
    private void mouseSaliendoCalcular(MouseEvent event) {

        lblEstado.setText(("Esperando datos de la compra..."));
    }

    @FXML
    private void calcularCompraEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            calcularCompra();
        }
    }

    @FXML
    private void limpiar() {

        tfNombre.clear();
        cbBebidas.setValue(null);;
        tfCantidad.clear();
        cbPostre.setSelected(false);
        lblResumen.setText("Resumen:");
        lblEstado.setText("Esperando datos de la compra...");
    }
}

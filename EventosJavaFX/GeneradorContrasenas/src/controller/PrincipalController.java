package controller;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    private boolean mensajeResultado = false;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField tfLongitud;

    @FXML
    private CheckBox cbMayusculas;

    @FXML
    private CheckBox cbNumeros;

    @FXML
    private CheckBox cbSimbolos;

    @FXML
    private void mouseEntrando(MouseEvent event) {

        if (mensajeResultado == false) {

        lblResultado.setText("Presione para generar una nueva contraseña.");
        }
    }

    @FXML
    private void mouseSaliendo(MouseEvent event) {

        if (mensajeResultado == false) {

        lblResultado.setText("Esperando configuración...");
        }
    }

    @FXML 
    private void generar() {

        if (tfLongitud.getText().isEmpty()) {

            lblResultado.setText("La longitud no puede estar vacía.");
            return;
        }

        int longitud = 0;
        
        try {

            longitud = Integer.parseInt(tfLongitud.getText());

        } catch(NumberFormatException e) {

            lblResultado.setText("La longitud debe ser numérica.");
            return;
        }

        if (longitud < 6) {

            lblResultado.setText("La longitud debe ser mayor o igual a 6.");
            return;

        }

        String letrasMinisculas = "abcdefghijklmnopqrstuvwxyz";
        String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*?";

        String caracteres = letrasMinisculas;

        if (cbMayusculas.isSelected()) {

            caracteres+= letrasMayusculas;
        }

        if (cbNumeros.isSelected()) {

            caracteres+= numeros;
        }

        if (cbSimbolos.isSelected()) {

            caracteres+= simbolos;
        }

        Random rnd = new Random();

        String contrasena = "";

        for (int i = 0; i < longitud; i++) {

            int pos = rnd.nextInt(caracteres.length());

            contrasena = contrasena + caracteres.charAt(pos);
        }

        lblResultado.setText(contrasena);
        mensajeResultado = true;
    }

    @FXML
    private void limpiar() {

        tfLongitud.clear();
        cbMayusculas.setSelected(false);
        cbNumeros.setSelected(false);
        cbSimbolos.setSelected(false);
        lblResultado.setText("Esperando configuración...");
        mensajeResultado = false;
    }

    @FXML
    private void generarEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            generar();
        }
    }   
}

package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class MainController implements Initializable {

    @FXML
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, botonAC, botonBorrarRegistro, botonDividir, botonE, botonElevar, botonExponencial, botonFactorizar, botonIgual, botonLogaritmo, botonMultiplicar, botonOcultarSCI, botonPorcentaje, botonPunto, botonRaizCuadrada, botonRegister, botonRestar, botonSCI, botonSeno, botonSigno, botonSumar, botonCerrarRegistro;

    @FXML
    private TextArea textareaRegistro;

    @FXML
    private TextField textfieldResultado;

    @FXML
    private GridPane desplegableResultado, desplegableSCI, pantallaPrincipal;

    @FXML
    private BorderPane pantallaEntera;

    private String signo;
    private double primeraCifra, segundaCifra = 0.0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        acciones();
    }


    private void initGUI() {
        pantallaEntera.getChildren().remove(desplegableSCI);
        pantallaEntera.getChildren().remove(desplegableResultado);
    }


    private void acciones() {

        boton0.setOnAction(new ManejoPulsaciones());
        boton1.setOnAction(new ManejoPulsaciones());
        boton2.setOnAction(new ManejoPulsaciones());
        boton3.setOnAction(new ManejoPulsaciones());
        boton4.setOnAction(new ManejoPulsaciones());
        boton5.setOnAction(new ManejoPulsaciones());
        boton6.setOnAction(new ManejoPulsaciones());
        boton7.setOnAction(new ManejoPulsaciones());
        boton8.setOnAction(new ManejoPulsaciones());
        boton9.setOnAction(new ManejoPulsaciones());
        botonDividir.setOnAction(new ManejoPulsaciones());
        botonMultiplicar.setOnAction(new ManejoPulsaciones());
        botonRestar.setOnAction(new ManejoPulsaciones());
        botonSumar.setOnAction(new ManejoPulsaciones());
        botonElevar.setOnAction(new ManejoPulsaciones());
        botonExponencial.setOnAction(new ManejoPulsaciones());
        botonRaizCuadrada.setOnAction(new ManejoPulsaciones());
        botonSeno.setOnAction(new ManejoPulsaciones());
        botonLogaritmo.setOnAction(new ManejoPulsaciones());
        botonIgual.setOnAction(new ManejoPulsaciones());
        botonAC.setOnAction(new ManejoPulsaciones());
        botonPunto.setOnAction(new ManejoPulsaciones());
        botonE.setOnAction(new ManejoPulsaciones());
        botonPorcentaje.setOnAction(new ManejoPulsaciones());
        botonSCI.setOnAction(new ManejoPulsaciones());
        botonOcultarSCI.setOnAction(new ManejoPulsaciones());
        botonRegister.setOnAction(new ManejoPulsaciones());
        botonCerrarRegistro.setOnAction(new ManejoPulsaciones());
        botonBorrarRegistro.setOnAction(new ManejoPulsaciones());


    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == boton0) {
                textfieldResultado.appendText("0");
                textareaRegistro.appendText("0");
            }
            else if (event.getSource() == boton1) {
                textfieldResultado.appendText("1");
                textareaRegistro.appendText("1");
            }
            else if (event.getSource() == boton2) {
                textfieldResultado.appendText("2");
                textareaRegistro.appendText("2");
            }
            else if (event.getSource() == boton3) {
                textfieldResultado.appendText("3");
                textareaRegistro.appendText("3");
            }
            else if (event.getSource() == boton4) {
                textfieldResultado.appendText("4");
                textareaRegistro.appendText("4");
            }
            else if (event.getSource() == boton5) {
                textfieldResultado.appendText("5");
                textareaRegistro.appendText("5");
            }
            else if (event.getSource() == boton6) {
                textfieldResultado.appendText("6");
                textareaRegistro.appendText("6");
            }
            else if (event.getSource() == boton7) {
                textfieldResultado.appendText("7");
                textareaRegistro.appendText("7");
            }
            else if (event.getSource() == boton8) {
                textfieldResultado.appendText("8");
                textareaRegistro.appendText("8");
            }
            else if (event.getSource() == boton9) {
                textfieldResultado.appendText("9");
                textareaRegistro.appendText("9");
            }
            else if (event.getSource() == botonSCI) {
                pantallaEntera.setLeft(desplegableSCI);
            }
            else if (event.getSource() == botonOcultarSCI) {
                pantallaEntera.getChildren().remove(desplegableSCI);
            }
            else if (event.getSource() == botonRegister) {
                pantallaEntera.setRight(desplegableResultado);
            }
            else if (event.getSource() == botonCerrarRegistro) {
                pantallaEntera.getChildren().remove(desplegableResultado);
            }
            else if (event.getSource() == botonDividir) {
                textareaRegistro.appendText("/");
                signo = "/";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonMultiplicar) {
                textareaRegistro.appendText("x");
                signo = "x";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonRestar) {
                textareaRegistro.appendText("-");
                signo = "-";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonSumar) {
                textareaRegistro.appendText("+");
                signo = "+";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonElevar) {
                textareaRegistro.appendText("^");
                signo = "^";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonExponencial) {
                textareaRegistro.appendText("E");
                signo = "E";
                primeraCifra = Double.valueOf(textfieldResultado.getText());
                textfieldResultado.setText("");
            }
            else if (event.getSource() == botonRaizCuadrada) {
                textfieldResultado.appendText("√");
                signo = "√";
            }
            else if (event.getSource() == botonSeno) {
                textareaRegistro.appendText("sin ");
                signo = "sin";
            }
            else if (event.getSource() == botonLogaritmo) {
                textareaRegistro.appendText("ln ");
                signo = "ln";
            }
            else if (event.getSource() == botonAC) {
                textfieldResultado.setText("");
                primeraCifra = 0.0;
                segundaCifra = 0.0;
                botonPunto.setDisable(false);
            }
            else if (event.getSource() == botonBorrarRegistro) {
                textareaRegistro.setText("");
            }
            else if (event.getSource() == botonPunto) {
                textfieldResultado.appendText(".");
                botonPunto.setDisable(false);
            }
            else if (event.getSource() == botonE) {
                textfieldResultado.appendText(String.valueOf(Math.E));
            }
            else if (event.getSource() == botonPorcentaje) {
                textareaRegistro.appendText(textfieldResultado.getText());
                textfieldResultado.setText(String.valueOf(Double.valueOf(textfieldResultado.getText())*0.01));
                textareaRegistro.appendText("*0.01="+textfieldResultado.getText()+"\n");
            }
            else if (event.getSource() == botonIgual) {
                 if(signo.equals("√")){
                    String partes[] = textfieldResultado.getText().split("√");
                    double primeraCifra = parseDouble(partes[1]);
                    textareaRegistro.appendText(textfieldResultado.getText());
                    textareaRegistro.appendText("=");
                    textfieldResultado.setText(String.valueOf(Math.sqrt(primeraCifra)));
                    textareaRegistro.appendText( " √ " +textfieldResultado.getText() + "\n") ;
                    }

                     segundaCifra = Double.valueOf(textfieldResultado.getText());

                      if (signo.equals("+")) {
                         textfieldResultado.setText(String.valueOf(primeraCifra + segundaCifra));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     } else if (signo.equals("x")) {
                         textfieldResultado.setText(String.valueOf(primeraCifra * segundaCifra));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     } else if (signo.equals("-")) {
                         textfieldResultado.setText(String.valueOf(primeraCifra - segundaCifra));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     } else if (signo.equals("/")) {
                         textfieldResultado.setText(String.valueOf(primeraCifra / segundaCifra));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     } else if (signo.equals("E")) {
                         double elevado = Math.pow(10, segundaCifra);
                         textfieldResultado.setText(String.valueOf(primeraCifra * elevado));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     } else if (signo.equals("^")) {
                         textfieldResultado.setText(String.valueOf(Math.pow(primeraCifra, segundaCifra)));
                         textareaRegistro.appendText(" = " + textfieldResultado.getText() + "\n");
                     }

            }


        }


    }
}
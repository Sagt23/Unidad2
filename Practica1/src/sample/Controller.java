package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML TextField txtTexto;
    @FXML ComboBox idCmb;
    @FXML Label lblResultado;
    @FXML protected void initialize (){
        idCmb.getItems().addAll("db", "count", "Dos nombres", "MAC", "Aa", "Binario", "Hexadecimal", "Operacion", "No. control", "CURP",
                "Pesos", "Tarjeta", "HTML", "Hexa", "Link", "Query", "If", "Salto", "YouTube");
    }
    public void procesar(){
        int seleccion=idCmb.getSelectionModel().getSelectedIndex();
        String texto= txtTexto.getText();
        String expresion="";
        switch (seleccion){
            case 0:{
                expresion="^[^db][A-Za-z0-9]";
                break;
            }
            case 1: {
                expresion="[A-Za-z0-9][count]$";
                break;
            }
            case 2: {
                expresion="";
                break;
            }
            case 3: {
                expresion="[a-zA-Z0-9]{12}";
                break;
            }
            case 4: {
                expresion="^[A-Z][a-bA-Z]$";
                break;
            }
            case 5: {
                expresion="[0-1]{8}";
                break;
            }
            case 6: {
                expresion="[A-F0-9]";
                break;
            }
            case 7: {
                expresion="";
                break;
            }
            case 8: {
                expresion="^[18CG][0-9]{8}";
                break;
            }
            case 9: {
                expresion="";
                break;
            }
            case 10: {
                expresion="^[$][0-9]";
                break;
            }
            case 11: {
                expresion="[0-9]{16}";
                break;
            }
            case 12: {
                expresion="^[<][a-z][>]$";
                break;
            }
            case 13: {
                expresion="^[#][A-F0-9]{7}";
                break;
            }
            case 14: {
                expresion="^[https://][a-zA-Z0-9][.com]$";
                break;
            }
            case 15: {
                expresion="";
                break;
            }
            case 16: {
                expresion="";
                break;
            }
            case 17: {
                expresion="";
                break;
            }
            case 18: {
                expresion="^[https://www.youtube.com/watch?][a-zA-Z0-9]{13}$";
                break;
            }
        }
        Pattern patron=Pattern.compile(expresion);
        Matcher matcher=patron.matcher(texto);
        if (matcher.matches()){
            lblResultado.setText("Si cumple");
        }else {
            lblResultado.setText("No cumple");
        }
    }
}

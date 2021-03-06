package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML TextField txtTexto;
    @FXML ListView listaEjer;
    @FXML Label lblResultado;
    @FXML protected void initialize(){
        listaEjer.getItems().addAll("Ejercicio 1", "Ejercicio 2", "Validar password");
    }
    public void procesar(ActionEvent event){
        int seleccion= listaEjer.getSelectionModel().getSelectedIndex();
        String texto= txtTexto.getText();
        String expresion="";
        switch (seleccion){
            case 0:{
                expresion="^[^_][^p]([a-zA-Z0-9]{3,})[q|w]$";
                break;
            }
            case 1:{
                expresion="\\+[a-zA-Z]+";
                break;
            }
            case 2:{
                expresion="[^.]*";
                break;
            }
        }
        Pattern patron= Pattern.compile(expresion);
        Matcher matcher= patron.matcher(texto);
        if (matcher.matches()){
            lblResultado.setText("Si cumple");
        }else {
            lblResultado.setText("No cumple");
        }
    }
}

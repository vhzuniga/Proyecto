/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyecto.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class 
 *
 * @author Victor Zuñiga
 */
public class EvaluacionController implements Initializable {

    @FXML
    private ComboBox<?> cbxJurado;
    @FXML
    private ComboBox<?> cbxInscripcion;
    @FXML
    private ComboBox<?> cbxCriterio;
    @FXML
    private Button btnEvaluar;
    @FXML
    private TextField txtNota;
    @FXML
    private Button btnMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarJurado(ActionEvent event) {
    }

    @FXML
    private void cambiarInscripcion(ActionEvent event) {
    }

    @FXML
    private void cambiarCriterio(ActionEvent event) {
    }

    @FXML
    private void swtichToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    private void Guardar(ActionEvent event) {
        //int idEvalucion, int idMiembroJurado, int idInscripcion, double calificacion, int idCriterio
        Double cali=Double.parseDouble(txtNota.getText());
        
      
    }
    
}

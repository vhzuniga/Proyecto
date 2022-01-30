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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DueñoController implements Initializable {

    @FXML
    private Button btnMenu;
    @FXML
    private Button btnCambios;
    @FXML
    private HBox hboxDueños;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void swtichToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    private void GuardarCambios(ActionEvent event) {
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;


import ec.edu.espol.model.Concurso;

import ec.edu.espol.proyecto.App;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ConcursoController implements Initializable {

    @FXML

    private ComboBox<Concurso> cbxConcursos;
    
    @FXML
    private VBox vbxinfo;

    private Button btnMenu;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");      
        cbxConcursos.setItems(FXCollections.observableArrayList(concursos));
        Label informacion= new Label();
        informacion.setText("Información");
        vbxinfo.getChildren().add(informacion);
        //Concurso con = ((Concurso)cbxConcursos.getValue());
        
        //vbxinfo.(cbxConcursos.getSelectionModel();)
        
        
        
        
        
 
    }

    @FXML
    private void Principal(MouseEvent event) {
    }

    @FXML
    private void cambiar(ActionEvent event) {
        vbxinfo.getChildren().clear();
        
        Label informacion= new Label();
        informacion.setText("Información");
        vbxinfo.getChildren().add(informacion);
        //Label.
        
//for(Concurso c: )falta hacer que al escoger el concurso aparezca la información en el vbox
    }

        // TODO
    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }
}    

    
    



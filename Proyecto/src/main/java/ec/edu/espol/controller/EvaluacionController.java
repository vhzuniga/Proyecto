/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import static ec.edu.espol.controller.MascotasController.cargarImagenes;
import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.proyecto.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private ComboBox<MiembroJurado> cbxJurado;
    @FXML
    private ComboBox<Inscripcion> cbxInscripcion;
    @FXML
    private ComboBox<Criterio> cbxCriterio;
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
        //ArrayList<MiembroJurado> miembroJ = MiembroJurado.readFromFile("miembroJurados.txt");
        //cbxJurado.getItems().add(miembroJ);
        //ArrayList<Inscripcion> inscripciones = Inscripcion.readFromFile("inscripciones.txt");
        //cbxInscripcion.setItems(FXCollections.observableArrayList(inscripciones));
        //ArrayList<Criterio> criterios = Criterio.readFromFile("criterios.txt");
        //cbxCriterio.setItems(FXCollections.observableArrayList(criterios));
        
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
        int ide = Util.nextID("evaluaciones.txt");
        int idMiembroJurado =cbxJurado.getValue().getId();
        int idInscripcion = cbxInscripcion.getValue().getIdInscripcion();
        Double cali=Double.parseDouble(txtNota.getText());
        int idCriterio= cbxCriterio.getValue().getIdCriterio();
        Evaluacion evaluaciones = new Evaluacion(ide,idMiembroJurado,idInscripcion,cali,idCriterio);
        evaluaciones.saveFile("evaluaciones.txt");
        
        
        
      
    }
    
}

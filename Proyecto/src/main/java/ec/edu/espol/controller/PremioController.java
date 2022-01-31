/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Premio;
import ec.edu.espol.proyecto.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Victor Zuñiga
 */
public class PremioController implements Initializable {

    @FXML
    private ComboBox<Concurso> cbxConsulta;
    @FXML
    private Button btnConsulta;
    @FXML
    private Button btnMenu;
    @FXML
    private ScrollPane scPremio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");
        cbxConsulta.getItems().addAll(concursos);

    }

    @FXML
    private void cambiarConcurso(ActionEvent event) {
    }

    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    private void consultar(ActionEvent event) {
        int idConcurso = cbxConsulta.getValue().getIdConcurso();
        ArrayList<Premio> premios = Premio.readFromFile("premios.txt");
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");

        VBox vb = new VBox();
        for (Premio p : premios) {
            int co;
            Premio premi = new Premio(0,p.getIdConcurso(),p.getPuesto(),p.getDescripcion());
            for(Concurso c : concursos){
            c.equals(cbxConsulta.getValue());
            
            }
            Text tx = new Text(premi.toString());
            tx.setWrappingWidth(scPremio.getWidth());
            vb.getChildren().add(tx);
                
        }
        scPremio.setContent(vb);
        


    }
    private Double notaMasAlta(ArrayList<Evaluacion> eva, Concurso c){
        ArrayList<Double> notas = new ArrayList<>();
        for(Evaluacion v: eva){
            if(c.getIdConcurso()== v.getInscripcion().getIdConcurso()){
                
                Double nota= v.getCalificacion();
                notas.add(nota);
                return Collections.max(notas);
            }
        }
        return 0.0;
        
        
    }
}

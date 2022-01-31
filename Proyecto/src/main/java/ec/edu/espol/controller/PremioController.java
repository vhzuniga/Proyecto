/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.Premio;
import ec.edu.espol.proyecto.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane txtPane;
    

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
        Concurso c1 = cbxConsulta.getValue();
        ArrayList<Inscripcion> inscripciones = Inscripcion.readFromFile("inscripciones.txt");
        ArrayList<Mascota> mascotas = Mascota.readFromFile("mascotas.txt");
        //int id, int idConcurso, int puesto, String descripcion
        for(Inscripcion i1: inscripciones){
            for(Mascota m1: mascotas)
            if(i1.getIdConcurso()==c1.getIdConcurso() && i1.getIdMascota()==m1.getIdMascota()){
                Text txt = new Text(m1.toString());
                txtPane.getChildren().add(txt);
            }
            
        }
        
        
        //Concurso con;
        //int idC = 0;
        //idC = con.getIdConcurso();
        //if(idCon)
            //Dueño dueno;
            //int idD = 0
            //idD = dueno.getId();
//        VBox vb = new VBox();   
//        for(Premio p: premios){
//            Text tx = new Text(p.toString());
//            tx.setWrappingWidth(scPremio.getWidth());
//            vb.getChildren().add(tx);
//        }
//        scPremio.setContent(vb);
        
    }
}

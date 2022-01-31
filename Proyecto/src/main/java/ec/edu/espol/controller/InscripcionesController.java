/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import static ec.edu.espol.controller.MascotasController.cargarImagenes;
import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.ConcursoException;
import ec.edu.espol.model.Dueño;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.proyecto.App;
import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class InscripcionesController implements Initializable {

    @FXML
    private Button btnMenu;
    @FXML
    private Button btnMascota;
    @FXML
    private ComboBox<String> cbxAño;
    @FXML
    private ComboBox<String> cbxMes;
    @FXML
    private ComboBox<String> cbxDía;
    @FXML
    private ComboBox<Mascota> cbxMascota;
    @FXML
    private Label lbValor;
    @FXML
    private TextField txtnumero;
    @FXML
    private ComboBox<Concurso> cbxConcursos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> dias = cargarImagenes("dia.txt");
        cbxDía.getItems().addAll(dias);
        ArrayList<String> meses = cargarImagenes("mes.txt");
        cbxMes.getItems().addAll(meses);
        ArrayList<String> año = cargarImagenes("año.txt");
        cbxAño.getItems().addAll(año);
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");
        
        cbxConcursos.getItems().addAll(concursos);
        ArrayList<Mascota> mascotas = Mascota.readFromFile("mascotas.txt");
        cbxMascota.getItems().addAll(mascotas);
        
    }

    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }
    
    public static ArrayList<String> cargarImagenes(String nombreArchivo) {
        ArrayList<String> imagenes = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))){
            String line;
            while((line = bf.readLine())!= null){
                String[] imagen = line.split(",");
                for(int i=0; i<imagen.length; i++){
                    imagenes.add(imagen[i]);
                }
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return imagenes;
    }
    

    @FXML
    private void switchToMascota(ActionEvent event) throws IOException {
        App.setRoot("Mascotas");
    }

    @FXML
    private void Guardar(ActionEvent event) {
        
        
        int idm = Util.nextID("inscripciones.txt");
        int idConcurso = cbxConcursos.getValue().getIdConcurso();
        int idMascota= cbxMascota.getValue().getIdMascota();
        String fecha= cbxAño.getValue()+"-"+cbxMes.getValue()+"-"+cbxDía.getValue();
        LocalDate fn= LocalDate.parse(fecha);
        Double descuento = 5.0;
        Double numero = Double.parseDouble(txtnumero.getText());
        Double costo = 20.0;
        if(numero>1)
            costo = costo-descuento;
        else
            costo = costo;
        
            
        
        String precioFinal = String.valueOf(costo);
        lbValor.setText(precioFinal);
        Inscripcion ins = new Inscripcion(idm,idMascota, idConcurso, fn,costo);
        
        try{
        ArrayList<Inscripcion> inscripciones= Inscripcion.readFromFile("inscripciones.txt");
        if(inscripciones.contains(ins)){
            Alert error= new Alert(Alert.AlertType.ERROR, "La mascota ya ha sido registrada en este concurso");
            error.show();
            
            
        }else{
            ins.saveFile("inscripciones.txt");
            
        }
        }catch(ConcursoException io){
            ins.saveFile("inscripciones.txt");
        }
    }

    @FXML
    private void cambiar(ActionEvent event) {
    }
    
    
    
    
}

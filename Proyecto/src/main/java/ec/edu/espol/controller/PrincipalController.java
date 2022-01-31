package ec.edu.espol.controller;

import ec.edu.espol.model.ConcursoException;
import ec.edu.espol.model.Dueño;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.proyecto.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Victor Zuñiga
 */
public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private VBox vboxImagenes;
    @FXML
    private Button btnDueno;
    @FXML
    private Button btnEvaluacion;
    @FXML
    private Button btnInscripcion;
    @FXML
    private Button btnPremio;
    @FXML
    private Button btnMascota;
    @FXML
    private Pane paneImagen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> imagenes= cargarImagenes("imagenes.txt");
        Thread imagen = new Thread(new Loop(imagenes));
        imagen.start();
        try{
        ArrayList<Dueño> dueños= Dueño.readFromFile("dueños.txt");
        
        if(dueños.isEmpty()){
            desactivar();
            
        }
        }catch(ConcursoException io){
            desactivar();
            
        }
        try{
        ArrayList<Mascota> mascotas= Mascota.readFromFile("mascotas.txt");
        if(mascotas.isEmpty())
            btnInscripcion.setDisable(true);
        }catch(ConcursoException ce){
            btnInscripcion.setDisable(true);
        }
        try{
        ArrayList<Inscripcion> inscripciones= Inscripcion.readFromFile("inscripciones.txt");
        if(inscripciones.isEmpty())
            btnEvaluacion.setDisable(true);
        }catch(ConcursoException ce){
            btnEvaluacion.setDisable(true);
        }
        
        
        ArrayList<String> imagenes1= cargarImagenes("mascota.txt");
        Image encabezado = new Image("img miembroJ/" + imagenes1.get(0));
        ImageView imv= new ImageView(encabezado);
        imv.setFitWidth(100);
        imv.setFitHeight(100);
        paneImagen.getChildren().add(imv);
        
//        try{
//        ArrayList<Evaluacion> eval= Evaluacion.readFile("evaluaciones.txt");
//        if(eval.isEmpty())
//            btnEvaluacion.setDisable(true);
//        }catch(ConcursoException ce){
//            btnEvaluacion.setDisable(true);
//             
//            
//        }
        
        
    
        
    }
    public void desactivar(){
            btnPremio.setDisable(true);
            
            btnMascota.setDisable(true);
            btnInscripcion.setDisable(true);
            btnEvaluacion.setDisable(true);
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
    private void switchToDueno(ActionEvent event) throws IOException {
        App.setRoot("Dueño");
    }

    @FXML
    private void switchToEvaluacion(ActionEvent event) throws IOException {
        App.setRoot("Evaluacion");
    }

    private void switchToMiembroJurado(ActionEvent event) throws IOException {
        App.setRoot("MiembroJurado");
    }

    @FXML
    private void switchToInscripcion(ActionEvent event) throws IOException {
        App.setRoot("Inscripciones");
    }

    private void switchToCriterio(ActionEvent event) throws IOException {
        App.setRoot("Criterio");
    }


    @FXML
    private void switchToMascota(ActionEvent event){
        try {
            App.setRoot("Mascotas");
        } catch (IOException ex) {
            ex.printStackTrace();
            Alert a= new Alert(Alert.AlertType.ERROR,"No se ha registrado ningun dueño");
            a.show();
        }
    }

    @FXML
    private void switchToPremio(ActionEvent event) throws IOException {
        App.setRoot("Premio");
    }
    class Loop implements Runnable{
        ArrayList<String> imagenes;

        public Loop(ArrayList<String> imagenes) {
            this.imagenes = imagenes;
        }
        

        @Override
        public void run() {
            int entero = 0;
            while (true) {

                try {

                    Thread.sleep(1000);
                    Image i;
                    Image j;
                    if (entero % 2 == 0) {
                        i = new Image("img mascota/" + imagenes.get(0));
                        j = new Image("img mascota/" + imagenes.get(2));
                        
                    } else {
                        i = new Image("img mascota/" + imagenes.get(1));
                        j = new Image("img mascota/" + imagenes.get(3));
                   
                    }
                    Platform.runLater(() -> {
                        vboxImagenes.getChildren().clear();

                        ImageView imv1 = new ImageView(i);
                        imv1.setFitWidth(300);
                        imv1.setFitHeight(300);
                        vboxImagenes.getChildren().add(imv1);
                        
                        ImageView imv2 = new ImageView(j);
                        imv2.setFitWidth(300);
                        imv2.setFitHeight(300);
                        vboxImagenes.getChildren().add(imv2);
                        
                        
                        
                    });
                    entero += 1;
                   
                } catch (InterruptedException ex) {
                    root.getChildren().clear();
                }
            }
        }
        
    }

}

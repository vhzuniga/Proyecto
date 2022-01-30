package ec.edu.espol.controller;

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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    private Button btnMiembroJurado;
    @FXML
    private Button btnInscripcion;
    @FXML
    private Button btnCriterio;
    @FXML
    private Button btnPremio;
    @FXML
    private Button btnConcurso;
    @FXML
    private Button btnMascota;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> imagenes= cargarImagenes("imagenes.txt");
        Thread imagen = new Thread(new Loop(imagenes));
        imagen.start();
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

    @FXML
    private void switchToMiembroJurado(ActionEvent event) throws IOException {
        App.setRoot("MiembroJurado");
    }

    @FXML
    private void switchToInscripcion(ActionEvent event) throws IOException {
        App.setRoot("Inscripciones");
    }

    @FXML
    private void switchToCriterio(ActionEvent event) throws IOException {
        App.setRoot("Criterio");
    }

    @FXML
    private void switchToConcurso(ActionEvent event) throws IOException {
        App.setRoot("Concurso");
    }

    @FXML
    private void switchToMascota(ActionEvent event) throws IOException {
        App.setRoot("Mascotas");
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

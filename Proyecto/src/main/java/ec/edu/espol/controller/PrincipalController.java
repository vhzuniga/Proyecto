/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Victor Zuñiga
 */
public class PrincipalController implements Initializable {

    @FXML
    private VBox vbximagpricipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    private class imagRap implements Runnable{
        private ArrayList<String> nombres;
        private int repeticiones;
        private int i;

        public imagRap(ArrayList<String> nombres, int repeticiones) {
            this.nombres = nombres;
            this.repeticiones = repeticiones;
            this.i=0;
        }
        
        
        

        @Override
        public void run() {
            int contador = 0;
            while(true){
                Platform.runLater(()->{
                    vbximagpricipal.getChildren().clear();
                    mostrarImagen(nombres.get(i));
                });
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
                contador+=1;
                i++;
                if(i == nombres.size()) i= 0;
            }
        }
        
    }
    private void mostrarImagenes(ArrayList<String> imagenes){
        this.vbximagpricipal.getChildren().clear();
        for(String s: imagenes){
            Image i = new Image("img mascota/"+s);
            ImageView imv = new ImageView(i);
            imv.setFitWidth(300);
            imv.setFitHeight(200);
            vbximagpricipal.getChildren().add(imv);
        }
    }
    
    
    private void mostrarImagen(String imagenes){
        this.vbximagpricipal.getChildren().clear();
            Image i = new Image("img mascota/"+imagenes);
            ImageView imv = new ImageView(i);
            imv.setFitWidth(300);
            imv.setFitHeight(200);
            vbximagpricipal.getChildren().add(imv);
    
}
}

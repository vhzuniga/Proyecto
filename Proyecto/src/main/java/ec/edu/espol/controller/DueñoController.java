/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import static ec.edu.espol.controller.MascotasController.cargarImagenes;
import ec.edu.espol.model.Dueño;
import ec.edu.espol.proyecto.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private Button btnMascota;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> imagenes= cargarImagenes("mascota.txt");
        Image mascotas = new Image("img miembroJ/" + imagenes.get(0));
        ImageView imv1= new ImageView(mascotas);
        imv1.setFitWidth(400);
        imv1.setFitHeight(200);
        hboxDueños.getChildren().add(imv1);
    }    

    @FXML
    private void swtichToMenu(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    private void GuardarCambios(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String direccion = txtDireccion.getText();
        
        Dueño due = new Dueño(2,nombre,apellido,telefono,email,direccion);
        
        
        due.saveFile("dueños.txt");
       
       
        
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
    
}

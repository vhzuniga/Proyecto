/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import static ec.edu.espol.controller.PrincipalController.cargarImagenes;
import ec.edu.espol.proyecto.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MascotasController implements Initializable {

    @FXML
    private VBox vboxgato;
    @FXML
    private VBox vboxperro;
    
    @FXML
    private Button btnMenu;
    private ArrayList<String> imagenes;
    @FXML
    private Button btnDueño;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtraza;
    @FXML
    private ComboBox<?> cbxtipo;
    @FXML
    private ComboBox<?> cbxAño;
    @FXML
    private ComboBox<?> cbxMes;
    @FXML
    private ComboBox<?> cbxDía;
    @FXML
    private ComboBox<?> cbxDueño;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<String> imagenes= cargarImagenes("duenos.txt");
        Image gato = new Image("img tipo/" + imagenes.get(0));
        Image perro = new Image("img tipo/" + imagenes.get(1));
        ImageView imv1= new ImageView(gato);
        imv1.setFitWidth(50);
        imv1.setFitHeight(50);
        vboxgato.getChildren().add(imv1);
        
        ImageView imv2= new ImageView(perro);
        imv2.setFitWidth(50);
        imv2.setFitHeight(50);
        vboxperro.getChildren().add(imv2);

        

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
    private void switchToDueño(ActionEvent event) throws IOException {
        App.setRoot("Dueño");
    }

    @FXML
    private void Guardar(ActionEvent event) {
        //int idMascota,int idDueño, String nombre, String tipo, String raza, LocalDate fechaNacimiento
        //para obtener el id
        //String nombreDue= cbxDueño.getValue();
        //int idDue= obtenerDueñoXNombre(nombreDue);
        String nombre = txtnombre.getText();
        //String tipo = 
        String raza = txtraza.getText();
        String fecha= cbxAño.getValue()+"-"+cbxMes.getValue()+"-"+cbxDía.getValue();
        //LocalDate fechaNacimiento = fecha;
        
    }
    
    
}

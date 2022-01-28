/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MiembroJurado extends Persona{
    private String descripcionPerfilProfesional;
    private ArrayList<Evaluacion> evaluaciones;
    //
    
    
    //Constructores
    
    public MiembroJurado(int id, String nombre, String apellidos, String telefono,
            String email, String perfilProfesional) {
        super(id, nombre, apellidos, telefono, email);
        this.descripcionPerfilProfesional = perfilProfesional;
        this.evaluaciones = new ArrayList<>();
    }
    
    //Getters no heredados

    public String getDescripcionPerfilProfesional() {
        return descripcionPerfilProfesional;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    
    public void setDescricpcionPerfilProfesional(String perfilProfesional){
        this.descripcionPerfilProfesional = perfilProfesional;
    }
    
    //toString sobreescrito 
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Miembro de jurado: "+this.nombre+' '+this.apellidos+" cuyo id y perfil profesional son "
                +this.id+' '+this.descripcionPerfilProfesional+" tiene las siguientes evaluaciones: ");
        for(Evaluacion ev : this.evaluaciones){
            sb.append(ev+". \n");
        }
        return sb.toString();
    }
    
    //equals NO necesita sobreescribirse ( solo se usa el que se hereda )
    
    
    //Guardar objetos en archivos
    
    @Override
    public void saveFile(String nomFile) throws ConcursoException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre, false))){// Sino funciona poner el true
            PrintWriter pw = new PrintWriter(bw);
            pw.println(Util.nextID(nomFile)+"|"+this.nombre+"|"+this.apellidos+
                    "|"+this.telefono+"|"+this.email+"|"+this.descripcionPerfilProfesional);
        }
         catch(IOException ex){
            throw new ConcursoException("Error en la lectura");
         }
    }
    
    
    
    public static ArrayList<MiembroJurado> readFromFile(String nomFile) throws ConcursoException{
        ArrayList<MiembroJurado> mjrs = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nomFile))){
            String line;
            while((line = bf.readLine())!= null){
                //String linea = sc.nextLine();
                String[] tokens = line.split("\\|");
                MiembroJurado mjr = new MiembroJurado(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                mjrs.add(mjr);
            }
        }
        catch(IOException ex){
            throw new ConcursoException("Error en la lectura");
        }
        return mjrs;
    }
    
    public static MiembroJurado nextMiembroJurado(Scanner sc){
        sc.useDelimiter("\n");
        int idm = Util.nextID("miembroJurados.txt");
        System.out.println("Ingrese el nombre del Miembro del Jurado: ");
        String nb0 = sc.next();
        String nombre = nb0.toUpperCase().charAt(0) + nb0.substring(1, nb0.length()).toLowerCase();      
        System.out.println("Ingrese los apellidos del Miembro del Jurado");
        String ap = sc.next();
        String apellido = ap.toUpperCase().charAt(0) + ap.substring(1, ap.length()).toLowerCase();
        System.out.println("Ingrese el numero de telefono del Miembro de Jurado: ");
        String tlf = sc.next();
        System.out.println("Ingrese el email del Miembro del Jurado: ");
        String mail = sc.next().toLowerCase();
        System.out.println("Ingrese la descripcion profesional de su Miembro de Jurado: ");
        String descrp = sc.next().toLowerCase();
        MiembroJurado mj = new MiembroJurado(idm, nombre, apellido, tlf, mail, descrp);
        return mj;
    }
        public static MiembroJurado obtenerMiembroJuradoXEmail(String email1){
        ArrayList<MiembroJurado> jueces = MiembroJurado.readFromFile("miembroJurados.txt");
        for(MiembroJurado miembro: jueces){
            if(Objects.equals(miembro.email,email1))
                 return miembro;   
        }
        return null;
    }
}

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

public class Criterio {
    private int idCriterio;
    private String nombre;
    private String descripcion;
    private double puntajeMax;
    private ArrayList<Evaluacion> evaluaciones;
    private int idConcurso;
    private Concurso concursos;
    
    
     public Criterio(int idCriterio,int idConcurso, String nombre, String descripcion, double puntajeMax) {
        this.idCriterio = idCriterio;
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        if(puntajeMax>=0)
            this.puntajeMax = puntajeMax;
        else 
            this.puntajeMax = -(puntajeMax);
        this.evaluaciones = new ArrayList<>();
    }
    

    public Criterio(int idCriterio, String nombre, String descripcion, double puntajeMax, ArrayList<Evaluacion> evaluaciones, int idConcurso, Concurso concursos) {
        this.idCriterio = idCriterio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        if(puntajeMax>=0)
            this.puntajeMax = puntajeMax;
        else
            this.puntajeMax = -(puntajeMax);
        this.evaluaciones = new ArrayList<> ();
        this.idConcurso = idConcurso;
        this.concursos = concursos;
    }

    public int getIdCriterio() {
        return this.idCriterio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getPuntajeMax() {
        return this.puntajeMax;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return this.evaluaciones;
    }

    public int getIdConcurso() {
        return this.idConcurso;
    }

    public Concurso getConcursos() {
        return this.concursos;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntajeMax(double puntajeMax) {
        if(puntajeMax>=0)
            this.puntajeMax = puntajeMax;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }


    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcursos(Concurso concursos) {
        this.concursos = concursos;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Criterio crto = (Criterio) obj;
        return this.idCriterio == crto.idCriterio && Objects.equals(this.nombre, crto.nombre);
    }

    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Criterio No. " + this.idCriterio +"Concurso No. "+this.idConcurso +"Nombre del criterio: "+ this.nombre+ "Descripcion: " + this.descripcion+ "Puntaje m??ximo: "+this.puntajeMax);
        return sb.toString();
    }
    
    
    public void saveFile(String nomFile) throws ConcursoException{ 
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomFile, false))){
            PrintWriter pw = new PrintWriter(bw);
            pw.println(Util.nextID(nomFile)+"|"+this.idConcurso+"|"+this.nombre+"|"+this.descripcion+"|"+this.puntajeMax);
            
        }
        catch(IOException ex){
            throw new ConcursoException("Error en la lectura");
        }
    }
    
    public static ArrayList<Criterio> readFromFile(String nomFile) throws ConcursoException{
        ArrayList<Criterio> criterio = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nomFile))){
            String line;
            while((line = bf.readLine())!= null){
                //String linea = sc.nextLine();
                String[] tokens = line.split("\\|");
                Criterio cr = new Criterio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), tokens[2],tokens[3],Double.parseDouble(tokens[4]));
                criterio.add(cr);
            }
        }
        catch(IOException ex){
            throw new ConcursoException("Error en la lectura");
        }
        
        return criterio;
    }
    
    public static Criterio nextCriterio(Scanner sc){
        sc.useDelimiter("\n");
        int idcr = Util.nextID("criterios.txt");
        int idc = 0;
        System.out.println("Ingrese el nombre del criterio: ");
        String name = sc.next();
        String nombre = name.toUpperCase().charAt(0) + name.substring(1, name.length()).toLowerCase();
        System.out.println("Ingrese la descripci??n del criterio: ");
        String dp = sc.next().toLowerCase();
        System.out.println("Ingrese el puntaje m??ximo, en n??meros: ");
        Double pm = sc.nextDouble();
        Criterio cr1 = new Criterio(idcr,idc, nombre, dp, pm);
        return cr1;
    }
        public static Criterio obtenerCriterioXNombre(String nombre){
        ArrayList<Criterio> criterios = Criterio.readFromFile("criterios.txt");
        for(Criterio msc : criterios){
            if(Objects.equals(msc.nombre, nombre))
                 return msc;   
        }
        return null;
    }  
    
    public static Criterio ObtenerObjetoCriterio(int id){    
        ArrayList<Criterio> list_criterios=Criterio.readFromFile("criterios.txt");
        for ( Criterio criterio:list_criterios){
            if(criterio.getIdCriterio() == id){
                return criterio;   
            }
        }return null;
        
    }
}

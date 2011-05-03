package Logica;
import java.awt.*;
import java.util.ArrayList;
/*
 * Ruta.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Crea un objeto de tipo Ruta una abstraccion de lo encontrado en el formato nombre#frecuencia#parestviajeparada
 * @author  Miguel Mondragon 
 * @since  1.0
 * nombre#frecuencia#parestviajeparada
 */
public class Ruta {
    
    private String nombreRuta;
    private int frecuencia;
    private ArrayList<Point> parejasList = new ArrayList<Point>(); // (t1,p1)-(t2,p2)-...-(tn,pn)
    /**
     * Crea un Objeto de tipo Ruta 
     * @param nombre
     * @param frecuencia
     * @param parejas
     */
    public Ruta(String nombre,int frecuencia, String parejas){
        this.nombreRuta=nombre;
        this.frecuencia=frecuencia;
        this.parejasList=extraerParejas(parejas);
    }
    /**
     * Retorna Nombre de la rutas
     * @return nombre de la ruta
     */
    public String getNombreRuta(){
        return this.nombreRuta;
    }
    /**
     * Establece Nombre de la rutas
     * @param nombre de la ruta
     */
    void setNombreRuta(String nombre){
        this.nombreRuta=nombre;
    }
    /**
     * Retorna la frecuencia de la ruta
     * @return frecuencia de la ruta
     */
    public int getFrecuencia(){
        return this.frecuencia;
    }
    /**
     * Establece la frecuencia de la ruta
     * @param frecuencia
     */
    void setFrecuencia(int frecuencia){
        this.frecuencia=frecuencia;
    }
    /**
     * Retorna la lista de puntos a recorrer por la ruta
     * @return puntos a recorrer por la ruta
     */
    public ArrayList<Point> getListParejas(){
        return this.parejasList;
    }
    /**
     * Establece la lista de puntos a recorrer por la ruta
     * @param parejas
     */
    void setListParejas(String parejas){
        this.parejasList=extraerParejas(parejas);
    }
    /**
     * Captura toda las parejas de puntos por los que pasa la ruta
     * @param parejas
     * @return
     */
    private ArrayList<Point> extraerParejas(String parejas){
        String[] split = parejas.split("\\-");
        for(int i=0;i<split.length;i++){
             String [] splittArray = null;
            if (split[i] != null || !split[i].equalsIgnoreCase("")){
                splittArray = split[i].split("\\,");
            }
           //System.out.println("@Parejas "+Integer.parseInt(splittArray[0].replace("(", ""))+" - "+Integer.parseInt(splittArray[1].replace(")", "")));
           parejasList.add(new Point(Integer.parseInt(splittArray[0].replace("(", "")),Integer.parseInt(splittArray[1].replace(")", ""))));
        }
        return parejasList;
    }
}

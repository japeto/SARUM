package Logica;
import java.awt.*;
/*
 * Parada.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Crea un objeto de tipo parada una abstraccion de lo encontrado en el formato tipoparada#índice#nombre#ubicación
 * @author  Miguel Mondragon 
 * @since  1.0
 * tipoparada#índice#nombre#ubicación
 */
public class Parada {

    private int tipoParada;
    private int nParada;
    private String nombreParada;
    private Point ubicacion;
    /**
     * Crea un objeto de la clase Parada
     * @param tipo
     * @param nParada
     * @param nombre
     * @param ubicacion
     */
    public Parada(int tipo,int nParada,String nombre,Point ubicacion){
        this.tipoParada=tipo;
        this.nParada=nParada;
        this.nombreParada=nombre;
        this.ubicacion=ubicacion;
        //System.out.print(nombre+" : "+ubicacion+" \n");
    }
    /**
     * Retorna el tipo de parada <b>Estacion,Paradero</b>
     * @return tipo de parada
     */
    public int getTipoParada(){
        return tipoParada;
    }
    /**
     *Establece el tipo de parada <b>Estacion,Paradero</b>
     * @param tipo
     */
    void setTipoParada(int tipo){
        this.tipoParada=tipo;
    }
    /**
     * Retorna el numero de Parada
     * @return el numero de parada
     */
    public int getNParada(){
        return nParada;
    }
    /**
     * Establece el numero de Parada
     * @param num
     */
    void setNParada(int num){
        this.nParada=num;
    }
    /**
     * Retorna el nombre de la Parada
     * @return nombre de la Parada
     */
    public String getNombreParada(){
        return nombreParada;
    }
    /**
     * Establece el nombre de la Parada
     * @param nombre
     */
    void setNombreParada(String nombre){
        this.nombreParada=nombre;
    }
    /**
     * Retorna la ubicacion de la Parada
     * @return ubicacion de la Parada
     */
    public Point getUbicacion(){
        return ubicacion;
    }
    /**
     * Establece la ubicacion de la Parada
     * @param p
     */
    void setUbicacion(Point p){
        this.ubicacion=p;
    }
}

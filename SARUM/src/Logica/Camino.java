package Logica;
/*
 * Camino.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * 
 * @author  Miguel Mondragon 
 * @since  1.0
 */
public class Camino {
    
    String Origen;
    String tiempoRecorrido;
    String Destino;
    String nombreRuta;

    public Camino(String Origen,String tiempo,String Destino, String nombreRuta){
        this.Origen=Origen;
        this.tiempoRecorrido=tiempo;
        this.Destino=Destino;
        this.nombreRuta=nombreRuta;
    }

    public String getDestino() {
        return Destino;
    }

    public String getOrigen() {
        return Origen;
    }

    public String getTiempoRecorrido() {
        return tiempoRecorrido;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public void setTiempoRecorrido(String tiempoRecorrido) {
        this.tiempoRecorrido = tiempoRecorrido;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }
    @Override
    public String toString() {
        return "Camino{" + "Origen=" + Origen + " tiempoRecorrido=" + tiempoRecorrido + " Destino=" + Destino + '}';
    }
}

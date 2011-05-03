package Interfaz;
import java.awt.*;
/*
 * ViaTroncal.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Crea una conexion visual entre paradas que se comunican con una ruta
 * @author Miguel mondragon
 * @since  1.0
 */
public class ViaTroncal implements FiguraSarum{
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int tiempo;
    /**
     * Crea una conexion grafica entre paradas que poseen rutas
     * @param org punto de origen
     * @param des punto de destipo
     * @param tiempo tiempo en que se hace el recorrido
     */
    public  ViaTroncal(Point org,Point des, int tiempo){
        this.x=org.x;
        this.y=org.y;
        this.x2=des.x;
        this.y2=des.y;
        this.tiempo=tiempo;
    }
    /**
     * Crea una conexion grafica entre paradas que poseen rutas
     * @param x1 punto de origen coordenada x
     * @param x2 punto de destino coordenada x
     * @param y1 punto de origen coordenada y
     * @param y2 punto de destino coordenada y
     * @param tiempo tiempo en que se hace el recorrido
     */
    public  ViaTroncal(int x1,int x2,int y1 ,int y2, int tiempo){
        this.x=x1;
        this.y=y1;
        this.x2=x2;
        this.y2=y2;
        this.tiempo=tiempo;
    }
    void setX2(int x2) {
        this.x2 = x2;
    }

    void setY2(int y2) {
        this.y2 = y2;
    }
    /**
     * Retorna la coordenada x del punto de destino
     * @return coordenada x2
     */
    public int getX2() {
        return x2;
    }
    /**
     * Retorna la coordenada y del punto de destino
     * @return coordenada y2
     */
    public int getY2() {
        return y2;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }
    /**
     * Retorna la coordenada x del punto de origen
     * @return coordenada x
     */
    public int getX() {
        return x;
    }
    /**
     * Retorna la coordenada y del punto de origen
     * @return coordenada y
     */
    public int getY() {
        return y;
    }
    /**
     * Retorna el tiempo que consume la ruta entre estos dos
     * @return tiempo de viaje
     */
    public int getTiempo() {
        return tiempo;
    }
    /**
     * Permite graficar en el mapa
     * @param g
     */
    public void dibujeme(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(((x*8)-2), ((y*8)+1), ((x2*8)-2), ((y2*8)+1));
        //g.setColor(Color.RED);
        //g.drawString( tiempo + "", (((x*8)-2) + ((x2*8)-2)) / 2, (((y*8)+1) + ((y2*8)+1)) / 2);
    }
    /**
     * 
     * @param x
     * @param y
     * @return true or false si es tocado con el mouse el elemento
     */
    public boolean estaDentro(int x, int y) {
      if ((x > this.x) && (y > this.y)){
            return true;
       }
      return false;
    }
    /**
     * 
     * @param x
     * @param y
     */
    public void setPosicion(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

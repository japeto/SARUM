package Interfaz;
import java.awt.*;
import javax.swing.ImageIcon;
/*
 * Estacoin.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Permite mostrar en pantalla una parada de tipo estacion
 * @author  Miguel Mondragon 
 * @since  1.0
 * @see FiguraSarum
 */
public class Estacion implements FiguraSarum
{
    private int x;
    private int y;
    private String nombre;
    //private Image imagen;
    private int tipo;
    /**
     * Crea una estacion para ser pintada
     * @param x coordenada x
     * @param y coordenada y
     * @param nombre nombre de la estacion
     * @param tipo tipo de parada
     */
    public Estacion(int x, int y, String nombre,int tipo){
        this.x=100 + x;
        this.y=100 + y;
        this.nombre=nombre;
//        this.imagen= new ImageIcon("estacion.png").getImage();
        this.tipo=tipo;
        //System.out.println("@Estacion x: "+this.x+" y: "+this.y+" noM:"+nombre);
    }
    /**
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @return si es capturada por el mouse
     */
    public boolean estaDentro(int x, int y) {
        /*if ((x > this.x) && (y > this.y)){
            return true;
        }*/
        return false;
    }
    /**
     *
     * @param x coordenada x
     * @param y coordenada y
     */
    public void setPosicion(int x, int y) {
        this.x=20 + (x);
        this.y=40;
        //System.out.println("x: "+x+" y: "+y);
    }
    /**
     * 
     * @return coordenada x
     */
    public int getX() {
        return x;
    }
    /**
     *
     * @return coordenada y
     */
    public int getY() {
        return y;
    }
    /**
     * Permite hacer visible una estacion 
     * @param g
     */
    public void dibujeme(Graphics g) {
        if(tipo==0){
            Image image = new ImageIcon(getClass().getResource("images/estacion.png")).getImage();
            g.drawImage(image,(x*8) - 7,(y*8) - 10, null);/**
            g.setColor(Color.blue);
            g.fillRect((x*8) - 7, (y*8) - 10, 10*2, 10*2);*/
            g.setColor(Color.blue);
            g.drawString(nombre,((x*8)-3), ((y*8+20)));
        }else{
            Image image = new ImageIcon(getClass().getResource("images/parada.png")).getImage();
            g.drawImage(image,(x*8) - 7,(y*8) - 10, null);/**
            g.setColor(Color.blue);
            g.fillRect((x*8) - 7, (y*8) - 10, 10*2, 10*2);*/
            g.setColor(Color.red);
            g.drawString(nombre,((x*8)-3), ((y*8+20)));
        }
    }

}

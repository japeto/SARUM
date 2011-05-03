package Interfaz;
import java.awt.Graphics;
/*
 * FiguraSarum.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Interfaz para asociar los tipos de graficos que se veran en la aplicacion
 * @author  Miguel Mondragon s
 * @since  1.0
 */
public interface FiguraSarum {

    public boolean estaDentro(int x, int y);
    public void setPosicion(int x, int y);
    public int getX();
    public int getY();
    public void dibujeme(Graphics g);
    
}

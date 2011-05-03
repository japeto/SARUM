package Interfaz;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/*
 * Mapa.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Componente que servira para poner las estaciones y rutas
 * @author  Miguel Mondragon 
 * @since  1.0
 */
public class Mapa extends JComponent implements MouseMotionListener {
    
    private LinkedList<FiguraSarum> listaFiguras = new LinkedList<FiguraSarum>();
    private FiguraSarum figuraArrastrandose = null;
    private int xAnteriorRaton;
    private int yAnteriorRaton;
    /**
     * Crea un objeto de tipo Mapa
     */
    public Mapa(){
        this.addMouseMotionListener((MouseMotionListener) this);
        this.setSize(1800, 1800);
        this.setPreferredSize(new Dimension(1800,1800));
    }
    /**
     * Agrega una figura
     * @param fgsa figura de tipo FiguraSarum
     */
    public void addFigura(FiguraSarum fgsa){
        listaFiguras.add(fgsa);
    }
    /**
     * Elimina las figrua de la pantalla
     */
    public void clearFiguras(){
        listaFiguras.clear();
        this.repaint();
    }
    /**
     * Pinta todas las figura en si mismo
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        for (FiguraSarum figura : listaFiguras){
            figura.dibujeme(g);
        }
        this.setOpaque(false);
    }
    /**
     * Permite arrastrar y captuar los elementos de la aplicacion
     * @param e
     */
    public void mouseDragged(MouseEvent e){
        /**if (figuraArrastrandose == null){
            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();
            figuraArrastrandose = dameFigura(e);
        }else{
            figuraArrastrandose.setPosicion(
                figuraArrastrandose.getX() + (e.getX() - xAnteriorRaton),
                figuraArrastrandose.getY() + (e.getY() - yAnteriorRaton));

            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();

            repaint();
        }**/
    }
    /**
     * Dada su Ubicacion retorna la Figura de tipo FigruaSarum
     * @param e
     * @return
     */
    private FiguraSarum dameFigura(MouseEvent e){
        for (FiguraSarum figura : listaFiguras){
            if (figura.estaDentro(e.getX(), e.getY())){
                return figura;
            }
        }
        return null;
    }
    /**
     * 
     * @param e
     */
    public void mouseMoved(MouseEvent e){
        figuraArrastrandose = null;
    }
}

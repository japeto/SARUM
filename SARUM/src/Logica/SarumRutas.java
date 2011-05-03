package Logica;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * SarumRutas.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Permite mantener la informacion de todas la rutas para la aplicacion
 * @author  Miguel Mondragon 
 * @since  1.0
 */
public class SarumRutas {

   private ArrayList<Ruta> listaRutas= new ArrayList<Ruta>();

    SarumRutas(){}
    private boolean verificarCadena(String ruta)throws Exception{
        int nParadas=ruta.replaceAll("[^#]","").length();
        if(nParadas<2){
            System.err.println("ruta no creada: "+ruta);
            throw new Exception("Hay una mal formacion en la creacion de una ruta");
        }else {
            return true;
        }
    }
    /**
     * Verifica y crea una ruta para la aplicacion
     * @param ruta
     * @throws Exception
     */
    public void addRuta(String ruta) throws Exception{
        if(verificarCadena(ruta)){
            StringTokenizer tokens = new StringTokenizer(ruta,"#");
            listaRutas.add(new Ruta(tokens.nextToken(),Integer.parseInt(tokens.nextToken()),tokens.nextToken()));
        }
    }
    void setListaRutas(ArrayList<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }
    /**
     * Retorna todas la rutas en la aplicacion
     * @return todas la rutas
     */
    public ArrayList<Ruta> getListaRutas() {
        return listaRutas;
    }
    /**
     * Retorna el numero de rutas que posee la aplicacion actualmente
     * @return rutas
     */
    public int sizeRutas(){
        return listaRutas.size();
    }
    public ArrayList<Camino> getDestinosRuta(){
        ArrayList<Camino> salida = new ArrayList<Camino>();
        for(int numeroRutas=0;numeroRutas<listaRutas.size();numeroRutas++){
           //System.out.print(listaRutas.get(numeroRutas).getListParejas().toString()+" : "+listaRutas.get(numeroRutas).getNombreRuta()+" o: "+numeroRutas+"\n");
           for(int destinoRuta=0;destinoRuta<listaRutas.get(numeroRutas).getListParejas().size();destinoRuta++){
               //System.out.print(":) "+destinoRuta+" : "+listaRutas.get(numeroRutas).getListParejas().size()+"\n");
               if(listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).x>=0 && destinoRuta<listaRutas.get(numeroRutas).getListParejas().size()-1){
                   //System.out.print(listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).y+" , "+listaRutas.get(numeroRutas).getListParejas().get(destinoRuta+1).x+" , "+listaRutas.get(numeroRutas).getListParejas().get(destinoRuta+1).y+" , "+listaRutas.get(numeroRutas).getNombreRuta()+"\n");
                   salida.add(new Camino(listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).y+"",listaRutas.get(numeroRutas).getListParejas().get(destinoRuta+1).x+"",listaRutas.get(numeroRutas).getListParejas().get(destinoRuta+1).y+"",listaRutas.get(numeroRutas).getNombreRuta()));
               }else if (listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).x > 0 && destinoRuta == listaRutas.get(numeroRutas).getListParejas().size()-1) {
                   //System.out.print(listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).y+" , "+(-1)+" , "+(-1)+" , "+listaRutas.get(numeroRutas).getNombreRuta()+"\n");
                   salida.add(new Camino(listaRutas.get(numeroRutas).getListParejas().get(destinoRuta).y+"","-1","-1",listaRutas.get(numeroRutas).getNombreRuta()));
               }
           }
        }
        
        return salida;
    }
}

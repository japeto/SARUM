package Logica;
import java.awt.Point;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
/*
 * CargaArchivo.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Permite la carga de Archivos y la conversion a datos para la aplicacion
 * @author Miguel Mondragon 
 * @since  1.0
 */
public class CargarArchivo {

        private List<String> fileList;
        private SarumParadas fileParadas=new SarumParadas();
        private SarumRutas fileRutas=new SarumRutas();
        private ArrayList<Point[]> lst = new ArrayList<Point[]>();
        int nLineas=0;
        /**
         * Carga el archivo de estaciones y rutas
         * @param selectedFile
         * @throws IOException
         */
        public CargarArchivo(File selectedFile) throws IOException{
            fileList= new ArrayList<String>();
            BufferedReader entrada = new BufferedReader(new FileReader( selectedFile ));
            for (String linea = entrada.readLine(); linea != null; linea = entrada.readLine()) {
                fileList.add(linea);
                nLineas++;
            }
            entrada.close();
        }
        /**
         * Extrae los elementos vitales desde el archivo las paradas y las rutas
         * @throws Exception
         */
        public void computarArchivo()throws Exception{
            for(int i=0;i<nLineas;i++){
                if(i > fileList.indexOf("paradas") && i < fileList.indexOf("rutas")){
                    fileParadas.addParada(fileList.get(i));
                }else if(i > fileList.indexOf("rutas") && i < (nLineas-1)){
                    fileRutas.addRuta(fileList.get(i));
                }
            }
            /**System.out.print("Cant. paradas: "+fileParadas.sizeParadas()+"\n");
             System.out.print("Cant. rutas: "+fileRutas.sizeRutas()+"\n");
             System.out.print("parada 1: "+fileParadas.getListaParadas().get(1).getUbicacion().toString()+"\n");
             System.out.print("ruta 1: "+fileRutas.getListaRutas().get(1).getNombreRuta()+"\n");*/
        }
        /**
         * Carga el archivo con las parejas para convertirlos en datos para la aplciacion
         * @param selectedFile
         * @return lista de puntos de origen-destino para el algoritmo
         * @throws FileNotFoundException
         * @throws IOException
         */
        public ArrayList<Point[]> cargarProblema(File selectedFile) throws FileNotFoundException, IOException {
            String archivoString="";
            BufferedReader entrada = new BufferedReader(new FileReader( selectedFile ));
            for (String linea = entrada.readLine(); linea != null; linea = entrada.readLine()) {
                archivoString+=linea+" ";
            }
            entrada.close();
                archivoString=archivoString.replace("<pre><p>","");
                archivoString=archivoString.replace("</p></pre>","");
            String[] split = archivoString.split(" ");
            Point[] ptemporal=null;
            Pattern p=Pattern.compile("\\)-[-(]");
                for(int b=1;b<split.length;b++){
                    String[] parUbicacionOrigen = split[b].split(p.pattern());
                    ptemporal=new Point[parUbicacionOrigen.length];
                    for(int c=0;c<parUbicacionOrigen.length;c++){
                    String [] splittArray = null;
                        if (split[c] != null || !split[c].equalsIgnoreCase("")){
                            splittArray = parUbicacionOrigen[c].split("\\,");
                            ptemporal[c]=new Point(Integer.parseInt(splittArray[0].replace("(","")),Integer.parseInt(splittArray[1].replace(")","")));
                     //       lst.add(new Point(Integer.parseInt(splittArray[0].replace("(","")),Integer.parseInt(splittArray[1].replace(")",""))));
                        }
                    }
                    lst.add(ptemporal);
                }
            return lst;
        }
        /**
         * Establece la ubicacion de cada una de las paradas
         * @param fileParadas
         */
        public void setFileParadas(SarumParadas fileParadas) {
            this.fileParadas = fileParadas;
        }
        /**
         * Establece las rutas para el porgama
         * @param fileRutas
         */
        public void setFileRutas(SarumRutas fileRutas) {
            this.fileRutas = fileRutas;
        }
        /**
         * Retorna Un objeto con las paradas
         * @return Un objeto con las paradas
         * @see SarumParadas
         */
        public SarumParadas getFileParadas() {
            return fileParadas;
        }
        /**
         * Retorna Un objeto con las rutas
         * @return Un objeto con las rutas
         * @see SarumRutas
         */
        public SarumRutas getFileRutas() {
            return fileRutas;
        }
}


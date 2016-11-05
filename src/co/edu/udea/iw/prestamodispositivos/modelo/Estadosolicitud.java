package co.edu.udea.iw.prestamodispositivos.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que referencia un objeto la tabla estadosolicitud en la base de datos
 * @author Le�n David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Al�xis Castrill�n Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@XmlRootElement
public class Estadosolicitud  implements java.io.Serializable {


     private int id;//Id que identifica un estado espec�fico
     private String estado;//Nombre o etiqueta del estado

    //Constructor vac�o o por defecto
    public Estadosolicitud() {
    }

    //Constructor con todos los par�metros
    public Estadosolicitud(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }
   
    /**
     * M�todo para obtener el Id de un estado
     * @return El id del estado
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * M�todo para asignar el Id de un estado
     * @param id que se le va a asignar al estado
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * M�todo para obtener la etiqueta o nombre de un estado
     * @return El nombre del estado
     */
    public String getEstado() {
        return this.estado;
    }
    
    /**
     * M�todo para asignar el nombre de un estado
     * @param estado que se le va a asignar al estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}



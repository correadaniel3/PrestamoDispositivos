package co.edu.udea.iw.prestamodispositivos.modelo;

/**
 * Clase que referencia un objeto la tabla tipodocumento en la base de datos
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class Tipodocumento  implements java.io.Serializable {


     private int id;//Id asociado a un tipo de documento específico
     private String tipo;//Nombre o etiqueta de cada tipo de documento

    //Constructor vacío o por defecto
    public Tipodocumento() {
    }

    //Constructor con todos los parámetros
    public Tipodocumento(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
   
    /**
     * Método para obtener el Id de un tipo de documento
     * @return El id del tipo de documento
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Método para asignar el Id de un tipo de documento
     * @param id que se le va a asignar al tipo de documento
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Método para obtener el nombre o etiqueta de un tipo de documento
     * @return El nombre o etiqueta del tipo de documento
     */
    public String getTipo() {
        return this.tipo;
    }
    
    /**
     * Método para asignar el nombre o etiqueta de un tipo de documento
     * @param tipo que se le va a asignar al tipo de documento
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}



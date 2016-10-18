package co.edu.udea.iw.prestamodispositivos.modelo;

/**
 * Clase que referencia un objeto la tabla rol en la base de datos
 * @author León David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Aléxis Castrillón Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class Rol  implements java.io.Serializable {


     private int id;//Id que identifica un rol específico
     private String nombre;//Nombre de un rol

    //Constructor vacío o por defecto
    public Rol() {
    }

    //Constructor con todos los parÃ¡metros
    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
   
    /**
     * Método para obtener el Id de un rol
     * @return El id del rol
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Método para asignar el Id de un rol
     * @param id que se le va a asignar al rol
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Método para obtener el nombre de un rol
     * @return El nombre del rol
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Método para asignar el nombre de un rol
     * @param nombre que se le va a asignar al rol
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}



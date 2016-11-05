package co.edu.udea.iw.prestamodispositivos.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que referencia un objeto la tabla dispositivo en la base de datos
 * @author León David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Aléxis Castrillón Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@XmlRootElement
public class Dispositivo  implements java.io.Serializable {
 

     private Integer id;//Número de identificación única de cada dispositivo en la base de datos
     private String marca;//Marca del dispositivo
     private String modelo;//Modelo del dispositivo
     private String nombre;//Nombre del dispositivo
     private String descripcion;//Breve texto que describe el dispositivo
     private int cantidad;//Cantidad disponible de un dispositivo específico
     private byte[] imagen;//Imagen del dispositivo

    //Constructor vacío o por defecto
    public Dispositivo() {
    }

    //Contructor con campos obligatorios
    public Dispositivo(String marca, String modelo, String nombre, String descripcion, int cantidad) {
    	this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    
    //Constructor con todos los campos
    public Dispositivo(String marca, String modelo, String nombre, String descripcion, int cantidad, byte[] imagen) {
       this.marca = marca;
       this.modelo = modelo;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.cantidad = cantidad;
       this.imagen = imagen;
    }
   
    /**
     * Método para obtener el Id de un dispositivo
     * @return El id del dispositivo
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * Método para asignar el Id de un dispositivo
     * @param id  que se le va a asignar al dispositivo
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Método para obtener la marca de un dispositivo
     * @return La marca del dispositivo
     */
    public String getMarca() {
        return this.marca;
    }
    
    /**
     * Método para asignar la marca de un dispositivo
     * @param marca que se le va a asignar al dispositivo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Método para obtener el modelo de un dispositivo
     * @return El modelo del dispositivo
     */
    public String getModelo() {
        return this.modelo;
    }
    
    /**
     * Método para asignar el modelo de un dispositivo
     * @param modelo que se le va a asignar al dispositivo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Método para obtener el nombre de un dispositivo
     * @return El nombre del dispositivo
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Método para asignar el nombre de un dispositivo
     * @param nombre que se le va a asignar al dispositivo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método para obtener la descripción de un dispositivo
     * @return La descripción del dispositivo
     */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
     * Método para asignar la descripción de un dispositivo
     * @param descripcion que se le va a asignar al dispositivo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Método para obtener la cantidad de un dispositivo
     * @return La cantidad del dispositivo
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     * Método para asignar la cantidad de un dispositivo
     * @param cantidad que se le va a asignar al dispositivo
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Método para obtener la imagen en bytes de un dispositivo
     * @return La imagen del dispositivo
     */
    public byte[] getImagen() {
        return this.imagen;
    }
    
    /**
     * Método para asignar la imagen de un dispositivo
     * @param imagen que se le va a asignar al dispositivo
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}



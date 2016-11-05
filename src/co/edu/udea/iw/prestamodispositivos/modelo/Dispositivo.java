package co.edu.udea.iw.prestamodispositivos.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que referencia un objeto la tabla dispositivo en la base de datos
 * @author Le�n David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Al�xis Castrill�n Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@XmlRootElement
public class Dispositivo  implements java.io.Serializable {
 

     private Integer id;//N�mero de identificaci�n �nica de cada dispositivo en la base de datos
     private String marca;//Marca del dispositivo
     private String modelo;//Modelo del dispositivo
     private String nombre;//Nombre del dispositivo
     private String descripcion;//Breve texto que describe el dispositivo
     private int cantidad;//Cantidad disponible de un dispositivo espec�fico
     private byte[] imagen;//Imagen del dispositivo

    //Constructor vac�o o por defecto
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
     * M�todo para obtener el Id de un dispositivo
     * @return El id del dispositivo
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * M�todo para asignar el Id de un dispositivo
     * @param id  que se le va a asignar al dispositivo
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * M�todo para obtener la marca de un dispositivo
     * @return La marca del dispositivo
     */
    public String getMarca() {
        return this.marca;
    }
    
    /**
     * M�todo para asignar la marca de un dispositivo
     * @param marca que se le va a asignar al dispositivo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * M�todo para obtener el modelo de un dispositivo
     * @return El modelo del dispositivo
     */
    public String getModelo() {
        return this.modelo;
    }
    
    /**
     * M�todo para asignar el modelo de un dispositivo
     * @param modelo que se le va a asignar al dispositivo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * M�todo para obtener el nombre de un dispositivo
     * @return El nombre del dispositivo
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * M�todo para asignar el nombre de un dispositivo
     * @param nombre que se le va a asignar al dispositivo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * M�todo para obtener la descripci�n de un dispositivo
     * @return La descripci�n del dispositivo
     */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
     * M�todo para asignar la descripci�n de un dispositivo
     * @param descripcion que se le va a asignar al dispositivo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * M�todo para obtener la cantidad de un dispositivo
     * @return La cantidad del dispositivo
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     * M�todo para asignar la cantidad de un dispositivo
     * @param cantidad que se le va a asignar al dispositivo
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * M�todo para obtener la imagen en bytes de un dispositivo
     * @return La imagen del dispositivo
     */
    public byte[] getImagen() {
        return this.imagen;
    }
    
    /**
     * M�todo para asignar la imagen de un dispositivo
     * @param imagen que se le va a asignar al dispositivo
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}



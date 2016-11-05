package co.edu.udea.iw.prestamodispositivos.modelo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que referencia un objeto la tabla solicitud en la base de datos
 * @author León David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Aléxis Castrillón Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@XmlRootElement
public class Solicitud  implements java.io.Serializable {


     private Integer id;//Id de una solicitud
     private Dispositivo dispositivo;//Dispositivo asociado a la solicitud
     private Estadosolicitud estadosolicitud;//Estado asociado a la solicitud
     private Usuario usuario;//Usuario asociado a la solicitud
     private int cantidad;//Cantidad de dispositivos referenciado en la solicitud
     private Date fechainicio;//Fecha con tiempo de inicio del préstamo del dispositivo
     private Date fechafin;//Fecha con tiempo de finalización del préstamo del dispositivo
     private Date fechasolicitud;//Fecha con tiempo del momento en que se realiza la solicitud

    //Contructor vacío o por defecto
    public Solicitud() {
    }

    //Constructor con todos los parámetros
    public Solicitud(Dispositivo dispositivo, Estadosolicitud estadosolicitud, Usuario usuario, int cantidad, Date fechainicio, Date fechafin, Date fechasolicitud) {
       this.dispositivo = dispositivo;
       this.estadosolicitud = estadosolicitud;
       this.usuario = usuario;
       this.cantidad = cantidad;
       this.fechainicio = fechainicio;
       this.fechafin = fechafin;
       this.fechasolicitud = fechasolicitud;
    }
   
    /**
     * Método para obtener el Id de una solicitud
     * @return El id de la solicitud
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * Método para asignar el Id de una solicitud
     * @param id que se le va a asignar a la solicitud
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Método para obtener el dispositivo de una solicitud
     * @return El dispositivo de la solicitud
     */
    public Dispositivo getDispositivo() {
        return this.dispositivo;
    }
    
    /**
     * Método para asignar el dispositivo de una solicitud
     * @param dispositivo que se le va a asignar a la solicitud
     */
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    /**
     * Método para obtener el estado de una solicitud
     * @return El estado de la solicitud
     */
    public Estadosolicitud getEstadosolicitud() {
        return this.estadosolicitud;
    }
    
    /**
     * Método para asignar el estado de una solicitud
     * @param estadosolicitud que se le va a asignar a la solicitud
     */
    public void setEstadosolicitud(Estadosolicitud estadosolicitud) {
        this.estadosolicitud = estadosolicitud;
    }
    
    /**
     * Método para obtener el usuario de una solicitud
     * @return El usuario de la solicitud
     */
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    /**
     * Método para asignar el usuario de una solicitud
     * @param usuario que se le va a asignar a la solicitud
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Método para obtener la cantidad de una solicitud
     * @return La cantidad de la solicitud
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     * Método para asignar la cantidad de una solicitud
     * @param cantidad que se le va a asignar a la solicitud
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Método para obtener la fecha de inicio de una solicitud
     * @return La fecha de inicio de la solicitud
     */
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    /**
     * Método para asignar la fecha de inicio de una solicitud
     * @param fechainicio que se le va a asignar a la solicitud
     */
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    
    /**
     * Método para obtener la fecha de finalización de una solicitud
     * @return La fecha de finalización de la solicitud
     */
    public Date getFechafin() {
        return this.fechafin;
    }
    
    /**
     * Método para asignar la fecha de finalización de una solicitud
     * @param fechafin que se le va a asignar a la solicitud
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    
    /**
     * Método para obtener la fecha de realización de una solicitud
     * @return La fecha de realización de la solicitud
     */
    public Date getFechasolicitud() {
        return this.fechasolicitud;
    }
    
    /**
     * Método para asignar la fecha de realización de una solicitud
     * @param fechasolicitud que se le va a asignar a la solicitud
     */
    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }
}



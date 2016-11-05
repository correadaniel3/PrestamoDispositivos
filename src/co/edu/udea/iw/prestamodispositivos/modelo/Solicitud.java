package co.edu.udea.iw.prestamodispositivos.modelo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que referencia un objeto la tabla solicitud en la base de datos
 * @author Le�n David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Al�xis Castrill�n Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@XmlRootElement
public class Solicitud  implements java.io.Serializable {


     private Integer id;//Id de una solicitud
     private Dispositivo dispositivo;//Dispositivo asociado a la solicitud
     private Estadosolicitud estadosolicitud;//Estado asociado a la solicitud
     private Usuario usuario;//Usuario asociado a la solicitud
     private int cantidad;//Cantidad de dispositivos referenciado en la solicitud
     private Date fechainicio;//Fecha con tiempo de inicio del pr�stamo del dispositivo
     private Date fechafin;//Fecha con tiempo de finalizaci�n del pr�stamo del dispositivo
     private Date fechasolicitud;//Fecha con tiempo del momento en que se realiza la solicitud

    //Contructor vac�o o por defecto
    public Solicitud() {
    }

    //Constructor con todos los par�metros
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
     * M�todo para obtener el Id de una solicitud
     * @return El id de la solicitud
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * M�todo para asignar el Id de una solicitud
     * @param id que se le va a asignar a la solicitud
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * M�todo para obtener el dispositivo de una solicitud
     * @return El dispositivo de la solicitud
     */
    public Dispositivo getDispositivo() {
        return this.dispositivo;
    }
    
    /**
     * M�todo para asignar el dispositivo de una solicitud
     * @param dispositivo que se le va a asignar a la solicitud
     */
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    /**
     * M�todo para obtener el estado de una solicitud
     * @return El estado de la solicitud
     */
    public Estadosolicitud getEstadosolicitud() {
        return this.estadosolicitud;
    }
    
    /**
     * M�todo para asignar el estado de una solicitud
     * @param estadosolicitud que se le va a asignar a la solicitud
     */
    public void setEstadosolicitud(Estadosolicitud estadosolicitud) {
        this.estadosolicitud = estadosolicitud;
    }
    
    /**
     * M�todo para obtener el usuario de una solicitud
     * @return El usuario de la solicitud
     */
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    /**
     * M�todo para asignar el usuario de una solicitud
     * @param usuario que se le va a asignar a la solicitud
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * M�todo para obtener la cantidad de una solicitud
     * @return La cantidad de la solicitud
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     * M�todo para asignar la cantidad de una solicitud
     * @param cantidad que se le va a asignar a la solicitud
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * M�todo para obtener la fecha de inicio de una solicitud
     * @return La fecha de inicio de la solicitud
     */
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    /**
     * M�todo para asignar la fecha de inicio de una solicitud
     * @param fechainicio que se le va a asignar a la solicitud
     */
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    
    /**
     * M�todo para obtener la fecha de finalizaci�n de una solicitud
     * @return La fecha de finalizaci�n de la solicitud
     */
    public Date getFechafin() {
        return this.fechafin;
    }
    
    /**
     * M�todo para asignar la fecha de finalizaci�n de una solicitud
     * @param fechafin que se le va a asignar a la solicitud
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    
    /**
     * M�todo para obtener la fecha de realizaci�n de una solicitud
     * @return La fecha de realizaci�n de la solicitud
     */
    public Date getFechasolicitud() {
        return this.fechasolicitud;
    }
    
    /**
     * M�todo para asignar la fecha de realizaci�n de una solicitud
     * @param fechasolicitud que se le va a asignar a la solicitud
     */
    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }
}



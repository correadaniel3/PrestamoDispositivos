package co.edu.udea.iw.prestamodispositivos.modelo;

/**
 * Clase que referencia un objeto la tabla usuario en la base de datos
 * @author Le�n David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Al�xis Castrill�n Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class Usuario  implements java.io.Serializable {


     private String nombreusuario;//Nickname asociado a un usuario espec�fico
     private Rol rol;//Rol asociado al usuario
     private Tipodocumento tipodocumento;//Tipo de documento asociado al usuario
     private String documento;//Documento o identificaci�n del usuario
     private String nombres;//Nombre o nombres del usuario
     private String apellidos;//Apellidos del usuario
     private String correoelectronico;//Mail o correo electr�nico del usuario
     private String telefono;//Tel�fono del usuario
     private String contrasena;//Contrasena asociada al usuario

    //Contructor vac�o o por defecto
    public Usuario() {
    }

    //Constructor con los par�metros obligatorios
    public Usuario(String nombreusuario, Rol rol, Tipodocumento tipodocumento, String documento, String nombres, String apellidos, String correoelectronico, String contrasena) {
        this.nombreusuario = nombreusuario;
        this.rol = rol;
        this.tipodocumento = tipodocumento;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
    }
    
    //Constructor con todos los par�metros
    public Usuario(String nombreusuario, Rol rol, Tipodocumento tipodocumento, String documento, String nombres, String apellidos, String correoelectronico, String telefono, String contrasena) {
       this.nombreusuario = nombreusuario;
       this.rol = rol;
       this.tipodocumento = tipodocumento;
       this.documento = documento;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correoelectronico = correoelectronico;
       this.telefono = telefono;
       this.contrasena = contrasena;
    }
   
    /**
     * M�todo para obtener el nickname de un usuario
     * @return El nickname del usuario
     */
    public String getNombreusuario() {
        return this.nombreusuario;
    }
    
    /**
     * M�todo para asignar el nickname de un usuario
     * @param nombreusuario que se le va a asignar al usuario
     */
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    
    /**
     * M�todo para obtener el rol de un usuario
     * @return El rol del usuario
     */
    public Rol getRol() {
        return this.rol;
    }
    
    /**
     * M�todo para asignar el rol de un usuario
     * @param rol que se le va a asignar al usuario
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    /**
     * M�todo para obtener el tipo de documento de un usuario
     * @return El tipo de documento del usuario
     */
    public Tipodocumento getTipodocumento() {
        return this.tipodocumento;
    }
    
    /**
     * M�todo para asignar el tipo de documento de un usuario
     * @param tipodocumento que se le va a asignar al usuario
     */
    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
    
    /**
     * M�todo para obtener el documento de un usuario
     * @return El documento del usuario
     */
    public String getDocumento() {
        return this.documento;
    }
    
    /**
     * M�todo para asignar el documento de un usuario
     * @param documento que se le va a asignar al usuario
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    /**
     * M�todo para obtener el o los nombres de un usuario
     * @return El o los nombres del usuario
     */
    public String getNombres() {
        return this.nombres;
    }
    
    /**
     * M�todo para asignar el o los nombres de un usuario
     * @param nombres que se le va a asignar al usuario
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    /**
     * M�todo para obtener los apellidos de un usuario
     * @return Los apellidos del usuario
     */
    public String getApellidos() {
        return this.apellidos;
    }
    
    /**
     * M�todo para asignar los apellidos de un usuario
     * @param apellidos que se le va a asignar al usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * M�todo para obtener el mail de un usuario
     * @return El mail del usuario
     */
    public String getCorreoelectronico() {
        return this.correoelectronico;
    }
    
    /**
     * M�todo para asignar el mail de un usuario
     * @param correoelectronico que se le va a asignar al usuario
     */
    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
    
    /**
     * M�todo para obtener el tel�fono de un usuario
     * @return El tel�fono del usuario
     */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
     * M�todo para asignar el tel�fono de un usuario
     * @param telefono que se le va a asignar al usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * M�todo para obtener la contraseña de un usuario
     * @return La contraseña del usuario
     */
    public String getContrasena() {
        return this.contrasena;
    }
    
    /**
     * M�todo para asignar la contraseña de un usuario
     * @param contrasena que se le va a asignar al usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}



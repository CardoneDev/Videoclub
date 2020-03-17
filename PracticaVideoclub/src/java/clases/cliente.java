/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jacopo
 */
public class cliente {
    private int id;
    private String nif;
    private String nombre;
    private String direccion;
    private String cod_postal;
    private String ciudad;
    private String provincia;
    private String correo;
    private String contra;
    private int movil;
    private int permiso;

    public cliente(int id, String nif, String nombre, String direccion, String cod_postal, String ciudad, String provincia, String correo,String contra, int movil,int permiso) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cod_postal = cod_postal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.correo = correo;
        this.contra=contra;
        this.movil = movil;
        this.permiso=permiso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getMovil() {
        return movil;
    }
    public void setMovil(int movil) {
        this.movil = movil;
    }
    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
    
}

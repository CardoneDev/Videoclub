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
public class historico {
    private String correo;
    private String direccion;
    private String fecha;
    private String trajeta;
    private int idProducto;
    private String imagenProducto;
    private String nombreProducto;
    private double precio;
    private String estado;

    public historico(String correo, String direccion, String fecha, String trajeta, int idProducto, String imagenProducto, String nombreProducto, double precio,String estado) {
        this.correo = correo;
        this.direccion = direccion;
        this.fecha = fecha;
        this.trajeta = trajeta;
        this.idProducto = idProducto;
        this.imagenProducto = imagenProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.estado=estado;
    }

    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTrajeta() {
        return trajeta;
    }

    public void setTrajeta(String trajeta) {
        this.trajeta = trajeta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

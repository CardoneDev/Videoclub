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
public class videojuego {
    private int id;
    private String titulo;
    private String empresa;
    private String tipo;
    private int precio;
    private double precioDesc;
    private int stock;
    private int descuento;
    private String imagen;
    private String fechaVideo;
    private String reservado;
    private String estado;

    public videojuego(String imagen,String titulo , String fechaVideo, String reservado,String estado) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaVideo = fechaVideo;
        this.reservado = reservado;
        this.estado=estado;
    }
    
    

    public videojuego(String imagen, double precioDesc, String titulo,String fechaVideo) {
        this.imagen = imagen;
        this.precioDesc = precioDesc;
        this.titulo = titulo;
        this.fechaVideo=fechaVideo;
    }
    
    

    public videojuego(int id, String titulo, String empresa, String tipo, int precio, int stock, int descuento, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.precio=precio;
        this.stock = stock;
        this.descuento = descuento;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getPrecioDesc() {
        return precioDesc;
    }

    public void setPrecioDesc(double precioDesc) {
        this.precioDesc = precioDesc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaVideo() {
        return fechaVideo;
    }

    public void setFechaVideo(String fechaVideo) {
        this.fechaVideo = fechaVideo;
    }

    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

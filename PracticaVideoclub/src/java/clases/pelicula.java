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
public class pelicula {

    private int id;
    private String titulo;
    private String director;
    private String anio;
    private String genero;
    private int precio;
    private double precioDesc;
    private int stock;
    private int descuento;
    private String imagen;
    private String fechaPeli;
    private String reservado;
    private String estado;

    public pelicula(String imagen, String titulo, String fechaPeli, String reservado,String estado) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaPeli = fechaPeli;
        this.reservado = reservado;
        this.estado=estado;
    }
    
    
    

    public pelicula(String imagen, double precioDesc, String titulo,String fechaPeli ) {
        this.imagen = imagen;
        this.precioDesc = precioDesc;
        this.titulo = titulo;
        this.fechaPeli=fechaPeli;
    }
    
    

    public pelicula(int id, String titulo, String director, String anio, String genero, int precio, int stock, int descuento, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;
        this.precio = precio;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getFechaPeli() {
        return fechaPeli;
    }

    public void setFechaPeli(String fechaPeli) {
        this.fechaPeli = fechaPeli;
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

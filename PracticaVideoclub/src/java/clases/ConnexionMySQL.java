/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Jacopo
 */
public class ConnexionMySQL {

    private Connection conn = null;
    //Debemos de poner el nombre de la base de datos, en nuestro caso pruebas
    private String dbName = "vegavideoclub";
    //Debemos de poner el nombre del usuario, en nuestro caso root
    private String Nombre = "root";
    //Debemos de poner la contraseña de la base de datos, en nuestro caso no tiene
    private String pass = "";
    //Dirección completa donde se encuentra nuestra base de datos
    //Usamos la linea ?useSSL=false para no usar el protocolo SSL y que no nos muestre esa advertencia
    private String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

    public Connection obtenerConexion() {
        System.out.println(url);
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, Nombre, pass);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la conexión");
        }
        return conn;
    }

    /* Método para terminar la conexión a la base de datos */
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
        }
    }

    public void insertarDatos(String nif, String nombre, String direccion, String cod_postal, String ciudad, String provincia, String correo, String contra, String movil) {
        try {
            String sql = "INSERT INTO clientes (id,nif,nombre,direccion,cod_postal,ciudad,provincia,correo,contra,movil,permiso) values (null,?,?,?,?,?,?,?,?,?,null);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nif);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, cod_postal);
            pst.setString(5, ciudad);
            pst.setString(6, provincia);
            pst.setString(7, correo);
            pst.setString(8, contra);
            pst.setString(9, movil);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean comprobarCliente(String correo, String contra) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from clientes WHERE correo=? AND contra=? AND permiso IS NULL;");
            pst.setString(1, correo);
            pst.setString(2, contra);
            ResultSet miResultado = pst.executeQuery();
            if (miResultado.absolute(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return false;
        }

    }

    public Boolean comprobarAdmin(String correo, String contra) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from clientes WHERE correo=? AND contra=? AND permiso IS NOT NULL;");
            pst.setString(1, correo);
            pst.setString(2, contra);
            ResultSet miResultado = pst.executeQuery();
            if (miResultado.absolute(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return false;
        }

    }

    public ArrayList<cliente> listarCliente() {
        ArrayList<cliente> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from clientes");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new cliente(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<pelicula> top8peliculas() {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT * FROM peliculas WHERE stock>0 ORDER BY descuento DESC LIMIT 8;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
            }
            rs.close();
            return datos;

        } catch (Exception e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<pelicula> muestrapeliculas() {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT * FROM peliculas WHERE stock>0 ORDER BY descuento desc;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
            }
            rs.close();
            return datos;
        } catch (Exception e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<videojuego> top8Videojuegos() {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos WHERE stock>0 ORDER BY descuento DESC LIMIT 8;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            rs.close();
            return datos;
        } catch (Exception e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<cliente> Perfil(String correo) {
        ArrayList<cliente> datos = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM clientes WHERE correo=?;");
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11)));
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<pelicula> detallepeli(int id) {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT * FROM peliculas WHERE id=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            System.out.println("error en la consulta");
            return null;
        }
    }

    public void updateCliente(String correo, String contra,String direccion, String ciudad, String movil, String provincia) {
        String sql = "UPDATE clientes SET contra=?,direccion=? ,ciudad=?,movil=?,provincia=? WHERE correo=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, contra);
            pst.setString(2, direccion);
            pst.setString(3, ciudad);
            pst.setString(4, movil);
            pst.setString(5, provincia);
            pst.setString(6, correo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<videojuego> muestravideojuegos() {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos WHERE stock>0 ORDER BY descuento desc;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            rs.close();
            return datos;
        } catch (Exception e) {
            System.out.println("Error en la consulta");
            return null;
        }
    }

    public ArrayList<videojuego> detallevideojuego(int id) {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos WHERE id=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            System.out.println("error en la consulta");
            return null;
        }
    }

    public ArrayList<pelicula> applicaFiltrosPeli(String anio, String genero) {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT * FROM peliculas WHERE anio LIKE ? AND genero LIKE ? AND stock>0 ORDER BY descuento desc;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, anio);
            pst.setString(2, genero);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<videojuego> applicaFiltrosVideo(String empresa, String tipo) {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos WHERE empresa LIKE ? AND tipo LIKE ? AND stock>0 ORDER BY descuento desc;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, empresa);
            pst.setString(2, tipo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int obtenIDcliente(String correo) {
        int idcliente = 0;
        String sql = "SELECT id FROM clientes WHERE correo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                idcliente = rs.getInt(1);
            }
            rs.close();
            return idcliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insertacarritovideo(String id_cliente, String id_video, String tipo) {
        String sql = "INSERT INTO reservas_videojuegos (id_cliente,id_videojuego,fecha,tipo,reservado) VALUES (?,?,NOW(),?,null);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, id_video);
            pst.setString(3, tipo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertacarritopeli(String id_cliente, String id_peli) {
        String sql = "INSERT INTO reservas_pelis (id_cliente,id_peli,fecha,reservado) VALUES (?,?,NOW(),null);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, id_peli);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reducirStockVideo(String id_video) {
        int stock = 1000;
        String sql = "SELECT stock FROM videojuegos WHERE id=?;";
        String sql2 = "UPDATE videojuegos SET stock=? WHERE id=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_video);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock--;
            pst.close();
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, Integer.toString(stock));
            pst2.setString(2, id_video);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void reducirStockPeli(String id_peli) {
        int stock = 1000;
        String sql = "SELECT stock FROM peliculas WHERE id=?;";
        String sql2 = "UPDATE peliculas SET stock=? WHERE id=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_peli);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock--;
            pst.close();
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, Integer.toString(stock));
            pst2.setString(2, id_peli);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<pelicula> ListaPeliculasCarro(String correo) {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT imagen,(precio*(1-(descuento/100))) precioFinal,titulo,fecha FROM reservas_pelis rp INNER JOIN clientes c ON rp.id_cliente=c.id INNER JOIN peliculas p ON rp.id_peli=p.id WHERE correo=? AND reservado IS NULL AND estado='no_pagado';";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<videojuego> ListaVideoCarro(String correo) {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT imagen,(precio*(1-(descuento/100))) precioFinal,titulo,fecha FROM reservas_videojuegos rv INNER JOIN clientes c ON rv.id_cliente=c.id INNER JOIN videojuegos p ON rv.id_videojuego=p.id WHERE correo=? AND reservado IS NULL AND estado='no_pagado' ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminadelCarritoVideo(String id_cliente, String fechaVideo) {
        String sql = "DELETE FROM reservas_videojuegos WHERE id_cliente=? AND fecha=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, fechaVideo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aumentarStockVideo(String titulo) {
        int stock = 1000;
        String sql = "SELECT stock FROM videojuegos WHERE titulo=?;";
        String sql2 = "UPDATE videojuegos SET stock=? WHERE titulo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock++;
            pst.close();
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, Integer.toString(stock));
            pst2.setString(2, titulo);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void eliminadelCarritoPeli(String id_cliente, String fechaPeli) {
        String sql = "DELETE FROM reservas_pelis WHERE id_cliente=? AND fecha=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, fechaPeli);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aumentarStockPeli(String titulo) {
        int stock = 1000;
        String sql = "SELECT stock FROM peliculas WHERE titulo=?;";
        String sql2 = "UPDATE peliculas SET stock=? WHERE titulo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock++;
            pst.close();
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, Integer.toString(stock));
            pst2.setString(2, titulo);
            pst2.executeUpdate();
            pst2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String obtenDireccionCliente(String correo) {
        String completa = "";
        String direccion;
        String ciudad;
        String provincia;
        String cod_postal;
        String sql = "SELECT direccion,ciudad,provincia,cod_postal FROM clientes WHERE correo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                direccion = rs.getString(1);
                ciudad = rs.getString(2);
                provincia = rs.getString(3);
                cod_postal = rs.getString(4);
                completa = direccion + ", " + ciudad + ", " + provincia + ", " + cod_postal;
            }
            rs.close();
            return completa;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateReservasPelis(String id_cliente, String DatosTramite) {
        String estado = "pagado";
        String sql = "UPDATE reservas_pelis SET reservado=?,estado=? WHERE id_cliente=? AND reservado IS NULL AND estado='no_pagado';";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, DatosTramite);
            pst.setString(2, estado);
            pst.setString(3, id_cliente);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReservasVideos(String id_cliente, String DatosTramite) {
        String estado = "pagado";
        String sql = "UPDATE reservas_videojuegos SET reservado=?,estado=? WHERE id_cliente=? AND reservado IS NULL AND estado='no_pagado';";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, DatosTramite);
            pst.setString(2, estado);
            pst.setString(3, id_cliente);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<pelicula> ListaPeliculasHistorial(String correo) {
        ArrayList<pelicula> datos = new ArrayList<>();
        String sql = "SELECT imagen,titulo,fecha,reservado,estado FROM reservas_pelis rp INNER JOIN clientes c ON rp.id_cliente=c.id INNER JOIN peliculas p ON rp.id_peli=p.id WHERE correo=? AND reservado IS NOT NULL AND estado!='no_pagado' ORDER BY fecha ASC;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new pelicula(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<videojuego> ListaVideoHistorial(String correo) {
        ArrayList<videojuego> datos = new ArrayList<>();
        String sql = "SELECT imagen,titulo,fecha,reservado,estado FROM reservas_videojuegos rv INNER JOIN clientes c ON rv.id_cliente=c.id INNER JOIN videojuegos v ON rv.id_videojuego=v.id WHERE correo=? AND reservado IS NOT NULL  AND estado!='no_pagado' ORDER BY fecha ASC;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos.add(new videojuego(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<historico> obtenHistorialCompletoPelis(String correo) {
        ArrayList<historico> historico = new ArrayList<>();
        String sql = "SELECT correo,CONCAT(direccion,',',ciudad,',',provincia,',',cod_postal) AS dir,fecha,reservado,id_peli,imagen,titulo,(precio*(1-(descuento/100))) precioFinal,estado FROM reservas_pelis rp INNER JOIN clientes c ON rp.id_cliente=c.id INNER JOIN peliculas p ON rp.id_peli=p.id WHERE correo!=? ORDER BY fecha ASC;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                historico.add(new historico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            rs.close();
            pst.close();
            return historico;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<historico> obtenHistorialCompletoVideos(String correo) {
        ArrayList<historico> historico = new ArrayList<>();
        String sql = "SELECT correo,CONCAT(direccion,',',ciudad,',',provincia,',',cod_postal) AS dir,fecha,reservado,id_videojuego,imagen,titulo,(precio*(1-(descuento/100))) precioFinal,estado FROM reservas_videojuegos rv INNER JOIN clientes c ON rv.id_cliente=c.id INNER JOIN videojuegos v ON rv.id_videojuego=v.id WHERE correo!=? ORDER BY fecha ASC;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                historico.add(new historico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            rs.close();
            pst.close();
            return historico;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int numeroVideoenCarro(String correo) {
        int num = 0;
        String sql = "SELECT COUNT(*) num FROM reservas_videojuegos RV INNER JOIN clientes C ON RV.id_cliente=C.id WHERE correo=? AND reservado IS NULL AND estado='no_pagado';";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            rs.close();
            pst.close();
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int numeroPeliCarro(String correo) {
        int num = 0;
        String sql = "SELECT COUNT(*) num FROM reservas_pelis RP INNER JOIN clientes C ON RP.id_cliente=C.id WHERE correo=? AND reservado IS NULL AND estado='no_pagado';";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            rs.close();
            pst.close();
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public void modificapedidopeli(String id_cliente, String id_peli, String fecha, String mod) {
        String sql = "UPDATE reservas_pelis SET estado=? WHERE id_cliente=? AND id_peli=? AND fecha=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mod);
            pst.setString(2, id_cliente);
            pst.setString(3, id_peli);
            pst.setString(4, fecha);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificapedidovideo(String id_cliente, String id_video, String fecha, String mod) {
        String sql = "UPDATE reservas_videojuegos SET estado=? WHERE id_cliente=? AND id_videojuego=? AND fecha=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mod);
            pst.setString(2, id_cliente);
            pst.setString(3, id_video);
            pst.setString(4, fecha);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenIDpelicula(String titulo) {
        int idpeli = 0;
        String sql = "SELECT id FROM peliculas WHERE titulo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                idpeli = rs.getInt(1);
            }
            rs.close();
            return idpeli;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int obtenIDvideo(String titulo) {
        int idvideo = 0;
        String sql = "SELECT id FROM videojuegos WHERE titulo=?;";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                idvideo = rs.getInt(1);
            }
            rs.close();
            return idvideo;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void llegaPeli(String id_cliente, String id_pelicula, String fecha) {
        String sql="UPDATE reservas_pelis SET estado='recibido',fecha=NOW() WHERE id_cliente=? AND id_peli=? AND fecha=?;";
        try {
          PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, id_pelicula);
            pst.setString(3, fecha);
            pst.executeUpdate();
            pst.close();  
        } catch (Exception e) {
        }
    }

    public void llegaVideo(String id_cliente, String id_video, String fecha) {
        String sql="UPDATE reservas_videojuegos SET estado='recibido',fecha=NOW() WHERE id_cliente=? AND id_videojuego=? AND fecha=?;";
        try {
          PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_cliente);
            pst.setString(2, id_video);
            pst.setString(3, fecha);
            pst.executeUpdate();
            pst.close();  
        } catch (Exception e) {
        }
    }

    public boolean exsistecliente(String correo) {
        String sql="SELECT * FROM clientes WHERE correo=?;";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, correo);
            ResultSet rs=pst.executeQuery();
            if(rs.absolute(1)){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

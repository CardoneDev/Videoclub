/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import clases.pelicula;
import clases.ConnexionMySQL;
import clases.cliente;
import clases.historico;
import clases.videojuego;
import java.io.*;
import static java.lang.System.out;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jacopo
 */
public class log extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String control = request.getParameter("control");
        switch (control) {
            case "perfil":
                DatosPerfil(request, response);
                break;
            case "inicio":
                PantallaInicio(request, response);
                break;
            case "peliculas":
                MuestraPeliculas(request, response);
                break;
            case "videojuegos":
                MuestraVideojuegos(request, response);
                break;
            case "descripcion":
                DetallePeli(request, response);
                break;
            case "descripcionvideo":
                DetalleVideo(request, response);
                break;
            case "anadecarritovideo":
                anadeCarritoVideo(request, response);
                break;
            case "anadecarritopeli":
                anadeCarritoPeli(request, response);
                break;
            case "carro":
                muestraCarrito(request, response);
                break;
            case "eliminaDelCarroVideo":
                eliminaCarroVideo(request, response);
                break;
            case "eliminaDelCarroPeli":
                eliminaCarroPeli(request, response);
                break;
            case "historialPerfil":
                historialPerfil(request, response);
                break;
            case "salir":
                salir(request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("comando");

        switch (comando) {
            case "log":
                logea(request, response);
                break;
            case "updatecliente":
                updateCliente(request, response);
                break;
            case "analisifitrospeli":
                aplicafiltrosPelis(request, response);
                break;
            case "analisifitrosvideo":
                aplicafiltrosVideos(request, response);
                break;
            case "tramitarCompra":
                tramitarCompras(request, response);
                break;
            case "modifica_pedidoPeli":
                modificaPedidoPeli(request,response);
                break;
            case "modifica_pedidoVideo":
                modificaPedidoVideo(request,response);
                break;
            case "recibido_pedidoPeli":
                recibePeli(request,response);
                break;
            case "recibido_pedidoVideo":
                recibeVideo(request,response);
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void logea(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
        String mensaje="error";
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            if (cn.comprobarCliente(correo, contra)) {
                /**
                 * creo la session*
                 */
                HttpSession session = request.getSession(true);
                
                    session.setAttribute("correo", correo);
               

                try {
                    ArrayList<pelicula> top8pelis = new ArrayList<>();
                    ArrayList<videojuego> top8videos = new ArrayList<>();
                    top8pelis = cn.top8peliculas();
                    top8videos = cn.top8Videojuegos();

                    request.setAttribute("listadoprova2", top8videos);

                    request.setAttribute("listadoprova", top8pelis);
                    numeroCarrito(request, response);

                    RequestDispatcher midispatcher = request.getRequestDispatcher("/inicio.jsp");
                    midispatcher.forward(request, response);
                } catch (Exception e) {
                    out.println("Fallo en el listado-->" + e);
                }

            }
            if (cn.comprobarAdmin(correo, contra)) {
                /**
                 * creo la session *
                 */
                HttpSession session = request.getSession(true);
                    session.setAttribute("correo", correo);

                /*redirecciono*/
                cn.desconectar();
                historialClientes(request, response);

            } else {
                request.setAttribute("mensaje", mensaje);
                RequestDispatcher midispatcher = request.getRequestDispatcher("/index.jsp");
                midispatcher.forward(request, response);

            }
            cn.desconectar();

        } catch (Exception e) {
        }

    }

    private void DatosPerfil(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        try {

            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            ArrayList<cliente> datos = new ArrayList<>();
            datos = cn.Perfil(correo);
            request.setAttribute("datospersonales", datos);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/perfil.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }/*redirecciono*/

    }

    private void PantallaInicio(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<pelicula> top8pelis = new ArrayList<>();
        ArrayList<videojuego> top8videos = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            top8pelis = cn.top8peliculas();
            top8videos = cn.top8Videojuegos();

            request.setAttribute("listadoprova2", top8videos);

            request.setAttribute("listadoprova", top8pelis);
            cn.desconectar();
            numeroCarrito(request, response);

            RequestDispatcher midispatcher = request.getRequestDispatcher("/inicio.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void MuestraPeliculas(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<pelicula> peliculas = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            peliculas = cn.muestrapeliculas();
            request.setAttribute("listadopeliculas", peliculas);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/peliculas.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void DetallePeli(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<pelicula> pelicula = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            pelicula = cn.detallepeli(id);
            request.setAttribute("infopeli", pelicula);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/descripcionPeli.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void updateCliente(HttpServletRequest request, HttpServletResponse response) {
        String movil = request.getParameter("movil");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String provincia=request.getParameter("provincia");
        String contra=request.getParameter("contra");
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            cn.updateCliente(correo, contra, direccion, ciudad, movil ,provincia);
            cn.desconectar();
            //puedo usar metodos pertenecientes a este servlet
            DatosPerfil(request, response);
        } catch (Exception e) {
        }
    }

    private void aplicafiltrosPelis(HttpServletRequest request, HttpServletResponse response) {
        String filtroAnio = request.getParameter("filtropelianio");
        String filtroGenero = request.getParameter("filtropeligenero");
        ArrayList<pelicula> peliculas = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            peliculas = cn.applicaFiltrosPeli(filtroAnio, filtroGenero);
            request.setAttribute("listadopeliculas", peliculas);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/peliculas.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void MuestraVideojuegos(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<videojuego> videojuegos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            videojuegos = cn.muestravideojuegos();
            request.setAttribute("listadovideojuegos", videojuegos);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/videojuegos.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void DetalleVideo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<videojuego> videojuego = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            videojuego = cn.detallevideojuego(id);
            request.setAttribute("infovideo", videojuego);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/descripcionVideo.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void aplicafiltrosVideos(HttpServletRequest request, HttpServletResponse response) {
        String filtrovideoempresa = request.getParameter("filtrovideoempresa");
        String filtrovideotipo = request.getParameter("filtrovideotipo");
        ArrayList<videojuego> videojuegos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            videojuegos = cn.applicaFiltrosVideo(filtrovideoempresa, filtrovideotipo);
            request.setAttribute("listadovideojuegos", videojuegos);
            cn.desconectar();
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/videojuegos.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    private void anadeCarritoVideo(HttpServletRequest request, HttpServletResponse response) {
        String id_cliente;
        String mensaje = "Elemento añadido correctamente";
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        String id_video = request.getParameter("idvideo");
        String tipo = request.getParameter("tipo");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente = Integer.toString(cn.obtenIDcliente(correo));
            cn.insertacarritovideo(id_cliente, id_video, tipo);
            cn.reducirStockVideo(id_video);
            cn.desconectar();
            request.setAttribute("mensaje", mensaje);
            //muestro los videojuegos
            MuestraVideojuegos(request, response);
        } catch (Exception e) {
        }
    }

    private void anadeCarritoPeli(HttpServletRequest request, HttpServletResponse response) {
        String id_cliente;
        String mensaje = "Elemento añadido correctamente";
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        String id_peli = request.getParameter("idpeli");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente = Integer.toString(cn.obtenIDcliente(correo));
            cn.insertacarritopeli(id_cliente, id_peli);
            cn.reducirStockPeli(id_peli);
            cn.desconectar();
            request.setAttribute("mensaje", mensaje);
            //muestro los videojuegos
            MuestraPeliculas(request, response);
        } catch (Exception e) {
        }
    }

    private void muestraCarrito(HttpServletRequest request, HttpServletResponse response) {
        double parcial_peli = 0;
        double parcial_video = 0;
        double total = 0;
        String direccion;
        ArrayList<pelicula> peliculas = new ArrayList<>();
        ArrayList<videojuego> videojuegos = new ArrayList<>();
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            direccion = cn.obtenDireccionCliente(correo);
            peliculas = cn.ListaPeliculasCarro(correo);
            videojuegos = cn.ListaVideoCarro(correo);
            for (pelicula pelicula : peliculas) {
                parcial_peli += pelicula.getPrecioDesc();
            }
            for (videojuego videojuego : videojuegos) {
                parcial_video += videojuego.getPrecioDesc();
            }
            total = parcial_peli + parcial_video;
            request.setAttribute("listacarropeli", peliculas);
            request.setAttribute("listacarrovideo", videojuegos);
            request.setAttribute("parcialvideo", parcial_video);
            request.setAttribute("parcialpeli", parcial_peli);
            request.setAttribute("direccion", direccion);
            request.setAttribute("total", total);
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/carrito.jsp");
            midispatcher.forward(request, response);

        } catch (Exception e) {
        }
    }

    private void eliminaCarroVideo(HttpServletRequest request, HttpServletResponse response) {
        String mensaje = "";
        String titulo = request.getParameter("nombreVideo");
        String fechaVideo = request.getParameter("fechaVideo");
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        String id_cliente;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente = Integer.toString(cn.obtenIDcliente(correo));
            cn.eliminadelCarritoVideo(id_cliente, fechaVideo);
            cn.aumentarStockVideo(titulo);
            cn.desconectar();
            muestraCarrito(request, response);

        } catch (Exception e) {
        }
    }

    private void eliminaCarroPeli(HttpServletRequest request, HttpServletResponse response) {
        String mensaje = "";
        String titulo = request.getParameter("nombrePeli");
        String fechaPeli = request.getParameter("fechaPeli");
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        String id_cliente;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente = Integer.toString(cn.obtenIDcliente(correo));
            cn.eliminadelCarritoPeli(id_cliente, fechaPeli);
            cn.aumentarStockPeli(titulo);
            cn.desconectar();
            muestraCarrito(request, response);

        } catch (Exception e) {
        }
    }

    private void tramitarCompras(HttpServletRequest request, HttpServletResponse response) {
        String mensaje = "Compra realizada corectamente";
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        String id_cliente;
        String DatosTramite = request.getParameter("numTarjeta");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente = Integer.toString(cn.obtenIDcliente(correo));
            cn.updateReservasPelis(id_cliente, DatosTramite);
            cn.updateReservasVideos(id_cliente, DatosTramite);
            cn.desconectar();
            request.setAttribute("mensaje", mensaje);
            muestraCarrito(request, response);
        } catch (Exception e) {
        }
    }

    private void historialPerfil(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<pelicula> peliculas = new ArrayList<>();
        ArrayList<videojuego> videojuegos = new ArrayList<>();
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            peliculas = cn.ListaPeliculasHistorial(correo);
            videojuegos = cn.ListaVideoHistorial(correo);
            request.setAttribute("listahistorialpeli", peliculas);
            request.setAttribute("listahistorialvideo", videojuegos);
            numeroCarrito(request, response);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/historial.jsp");
            midispatcher.forward(request, response);

        } catch (Exception e) {
        }
    }

    private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(false);
      session.removeAttribute("correo");
      session.getMaxInactiveInterval();
      response.sendRedirect("index.jsp");
    }

    private void historialClientes(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        ArrayList<historico> datos1 = new ArrayList<historico>();
        ArrayList<historico> datos2 = new ArrayList<historico>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            datos1 = cn.obtenHistorialCompletoPelis(correo);
            datos2 = cn.obtenHistorialCompletoVideos(correo);
            request.setAttribute("histoPeli", datos1);
            request.setAttribute("histoVideo", datos2);
            RequestDispatcher midispatcher = request.getRequestDispatcher("/administrador.jsp");
            midispatcher.forward(request, response);
        } catch (Exception e) {
        }

    }

    private void numeroCarrito(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String correo = (String) session.getAttribute("correo");
        int numTot=0;
       int numVideo=0;
       int numPeli=0;
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn=new ConnexionMySQL();
            cn.obtenerConexion();
            numVideo=cn.numeroVideoenCarro(correo);
            numPeli=cn.numeroPeliCarro(correo);
            numTot=numVideo+numPeli;
            request.setAttribute("totCarro",numTot);
            
        } catch (Exception e) {
        }
    }
     public void PantallaIndex(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<pelicula> top8pelis = new ArrayList<>();
        ArrayList<videojuego> top8videos = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn = new ConnexionMySQL();
            cn.obtenerConexion();
            top8pelis = cn.top8peliculas();
            top8videos = cn.top8Videojuegos();
            request.setAttribute("listadoprova2", top8videos);
            request.setAttribute("listadoprova", top8pelis);
            cn.desconectar();
        } catch (Exception e) {
        }
    }

    private void modificaPedidoPeli(HttpServletRequest request, HttpServletResponse response) {
       String correo=request.getParameter("correo");
       String fecha=request.getParameter("fecha");
       String id_peli=request.getParameter("id_peli");
       String mod=request.getParameter("mod");
       String id_cliente;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn=new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente=Integer.toString(cn.obtenIDcliente(correo));
            cn.modificapedidopeli(id_cliente,id_peli,fecha,mod);
            cn.desconectar();
            historialClientes(request,response);
        } catch (Exception e) {
        }
    }

    private void modificaPedidoVideo(HttpServletRequest request, HttpServletResponse response) {
        String correo=request.getParameter("correo");
       String fecha=request.getParameter("fecha");
       String id_video=request.getParameter("id_video");
       String mod=request.getParameter("mod");
       String id_cliente;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn=new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente=Integer.toString(cn.obtenIDcliente(correo));
            cn.modificapedidovideo(id_cliente,id_video,fecha,mod);
            cn.desconectar();
            historialClientes(request,response);
            
        } catch (Exception e) {
        }
    }

    private void recibePeli(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        String correo=(String)session.getAttribute("correo");
        String titulo=request.getParameter("titulo");
        String fecha=request.getParameter("fecha");
        String id_cliente;
        String id_pelicula;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn=new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente=Integer.toString(cn.obtenIDcliente(correo));
            id_pelicula=Integer.toString(cn.obtenIDpelicula(titulo));
            cn.llegaPeli(id_cliente,id_pelicula,fecha);
            historialPerfil(request, response);
        } catch (Exception e) {
        }
    }

    private void recibeVideo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        String correo=(String)session.getAttribute("correo");
        String titulo=request.getParameter("titulo");
        String fecha=request.getParameter("fecha");
        String id_cliente;
        String id_video;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnexionMySQL cn=new ConnexionMySQL();
            cn.obtenerConexion();
            id_cliente=Integer.toString(cn.obtenIDcliente(correo));
            id_video=Integer.toString(cn.obtenIDvideo(titulo));
            cn.llegaVideo(id_cliente,id_video,fecha);
            historialPerfil(request, response);
        } catch (Exception e) {
        }
    }

    public void seguridad(HttpServletRequest request, HttpServletResponse response) {
       HttpSession session=request.getSession(false);
        if (session.getAttribute("correo")==null) {
             RequestDispatcher midispatcher = request.getRequestDispatcher("/index.jsp");
           try {
               midispatcher.forward(request, response);
           } catch (ServletException ex) {
               Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }


}

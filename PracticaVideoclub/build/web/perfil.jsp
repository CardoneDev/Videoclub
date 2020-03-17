<%-- 
    Document   : perfil
    Created on : 12-feb-2020, 21:01:02
    Author     : Jacopo
--%>

<%@page import="Servlet.log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="clases.*" %>
<%@page import="java.util.*" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Perfil</title>
        <style>
            body{
                background-image: url("./images/background.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
                color:white;
            }
            #bienvenida{

                border: 1px solid #444444;
                border-radius: 20px 20px 20px 20px;
                margin-top: 25px;
                margin-bottom: 30px;

                padding: 10px;
                -webkit-box-shadow: 0px 0px 24px 0px rgba(255,255,255, 0.61);
                -moz-box-shadow:    0px 0px 24px 0px rgba(255,255,255, 0.61);
                box-shadow:         0px 0px 24px 0px rgba(255,255,255, 0.61);
            }
            .navbar{
                height: 90px;
            }
            /**cssFooter**/
            /*FOOTER*/

            footer {

                color: white;
                margin-top:100px;
            }

            footer a {
                color: #fff;
                font-size: 14px;
                transition-duration: 0.2s;
            }

            footer a:hover {
                color: #FA944B;
                text-decoration: none;
            }

            .copy {
                font-size: 12px;
                padding: 10px;
                border-top: 1px solid #FFFFFF;
            }

            .footer-middle {
                padding-top: 2em;
                color: white;
            }


            /*SOCİAL İCONS*/

            /* footer social icons */

            ul.social-network {
                list-style: none;
                display: inline;
                margin-left: 0 !important;
                padding: 0;
            }

            ul.social-network li {
                display: inline;
                margin: 0 5px;
            }


            /* footer social icons */

            .social-network a.icoFacebook:hover {
                background-color: #3B5998;
            }

            .social-network a.icoLinkedin:hover {
                background-color: #007bb7;
            }

            .social-network a.icoFacebook:hover i,
            .social-network a.icoLinkedin:hover i {
                color: #fff;
            }

            .social-network a.socialIcon:hover,
            .socialHoverClass {
                color: #44BCDD;
            }

            .social-circle li a {
                display: inline-block;
                position: relative;
                margin: 0 auto 0 auto;
                -moz-border-radius: 50%;
                -webkit-border-radius: 50%;
                border-radius: 50%;
                text-align: center;
                width: 30px;
                height: 30px;
                font-size: 15px;
            }

            .social-circle li i {
                margin: 0;
                line-height: 30px;
                text-align: center;
            }

            .social-circle li a:hover i,
            .triggeredHover {
                -moz-transform: rotate(360deg);
                -webkit-transform: rotate(360deg);
                -ms--transform: rotate(360deg);
                transform: rotate(360deg);
                -webkit-transition: all 0.2s;
                -moz-transition: all 0.2s;
                -o-transition: all 0.2s;
                -ms-transition: all 0.2s;
                transition: all 0.2s;
            }

            .social-circle i {
                color: #595959;
                -webkit-transition: all 0.8s;
                -moz-transition: all 0.8s;
                -o-transition: all 0.8s;
                -ms-transition: all 0.8s;
                transition: all 0.8s;
            }

            .social-network a {
                background-color: #F9F9F9;
            }
            /**numerito carro*/
            .num-ele{
                position:absolute;
                border-radius: 2em;
                width: 20px;
                text-align: center;
                height: 22px;
                color: white;
                background-color: red;
                top:8px;
                left:2px;
            }
        </style>
    </head>
    <%
        log lg=new log();
        lg.seguridad(request, response);
    %>
    <body>
        <!--navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <a class="navbar-brand" href="#">Vega VideoClub</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="log?control=inicio">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="log?control=perfil">Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="log?control=historialPerfil">Historial</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Productos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="log?control=peliculas">Peliculas</a>
                            <a class="dropdown-item" href="log?control=videojuegos">Videojuegos</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="log?control=salir">Salir</a>
                    </li>
                </ul>
            </div>
            <a href="log?control=carro" style="position: relative;color:inherit;text-decoration: none;"><div class="num-ele">${totCarro}</div><i class="fas fa-shopping-cart" style="font-size:40px;
                                                                                                                                                 margin-right: 20px; "></i></a>
        </nav>
        <!--main-->
        <div class="container">
            <div class="row">
                <div class="col bg-dark" style="margin-top:100px;padding: 40px;border-radius: 2em;-webkit-box-shadow: 0px 0px 16px 0px rgba(255, 255, 255, 0.75);
-moz-box-shadow:    0px 0px 16px 0px rgba(255, 255, 255, 0.75);
box-shadow:         0px 0px 16px 0px rgba(255, 255, 255, 0.75);opacity: 0.8">

                    <c:forEach var="Lista" items="${datospersonales}">
                        <form action="log" method="post">
                            <div class="form-group row">
                                <label for="inputcorreo" class="col-sm-2 col-form-label">Correo:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="correo" id="inputcorreo" value="${Lista.correo}" readonly>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputcontra" class="col-sm-2 col-form-label">Contraseña:</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="contra" id="inputcontra" value="${Lista.contra}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputmovil" class="col-sm-2 col-form-label" >Movil:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="movil" id="inputmovil" maxlength="10" value="${Lista.movil}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputdir" class="col-sm-2 col-form-label">Direccion:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="direccion" id="inputdireccion" value="${Lista.direccion}">
                                </div>
                                <label for="inputciudad" class="col-sm-2 col-form-label">Ciudad:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="ciudad" id="inputciudad" value="${Lista.ciudad}">
                                </div>
                            </div>
                                <div class="form-group row">
                                <label for="inputprov" class="col-sm-2 col-form-label">Provincia:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="provincia" id="inputprov" value="${Lista.provincia}">
                                </div>
                            </div>
                            
                            <input type="text" name="comando" value="updatecliente" hidden>
                            <div class="form-group row">
                                <div class="col-sm-10 mt-4">
                                    <button type="submit" class="btn btn-outline-primary">Actualiza</button>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>


        <!--footer-->
        <footer class="mainfooter bg-dark" role="contentinfo">
            <div class="footer-middle">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <!--Column1-->
                            <div class="footer-pad">
                                <h4>Metodos de pago</h4>
                                <ul class="list-unstyled">
                                    <li><a href="#"></a></li>
                                    <li><a href="#">Centro de pago</a></li>
                                    <li><a href="#">Contacto</a></li>
                                    <li><a href="#">Formulario</a></li>
                                    <li><a href="#">Novedades</a></li>
                                    <li><a href="#">FAQs</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <!--Column1-->
                            <div class="footer-pad">
                                <h4>Ayudas</h4>
                                <ul class="list-unstyled">
                                    <li><a href="#">Mapa del sitio</a></li>
                                    <li><a href="#">Accesibilidad</a></li>
                                    <li><a href="#">Disclaimer</a></li>
                                    <li><a href="#">Politica de privacidad</a></li>
                                    <li><a href="#">FAQs</a></li>
                                    <li><a href="#">Webmaster</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <!--Column1-->
                            <div class="footer-pad">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3141.8080729558183!2d-1.2558799558383238!3d38.05155817971007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd647ed425284579%3A0xc1fae33ccb32d958!2sCES%20Vega%20Media!5e0!3m2!1ses!2ses!4v1581536296171!5m2!1ses!2ses" width="220" height="150" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <h4>Siguenos</h4>
                            <ul class="social-network social-circle">
                                <li><a href="#" class="icoFacebook" title="Facebook"><i class="fab fa-facebook"></i></a></li>
                                <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fab fa-twitter"></i></a></li>
                            </ul>				
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 copy">
                            <p class="text-center">&copy; Copyright 2020 - VegaVideoclubJacopoCardone.  Todo los derechos &reg; reservados.</p>
                        </div>
                    </div>


                </div>
            </div>
        </footer>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>

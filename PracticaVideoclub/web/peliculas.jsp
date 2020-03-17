<%-- 
    Document   : peliculas
    Created on : 13-feb-2020, 20:27:07
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

        <title>Peliculas</title>
        <style>
           body{
                background-image: url("./images/background.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
                color:white;
            }
            table{
                opacity: 0.8;
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
            img{
                width:180px;
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
        <!--filtros-->
        <div class="container ">
            <div class="row">
                <div class="col-12 bg-dark p-0 pt-4 pb-4 mt-3">
                    <form method="POST" class="form-inline ">
                        <div class="form-group m-auto text-light">
                            Ordena por:
                            <label for="inputState" class="ml-4 mr-2">A&ntilde;o de estreno</label>
                            <select id="inputState1" name="filtropelianio" class="form-control">
                                <option value="%%" selected>cualquiera</option>
                                <option value="%1972%">1972</option>
                                <option value="%1982%">1982</option>
                                <option value="%1996%">1996</option>
                                <option value="%2010%">2010</option>
                                <option value="%2019%">2019</option>
                            </select>  
                            <label for="inputState" class="ml-4 mr-2">Genero</label>
                            <select id="inputState2" name="filtropeligenero" class="form-control">
                                <option value="%%" selected>culaquiera</option>
                                <option value="%drama%">Drama</option>
                                <option value="%fantasia%">Fantasia</option>
                                <option value="%comedia%">Comedia</option>
                                <option value="%mistero%">Misterio</option>
                            </select>
                            <input type="text" name="comando" value="analisifitrospeli" hidden>
                            <button type="submit" class="btn btn-outline-primary ml-4 ">Ordena</button>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>
    <!--main-->
    <div class="container p-0">
        <div class="row">
            <div class="col" style="margin-top:50px;">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Titulo</th>
                            <th scope="col">Director</th>
                            <th scope="col">Descuento</th>
                            <th scope="col">Precio</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--Aqui va el taglist-->
                        <!--la primer columna recuerda <th scope="row">1</th>-->
                        <c:forEach var="Lista" items="${listadopeliculas}">
                            <tr class="text-center-row">
                                <th scope="row"><a href="log?control=descripcion&id=${Lista.id}"><img class="img-fluid" src="${Lista.imagen}"></a></th>
                                <td>${Lista.titulo}</td>
                                <td>${Lista.director}</td>
                                <td>${Lista.descuento}%</td>
                                <td>${Lista.precio}€</td>
                                <td><a class="btn btn-outline-warning" href="log?control=anadecarritopeli&idpeli=${Lista.id}">A&ntilde;ade al carrito</a></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${mensaje == 'Elemento añadido correctamente'}">
                        <div class="alert alert-success alert-dismissible fade show" id="mensaje" role="alert">
                            Elemento <strong>añadido</strong> corectamente al carrito
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    </tbody>
                </table>
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


<%-- 
    Document   : formulario
    Created on : 08-feb-2020, 13:40:19
    Author     : Jacopo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Formulario de registro</title>
        <style>
             body{
                background-image: url("./images/super_1.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
                color:white;
            }
        </style>
    </head>
    <body>
        <div class="container bg-dark text-light" style="margin-top:30px;width:700px;padding:20px; border-radius:2em;border: 2px solid white;-webkit-box-shadow: 4px 5px 10px 0px rgba(0, 0, 0, 0.75);
             -moz-box-shadow:    4px 5px 10px 0px rgba(0, 0, 0, 0.75);
             box-shadow:         4px 5px 10px 0px rgba(0, 0, 0, 0.75);">
            <div class="row">
                <div class="col-12 mb-4">
                    <center class="text-light display-4 mb-2">Registrate</center>
                </div>
                <div class="col-12">
                    <c:if test="${mensaje == 'El correo insertado no esta disponible,inserte otro por favor'}">
                        <div class="alert alert-danger alert-dismissible fade show" id="mensaje" role="alert">
                            El <strong>correo</strong> introducido no esta disponible, por favor ingrese otro
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <form action="compruebaFormulario" method="POST">
                        <div class="form-group row">
                            <label for="nif" class="col-sm-2 col-form-label">Nif</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="nif" id="inputnif" placeholder="tu nif..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="nombre" id="inputnombre" placeholder="tu nombre..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="direccion" id="inputdireccion" placeholder="tu direccion..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="cod_postal" class="col-sm-2 col-form-label">Cod.Postal</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="cod_postal" id="inputcod_postal" placeholder="tu codigo postal..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="ciudad" class="col-sm-2 col-form-label">Ciudad</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ciudad" id="inputciudad" placeholder="tu ciudad..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="provincia" class="col-sm-2 col-form-label">Provincia</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="provincia" id="inputprovincia" placeholder="tu provincia..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="correo" class="col-sm-2 col-form-label">Correo</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="correo" id="inputcorreo" placeholder="tu correo..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputcontra" class="col-sm-2 col-form-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="contra" id="inputcontra" placeholder="tu contraseña..." required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="movil" class="col-sm-2 col-form-label">Movil</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" maxlength="victor@gmail.com" name="movil" id="inputmovil" placeholder="tu numero de movil..." required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-10 mt-2">
                                <button type="submit" class="btn btn-outline-light">Registrate</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>

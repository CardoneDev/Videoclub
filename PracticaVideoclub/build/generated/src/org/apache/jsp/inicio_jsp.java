package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.*;
import java.util.*;

public final class inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Iconos\n");
      out.write("        <link href=\"//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css\" rel=\"stylesheet\">-->\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <title>Inicio</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: #333;\n");
      out.write("                color:white;\n");
      out.write("            }\n");
      out.write("            #bienvenida{\n");
      out.write("\n");
      out.write("                border: 1px solid #444444;\n");
      out.write("                border-radius: 20px 20px 20px 20px;\n");
      out.write("                margin-top: 25px;\n");
      out.write("                margin-bottom: 30px;\n");
      out.write("\n");
      out.write("                padding: 10px;\n");
      out.write("                -webkit-box-shadow: 0px 0px 24px 0px rgba(255,255,255, 0.61);\n");
      out.write("                -moz-box-shadow:    0px 0px 24px 0px rgba(255,255,255, 0.61);\n");
      out.write("                box-shadow:         0px 0px 24px 0px rgba(255,255,255, 0.61);\n");
      out.write("            }\n");
      out.write("            .navbar{\n");
      out.write("                height: 90px;\n");
      out.write("            }\n");
      out.write("            /**cssFooter**/\n");
      out.write("            /*FOOTER*/\n");
      out.write("\n");
      out.write("            footer {\n");
      out.write("\n");
      out.write("                color: white;\n");
      out.write("                margin-top:100px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer a {\n");
      out.write("                color: #fff;\n");
      out.write("                font-size: 14px;\n");
      out.write("                transition-duration: 0.2s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer a:hover {\n");
      out.write("                color: #FA944B;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .copy {\n");
      out.write("                font-size: 12px;\n");
      out.write("                padding: 10px;\n");
      out.write("                border-top: 1px solid #FFFFFF;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .footer-middle {\n");
      out.write("                padding-top: 2em;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            /*SOCİAL İCONS*/\n");
      out.write("\n");
      out.write("            /* footer social icons */\n");
      out.write("\n");
      out.write("            ul.social-network {\n");
      out.write("                list-style: none;\n");
      out.write("                display: inline;\n");
      out.write("                margin-left: 0 !important;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ul.social-network li {\n");
      out.write("                display: inline;\n");
      out.write("                margin: 0 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            /* footer social icons */\n");
      out.write("\n");
      out.write("            .social-network a.icoFacebook:hover {\n");
      out.write("                background-color: #3B5998;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-network a.icoLinkedin:hover {\n");
      out.write("                background-color: #007bb7;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-network a.icoFacebook:hover i,\n");
      out.write("            .social-network a.icoLinkedin:hover i {\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-network a.socialIcon:hover,\n");
      out.write("            .socialHoverClass {\n");
      out.write("                color: #44BCDD;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-circle li a {\n");
      out.write("                display: inline-block;\n");
      out.write("                position: relative;\n");
      out.write("                margin: 0 auto 0 auto;\n");
      out.write("                -moz-border-radius: 50%;\n");
      out.write("                -webkit-border-radius: 50%;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                text-align: center;\n");
      out.write("                width: 30px;\n");
      out.write("                height: 30px;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-circle li i {\n");
      out.write("                margin: 0;\n");
      out.write("                line-height: 30px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-circle li a:hover i,\n");
      out.write("            .triggeredHover {\n");
      out.write("                -moz-transform: rotate(360deg);\n");
      out.write("                -webkit-transform: rotate(360deg);\n");
      out.write("                -ms--transform: rotate(360deg);\n");
      out.write("                transform: rotate(360deg);\n");
      out.write("                -webkit-transition: all 0.2s;\n");
      out.write("                -moz-transition: all 0.2s;\n");
      out.write("                -o-transition: all 0.2s;\n");
      out.write("                -ms-transition: all 0.2s;\n");
      out.write("                transition: all 0.2s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-circle i {\n");
      out.write("                color: #595959;\n");
      out.write("                -webkit-transition: all 0.8s;\n");
      out.write("                -moz-transition: all 0.8s;\n");
      out.write("                -o-transition: all 0.8s;\n");
      out.write("                -ms-transition: all 0.8s;\n");
      out.write("                transition: all 0.8s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .social-network a {\n");
      out.write("                background-color: #F9F9F9;\n");
      out.write("            }\n");
      out.write("            /**numerito carro*/\n");
      out.write("            .num-ele{\n");
      out.write("                position:absolute;\n");
      out.write("                border-radius: 2em;\n");
      out.write("                width: 20px;\n");
      out.write("                text-align: center;\n");
      out.write("                height: 22px;\n");
      out.write("                color: white;\n");
      out.write("                background-color: red;\n");
      out.write("                top:8px;\n");
      out.write("                left:2px;\n");
      out.write("            }\n");
      out.write("            img{\n");
      out.write("                width: 30px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--navbar-->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Vega VideoClub</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"log?control=inicio\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"log?control=perfil\">Perfil</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"log?control=historialPerfil\">Historial</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Productos\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"log?control=peliculas\">Peliculas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"log?control=videojuegos\">Videojuegos</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"log?control=salir\">Salir</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!--icono carrito-->\n");
      out.write("            <a href=\"log?control=carro\" style=\"position: relative;color:inherit;text-decoration: none;\"><div class=\"num-ele\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totCarro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div><i class=\"fas fa-shopping-cart\" style=\"font-size:40px;\n");
      out.write("               margin-right: 20px; \"></i></a>\n");
      out.write("        </nav>\n");
      out.write("        <!--cuerpo-->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-8 display-4 text-center\"id=\"bienvenida\">\n");
      out.write("                    Bienvenido/a ");
out.print(session.getAttribute("correo"));
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <center class=\"text\" style=\"font-weight:bold;margin-bottom: 8px;font-size: 26pt;\">Top Descuento Peliculas</center>\n");
      out.write("                    <table class=\"table table-dark\" style=\"color: white\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\"></th>\n");
      out.write("                                <th scope=\"col\">Titulo</th>\n");
      out.write("                                <th scope=\"col\">Precio</th>\n");
      out.write("                                <th scope=\"col\">Descuento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <center class=\"text\" style=\"font-weight:bold;margin-bottom: 8px;font-size: 26pt;\">Top Descuento Videojuegos</center>\n");
      out.write("                    <table class=\"table table-dark\" style=\"color: white\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\"></th>\n");
      out.write("                                <th scope=\"col\">Titulo</th>\n");
      out.write("                                <th scope=\"col\">Precio</th>\n");
      out.write("                                <th scope=\"col\">Descuento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--footer-->\n");
      out.write("        <footer class=\"mainfooter bg-dark\" role=\"contentinfo\">\n");
      out.write("            <div class=\"footer-middle\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-3 col-sm-6\">\n");
      out.write("                            <!--Column1-->\n");
      out.write("                            <div class=\"footer-pad\">\n");
      out.write("                                <h4>Metodos de pago</h4>\n");
      out.write("                                <ul class=\"list-unstyled\">\n");
      out.write("                                    <li><a href=\"#\"></a></li>\n");
      out.write("                                    <li><a href=\"#\">Centro de pago</a></li>\n");
      out.write("                                    <li><a href=\"#\">Contacto</a></li>\n");
      out.write("                                    <li><a href=\"#\">Formulario</a></li>\n");
      out.write("                                    <li><a href=\"#\">Novedades</a></li>\n");
      out.write("                                    <li><a href=\"#\">FAQs</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3 col-sm-6\">\n");
      out.write("                            <!--Column1-->\n");
      out.write("                            <div class=\"footer-pad\">\n");
      out.write("                                <h4>Ayudas</h4>\n");
      out.write("                                <ul class=\"list-unstyled\">\n");
      out.write("                                    <li><a href=\"#\">Mapa del sitio</a></li>\n");
      out.write("                                    <li><a href=\"#\">Accesibilidad</a></li>\n");
      out.write("                                    <li><a href=\"#\">Disclaimer</a></li>\n");
      out.write("                                    <li><a href=\"#\">Politica de privacidad</a></li>\n");
      out.write("                                    <li><a href=\"#\">FAQs</a></li>\n");
      out.write("                                    <li><a href=\"#\">Webmaster</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3 col-sm-6\">\n");
      out.write("                            <!--Column1-->\n");
      out.write("                            <div class=\"footer-pad\">\n");
      out.write("                                <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3141.8080729558183!2d-1.2558799558383238!3d38.05155817971007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd647ed425284579%3A0xc1fae33ccb32d958!2sCES%20Vega%20Media!5e0!3m2!1ses!2ses!4v1581536296171!5m2!1ses!2ses\" width=\"220\" height=\"150\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\"></iframe>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <h4>Siguenos</h4>\n");
      out.write("                            <ul class=\"social-network social-circle\">\n");
      out.write("                                <li><a href=\"#\" class=\"icoFacebook\" title=\"Facebook\"><i class=\"fab fa-facebook\"></i></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"icoLinkedin\" title=\"Linkedin\"><i class=\"fab fa-twitter\"></i></a></li>\n");
      out.write("                            </ul>\t\t\t\t\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12 copy\">\n");
      out.write("                            <p class=\"text-center\">&copy; Copyright 2020 - VegaVideoclubJacopoCardone.  Todo los derechos &reg; reservados.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- Optional JavaScript -->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("Listatop8peli");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listadoprova}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <th scope=\"row\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8peli.imagen}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8peli.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8peli.precio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("€</td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8peli.descuento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("%</td>\n");
          out.write("                                </tr>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("Listatop8video");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listadoprova2}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <th scope=\"row\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8video.imagen}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8video.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8video.precio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("€</td><td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Listatop8video.descuento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("%</td>\n");
          out.write("                                </tr>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}

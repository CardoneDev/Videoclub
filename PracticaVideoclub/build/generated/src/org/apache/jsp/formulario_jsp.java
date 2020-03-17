package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formulario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <title>Formulario de registro</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: #333;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container text-light\" style=\"margin-top:30px;width:700px;padding:20px; border-radius:2em;border: 2px solid white;-webkit-box-shadow: 4px 5px 10px 0px rgba(0, 0, 0, 0.75);\n");
      out.write("             -moz-box-shadow:    4px 5px 10px 0px rgba(0, 0, 0, 0.75);\n");
      out.write("             box-shadow:         4px 5px 10px 0px rgba(0, 0, 0, 0.75);\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12 mb-4\">\n");
      out.write("                    <center class=\"text-light display-4 mb-2\">Registrate</center>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <form action=\"compruebaFormulario\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"nif\" class=\"col-sm-2 col-form-label\">Nif</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nif\" id=\"inputnif\" placeholder=\"tu nif...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"nombre\" class=\"col-sm-2 col-form-label\">Nombre</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nombre\" id=\"inputnombre\" placeholder=\"tu nombre...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"direccion\" class=\"col-sm-2 col-form-label\">Direccion</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"direccion\" id=\"inputdireccion\" placeholder=\"tu direccion...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"cod_postal\" class=\"col-sm-2 col-form-label\">Cod.Postal</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"cod_postal\" id=\"inputcod_postal\" placeholder=\"tu codigo postal...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"ciudad\" class=\"col-sm-2 col-form-label\">Ciudad</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"ciudad\" id=\"inputciudad\" placeholder=\"tu ciudad...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"provincia\" class=\"col-sm-2 col-form-label\">Provincia</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"provincia\" id=\"inputprovincia\" placeholder=\"tu provincia...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"correo\" class=\"col-sm-2 col-form-label\">Correo</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"correo\" id=\"inputcorreo\" placeholder=\"tu correo...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"inputcontra\" class=\"col-sm-2 col-form-label\">Password</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"contra\" id=\"inputcontra\" placeholder=\"tu contraseña...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"movil\" class=\"col-sm-2 col-form-label\">Movil</label>\n");
      out.write("                            <div class=\"col-sm-10\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"movil\" id=\"inputmovil\" placeholder=\"tu numero de movil...\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <div class=\"col-sm-10 mt-2\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-outline-light\">Registrate</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Optional JavaScript -->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}

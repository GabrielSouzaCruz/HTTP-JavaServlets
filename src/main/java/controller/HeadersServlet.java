package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/headers"})
public class HeadersServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html><html><body>");
        out.println("<h2>Análise de Cabeçalhos HTTP</h2>");
        out.println("<ul>");
        
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            out.println("<li><b>" + headerName + ":</b> " + headerValue + "</li>");
        }
        out.println("</ul>");
        
        out.println("<h3>Informações do Cliente:</h3>");
        out.println("<p><b>IP do Usuário:</b> " + req.getRemoteAddr() + "</p>");
        out.println("<p><b>Versão do Protocolo:</b> " + req.getProtocol() + "</p>");
        out.println("</body></html>");
    }

}
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/methods"})
public class MethodsServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        
        resp.getWriter().println("--- ENDPOINT DE MÉTODOS SUPORTADOS ---");
        resp.getWriter().println("Status: Ativo");
        resp.getWriter().println("Modo de teste ideal: Envie uma requisição HTTP OPTIONS para esta URL.");
        resp.getWriter().println("Métodos permitidos por este servidor: GET, POST, PUT, DELETE, OPTIONS");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
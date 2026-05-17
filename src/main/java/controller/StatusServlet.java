package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/status"})
public class StatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeParam = req.getParameter("code");
        
        if (codeParam != null && !codeParam.isEmpty()) {
            try {
                int statusCode = Integer.parseInt(codeParam);
                if (statusCode >= 400) {
                    resp.sendError(statusCode, "Erro simulado pelo StatusServlet");
                } else {
                    resp.setStatus(statusCode);
                    resp.getWriter().println("<h1>Status HTTP respondido: " + statusCode + "</h1>");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().println("<h1>Parâmetro code invalido! Use numeros.</h1>");
            }
        } else {
            resp.getWriter().println("<h1>Passe o parametro '?code=' na URL. Exemplo: /status?code=404</h1>");
        }
    }
}
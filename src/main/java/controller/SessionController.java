package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/app/session")
public class SessionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String utilizador = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("usuario".equals(c.getName())) {
                    utilizador = c.getValue();
                    break;
                }
            }
        }

        if (utilizador == null) {
            Cookie novoCookie = new Cookie("usuario", "Visitante_Especial");
            novoCookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(novoCookie);
            req.setAttribute("mensagem", "Olá! Este é o seu primeiro acesso. Criámos um cookie no seu navegador.");
        } else {
            req.setAttribute("mensagem", "Bem-vindo de volta, utilizador '" + utilizador + "'!");
        }

        req.getRequestDispatcher("/views/session.jsp").forward(req, resp);
    }
}
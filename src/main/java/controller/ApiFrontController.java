package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/*")
public class ApiFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        String rota = req.getPathInfo();
        
        if ("/headers".equals(rota)) {
            retornarHeadersJson(req, out);
        } else if ("/status".equals(rota)) {
            out.println("{ \"mensagem\": \"Endpoint de status acedido\" }");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("{ \"erro\": \"Rota não encontrada na API\" }");
        }
    }

    private void retornarHeadersJson(HttpServletRequest req, PrintWriter out) {
        out.println("{");
        out.println("  \"ip_cliente\": \"" + req.getRemoteAddr() + "\",");
        out.println("  \"protocolo\": \"" + req.getProtocol() + "\",");
        out.println("  \"cabecalhos\": {");
        
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String val = req.getHeader(key).replace("\"", "\\\"");
            boolean isLast = !headerNames.hasMoreElements();
            out.println("    \"" + key + "\": \"" + val + "\"" + (isLast ? "" : ","));
        }
        out.println("  }");
        out.println("}");
    }
}
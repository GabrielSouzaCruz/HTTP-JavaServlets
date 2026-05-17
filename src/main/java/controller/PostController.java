package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;
import model.dao.DAOFactory;
import model.dao.PostDAO;

@WebServlet("/app/request-body")
public class PostController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String mensagem = req.getParameter("mensagem");
        
        String mensagemResultado = "";
        
        try {
            Post novoPost = new Post();
            novoPost.setNome(nome);
            novoPost.setEmail(email);
            novoPost.setMensagem(mensagem);
            
            PostDAO dao = DAOFactory.createDAO(PostDAO.class);
            dao.save(novoPost);
            
            mensagemResultado = "Salvo com sucesso no MySQL!";
            
        } catch (Exception e) {
            mensagemResultado = "Erro ao salvar no banco de dados: " + e.getMessage();
            e.printStackTrace();
        }
        
        req.setAttribute("nome", nome);
        req.setAttribute("email", email);
        req.setAttribute("mensagem", mensagemResultado);

        req.getRequestDispatcher("/views/resultado.jsp").forward(req, resp);
    }
}
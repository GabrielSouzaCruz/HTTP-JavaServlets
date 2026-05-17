package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ModelException;
import model.Post;

public class MySQLPostDAO implements PostDAO {

    @Override
    public boolean save(Post post) throws ModelException {
        String sql = "INSERT INTO posts (nome, email, mensagem) VALUES (?, ?, ?)";
        
        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, post.getNome());
            stmt.setString(2, post.getEmail());
            stmt.setString(3, post.getMensagem());
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; 
            
        } catch (SQLException e) {
            throw new ModelException("Erro ao salvar o post no banco de dados: " + e.getMessage());
        }
    }
}
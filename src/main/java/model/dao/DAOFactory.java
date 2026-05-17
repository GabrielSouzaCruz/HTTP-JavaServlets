package model.dao;

public class DAOFactory {
    
    @SuppressWarnings("unchecked")
    public static <T> T createDAO(Class<T> type) {
        if (PostDAO.class.equals(type)) {
            return (T) new MySQLPostDAO();
        }
        throw new IllegalArgumentException("DAO não encontrado para a classe: " + type.getName());
    }
}
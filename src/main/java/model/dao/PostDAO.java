package model.dao;

import model.ModelException;
import model.Post;

public interface PostDAO {
	boolean save(Post post) throws ModelException;
}

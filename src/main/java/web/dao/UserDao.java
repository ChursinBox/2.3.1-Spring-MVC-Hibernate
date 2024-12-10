package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> all();
    public User show(int id);
    public void save(User user);
    public void update(int id, User updateUser);
    public void delete(int id);
}

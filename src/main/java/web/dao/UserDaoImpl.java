package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> all() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        entityManager.merge(updateUser);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}

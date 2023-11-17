package br.com.pauloh.service;

import br.com.pauloh.model.User;
import br.com.pauloh.service.generic.GenericService;

public class UserService extends GenericService<User> implements IUserService {
    
    public UserService() {
        super(User.class);
        new GenericService<>(User.class);
    }
    
    @Override
    public User readEmail(String email) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    
}

package br.com.pauloh.service;

import br.com.pauloh.model.User;
import br.com.pauloh.service.generic.IGenericService;

public interface IUserService extends IGenericService<User> {

    User readEmail(String email);
    
}

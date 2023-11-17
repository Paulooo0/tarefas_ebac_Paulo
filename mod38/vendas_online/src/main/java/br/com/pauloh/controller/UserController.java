package br.com.pauloh.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.pauloh.model.User;
import br.com.pauloh.service.IUserService;
import lombok.Getter;
import lombok.Setter;

public class UserController {
    
	@Getter
	@Setter
    private User user;
	
	@Getter
	@Setter
	private Collection<User> users;
	
	@Inject
	private IUserService userService;
	
	@Getter
	@Setter
	private Boolean isUpdate;


    @PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.user = new User();
			this.users = userService.searchAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os usuários"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.user = new User();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(User user) {
		try {
			this.isUpdate = true;
			this.user = user;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o usuário"));
		}
		
    }

}

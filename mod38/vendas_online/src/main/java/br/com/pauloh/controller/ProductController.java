package br.com.pauloh.controller;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.pauloh.model.Product;
import br.com.pauloh.service.IProductService;
import lombok.Getter;
import lombok.Setter;

public class ProductController {
    
	@Getter
	@Setter
    private Product prod;
	
	@Getter
	@Setter
	private Collection<Product> prods;
	
	@Inject
	private IProductService prodService;
	
	@Getter
	@Setter
	private Boolean isUpdate;


    @PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.prod = new Product();
			this.prods = prodService.searchAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os produtos"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.prod = new Product();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Product prod) {
		try {
			this.isUpdate = true;
			this.prod = prod;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
		}
		
    }

}

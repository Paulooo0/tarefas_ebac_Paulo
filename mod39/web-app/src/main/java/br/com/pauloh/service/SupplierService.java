package br.com.pauloh.service;

import java.util.UUID;

import br.com.pauloh.model.Supplier;
import br.com.pauloh.service.generic.GenericService;

public class SupplierService extends GenericService<Supplier, UUID> implements ISupplierService {

    public SupplierService() {
        super(Supplier.class);
        new GenericService<>(Supplier.class);
    }
    
}

package br.com.pauloh.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pauloh.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, UUID> {

}

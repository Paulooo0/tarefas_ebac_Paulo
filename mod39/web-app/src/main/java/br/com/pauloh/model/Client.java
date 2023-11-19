package br.com.pauloh.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;

    @Column(name = "phone", nullable = false, unique = true, length = 12)
    private String phone;
}

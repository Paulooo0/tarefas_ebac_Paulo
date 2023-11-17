package br.com.pauloh.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_user")
public class User {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64, unique = true)
    private String email;

    @Column(nullable = false, length = 32)
    private String password;

    @Column(nullable = false, length = 16)
    private String phone;

    @Column(nullable = false, length = 11, unique = true)
    private Long cpf;
}

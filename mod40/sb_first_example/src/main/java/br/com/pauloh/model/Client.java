package br.com.pauloh.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "tb_client")
@Data
@Builder
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private Long cpf;

    @Column(name = "phone", nullable = false, length = 12)
    private Long phone;

    @Column(name = "email", nullable = false, length = 128, unique = true)
    private String email;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Column(name = "number", nullable = false)
    private Integer addres_number;

    @Column(name = "city", nullable = false, length = 128)
    private String city;

    @Column(name = "state", nullable = false, length = 64)
    private String state;
}

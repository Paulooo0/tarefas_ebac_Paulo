package br.com.pauloh.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;
}

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
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "bar_code", nullable = false, unique = true)
    private String barCode;

    @Column(name = "supplier", nullable = false, length = 128)
    private String supplier;
}

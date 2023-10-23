package br.com.pauloh.domain;

import br.com.pauloh.dao.Persistent;

public class Client implements Persistent {
    private String name;
    private Long cpf;
    private Long tel;
    private String address;
    private Integer number;
    private String city;
    private String state;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}

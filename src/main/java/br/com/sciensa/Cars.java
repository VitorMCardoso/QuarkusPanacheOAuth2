package br.com.sciensa;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Cars extends PanacheEntity{
    
    @Column
    public String marca;

    @Column
    public String modelo;

    public Cars(){

    }

    public Cars(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
}

package com.search.zipcode.model;

import lombok.Data;

@Data
public class ZipCodeModel {

    private String Cep;
    private String Logradouro;
    private String Complemento;
    private String Localidade;
    private String Bairro;
    private String Uf;

    //Getters and Setters
}

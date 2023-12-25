package com.elmernissi.myrestufinder.model;

public class Magasin {
    private String Nom;
    private String Address;
    private String Tel;

    public Magasin(String nom, String address, String tel) {
        Nom = nom;
        Address = address;
        Tel = tel;
    }

    public String getNom() {
        return Nom;
    }

    public String getAddress() {
        return Address;
    }

    public String getTel() {
        return Tel;
    }
}

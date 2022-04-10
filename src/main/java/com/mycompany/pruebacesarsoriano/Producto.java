
package com.mycompany.pruebacesarsoriano;

public class Producto {
    private int idproducto;
    private String descripcion;
    private double valor;

    public Producto(int idproducto, String descripcion, double valor) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
    
    
}

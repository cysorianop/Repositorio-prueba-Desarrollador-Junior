
package com.mycompany.pruebacesarsoriano;

import java.util.ArrayList;

public class Factura {
    
    private int numFactura;
    private String nomPagador;
    private int idPagador;
    private boolean aplicaIVA;
    private boolean aplicaRetelIVA;
    private boolean aplicaReteICA;
    private boolean aplicaRetefuente;
    private double precioTotal;
    private ArrayList<Producto> listaProductos = new ArrayList();

    private static double IVA = 0.19;
    private static double RETE_IVA = 0.15;
    private static double RETE_FUENTE = 0.025;
    private static double RETE_ICA = 4.14;
    
    private double valortotal_iva = 0;
    private double valortotal_reteiva = 0;
    private double valortotal_retefuente = 0;
    private double valortotal_reteica = 0;
    private double valortotal_facturado = 0;
    private double valortotal_retenciones = 0;
    private double netoApagar = 0;

    public Factura(int numFactura, String nomPagador, int idPagador, boolean aplicaIVA, boolean aplicaRetelIVA, boolean aplicaReteICA, boolean aplicaRetefuente, double precioTotal) {
        this.numFactura = numFactura;
        this.nomPagador = nomPagador;
        this.idPagador = idPagador;
        this.aplicaIVA = aplicaIVA;
        this.aplicaRetelIVA = aplicaRetelIVA;
        this.aplicaReteICA = aplicaReteICA;
        this.aplicaRetefuente = aplicaRetefuente;
        this.precioTotal = precioTotal;
    }

    public Factura() {
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getNomPagador() {
        return nomPagador;
    }

    public void setNomPagador(String nomPagador) {
        this.nomPagador = nomPagador;
    }

    public int getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(int idPagador) {
        this.idPagador = idPagador;
    }

    public boolean isAplicaIVA() {
        return aplicaIVA;
    }

    public void setAplicaIVA(boolean aplicaIVA) {
        this.aplicaIVA = aplicaIVA;
    }

    public boolean isAplicaRetelIVA() {
        return aplicaRetelIVA;
    }

    public void setAplicaRetelIVA(boolean aplicaRetelIVA) {
        this.aplicaRetelIVA = aplicaRetelIVA;
    }

    public boolean isAplicaReteICA() {
        return aplicaReteICA;
    }

    public void setAplicaReteICA(boolean aplicaReteICA) {
        this.aplicaReteICA = aplicaReteICA;
    }

    public boolean isAplicaRetefuente() {
        return aplicaRetefuente;
    }

    public void setAplicaRetefuente(boolean aplicaRetefuente) {
        this.aplicaRetefuente = aplicaRetefuente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getValortotal_iva() {
        return valortotal_iva;
    }

    public void setValortotal_iva(double valortotal_iva) {
        this.valortotal_iva = valortotal_iva;
    }

    public double getValortotal_reteiva() {
        return valortotal_reteiva;
    }

    public void setValortotal_reteiva(double valortotal_reteiva) {
        this.valortotal_reteiva = valortotal_reteiva;
    }

    public double getValortotal_retefuente() {
        return valortotal_retefuente;
    }

    public void setValortotal_retefuente(double valortotal_retefuente) {
        this.valortotal_retefuente = valortotal_retefuente;
    }

    public double getValortotal_reteica() {
        return valortotal_reteica;
    }

    public void setValortotal_reteica(double valortotal_reteica) {
        this.valortotal_reteica = valortotal_reteica;
    }

    public double getValortotal_facturado() {
        return valortotal_facturado;
    }

    public void setValortotal_facturado(double valortotal_facturado) {
        this.valortotal_facturado = valortotal_facturado;
    }

    public double getValortotal_retenciones() {
        return valortotal_retenciones;
    }

    public void setValortotal_retenciones(double valortotal_retenciones) {
        this.valortotal_retenciones = valortotal_retenciones;
    }

    public double getNetoApagar() {
        return netoApagar;
    }

    public void setNetoApagar(double netoApagar) {
        this.netoApagar = netoApagar;
    }
    
    public double calcularValorTotal () {
        
        for(int i=0; i<listaProductos.size(); i++){
            Producto producto = new Producto();
            producto = listaProductos.get(i);
            precioTotal = precioTotal + producto.getValor();
        }
        return precioTotal;
    }
    
    public void añadirProducto (Producto producto){
        this.listaProductos.add(producto);
    }
    
    public void eliminarProducto (int codigo){
        
        for(int i=0; i<listaProductos.size(); i++){
             if(listaProductos.get(i).getIdproducto() == codigo){
               listaProductos.remove(i);
           }
        }
    }
        
    public double calcularValorTotalIVA() {
        
        valortotal_iva = calcularValorTotal() * IVA;
        return valortotal_iva;
        
    }
    
    public double calcularValorTotalfacturado() {
        double valor;
        for(int i=0; i<listaProductos.size(); i++){
            Producto producto = new Producto();
            producto = listaProductos.get(i);
            precioTotal = precioTotal + producto.getValor();
            valor = precioTotal * IVA;
            valortotal_facturado = valor + precioTotal;
        }
        
        return valortotal_facturado;
    }
    
    public double calcularRetencionPorRenta() {
        
        valortotal_retefuente= calcularValorTotal() * RETE_FUENTE;
        return valortotal_retefuente;
        
    }
    
    public double calcularRetencionPorIca() {
        
        valortotal_reteica= (calcularValorTotal() * RETE_ICA ) / 1000;
        return valortotal_reteica;
        
    }
    
    public double calcularRetencionPorIVA() {
        
        valortotal_reteiva= (calcularValorTotalIVA() * RETE_IVA );
        return valortotal_reteiva;
        
    }
    
    public double calcularvalorTotalRetenciones() {
        for(int i=0; i<listaProductos.size(); i++){
            Producto producto = new Producto();
            producto = listaProductos.get(i);
            precioTotal = precioTotal + producto.getValor();
            valortotal_retefuente = precioTotal * RETE_FUENTE;
            valortotal_reteica = (precioTotal * RETE_ICA)/1000;
            valortotal_reteiva = (precioTotal*IVA)*RETE_IVA;
            valortotal_retenciones = valortotal_retefuente + valortotal_reteica + valortotal_reteiva;
        }
        return valortotal_retenciones;
        
    }
    
    public double calcularNetoaPagar() {
        double valort=0;
        for(int i=0; i<listaProductos.size(); i++){
            Producto producto = new Producto();
            producto = listaProductos.get(i);
            precioTotal = precioTotal + producto.getValor();
            valort = precioTotal * IVA;
            valortotal_facturado = valort + precioTotal;
            
            valortotal_retefuente = precioTotal * RETE_FUENTE;
            valortotal_reteica = (precioTotal * RETE_ICA)/1000;
            valortotal_reteiva = (precioTotal*IVA)*RETE_IVA;
            valortotal_retenciones = valortotal_retefuente + valortotal_reteica + valortotal_reteiva;
            netoApagar = valortotal_facturado - valortotal_retenciones;
        }
        return netoApagar;        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.pruebacesarsoriano.Factura;
import com.mycompany.pruebacesarsoriano.Producto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cesar
 */
public class FacturaTest {
    
    public FacturaTest() {
    }
    
    @Test
    public void calcularTotalTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 7000000);
        Producto producto1 = new Producto(2, "LAVADORA", 6000000);
        Producto producto2 = new Producto(3, "NEVERA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        factura.getListaProductos().add(producto2);
        //Act
        double result = factura.calcularValorTotal();
        //Assert
        assertEquals(18000000, result);
    }
    
    @Test
    public void añadirProductosTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 7000000);
        //Act
        factura.getListaProductos().add(producto);
        //Assert
        assertEquals(1, factura.getListaProductos().size());
    }
    
    @Test
    public void eliminarProductosTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        factura.eliminarProducto(1);
        //Assert
        assertEquals(1, factura.getListaProductos().size());
    }
    
    @Test
    public void calcularTotalIVATest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularValorTotalIVA();
        //Assert
        assertEquals(1900000, result);
    }
    
    @Test
    public void calcularTotalFacturadoTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularValorTotalfacturado();
        //Assert
        assertEquals(11900000, result);
    }
    
    @Test
    public void calcularRetencionPorRentaTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularRetencionPorRenta();
        //Assert
        assertEquals(250000, result);
    }
    
    @Test
    public void calcularRetencionPorIcaTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularRetencionPorIca();
        //Assert
        assertEquals(41400, result);
    }
    
    @Test
    public void calcularRetencionPorIvaTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularRetencionPorIVA();
        //Assert
        assertEquals(285000, result);
    }
    
    @Test
    public void calcularTotalRetencionesTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularvalorTotalRetenciones();
        //Assert
        assertEquals(576400, result);
    }
    
    @Test
    public void calcularNetoaPagarTest(){
        //Arrange
        Factura factura = new Factura();
        Producto producto = new Producto(1, "TV", 5000000);
        Producto producto1 = new Producto(2, "LAVADORA", 5000000);
        factura.getListaProductos().add(producto);
        factura.getListaProductos().add(producto1);
        //Act
        double result = factura.calcularNetoaPagar();
        //Assert
        assertEquals(11323600, result);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

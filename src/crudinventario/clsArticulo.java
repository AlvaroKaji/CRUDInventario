/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author abc
 */
public class clsArticulo {
    // atributos que necesito que tenga mi objeto
    private String codigo;
    private String descripcion;
    private Double precio;

    // constructor
    public clsArticulo(String codigo, String descripcion, Double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }
    
    public clsArticulo(){
    
    }
    
    // imprimir en consola los datos del articulo
    public String aTexto() {
        // Solo retornamos la cadena, no imprimimos aquí
        return this.codigo + "|" + this.descripcion + "|" + this.precio;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }

    // guardar informacion
    public void guardar() {
        mArticulo article = new mArticulo();
        String textoArticulo = this.aTexto(); // Obtenemos el texto una sola vez

        // Enviamos la cadena para guardar en el archivo
        article.Insertar(textoArticulo);

        // Si quieres verlo en consola una sola vez:
        System.out.println(textoArticulo);
    }
    
    public DefaultListModel<String> llenarLista(){
        mArticulo MArticle = new mArticulo();
        
        ArrayList<String> datos = MArticle.Consultar();
        
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        return modelLista;
    }
    
    public void actualizar(String newCOdigo, String newDescripcion, String newPrecio){
        String nuevaLinea  = newCOdigo + "|" + newDescripcion + "|" + newPrecio;
        
        String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio;
        
        //Imprimir los nuevos valores
        System.out.println("Nuevos valores" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        
        //Solicita la actualizacion del registro
        mArticulo mArticle = new mArticulo();
        
        mArticle.update(lineaOriginal, nuevaLinea, "listado_articulos.txt");
    }
    
    public void eliminar(){
        
        String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio;
        
        System.out.println("Valores Originales:" + lineaOriginal);
        
        //Solicita la aeliminacion del registro
        mArticulo mArticle = new mArticulo();
        mArticle.delete(lineaOriginal, "listado_articulos.txt");
    }
    
}

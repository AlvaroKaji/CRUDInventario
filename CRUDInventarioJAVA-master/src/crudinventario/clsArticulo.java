/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author dogza
 */
public class clsArticulo {
    
    // Atributos 
    private String codigo;
    private String descripcion;
    private Double precio;
    
    public clsArticulo(String codigo , String descripcion, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public clsArticulo(){

    }
    
    //Im
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio;
        return articulo;
    }
    
    public void detDescripcion(){
        return this.descripcion;
    }
    
    public void guardar() {
        
        mArticulo articulo = new mArticulo();
        // Enviamos la cadena de texto
        articulo.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> LlenarLista(){
        //Instancia desde el modelo
        mArticulo mArticle = new mArticulo();
        //Llenamos la variable con los datos del modelo
        ArrayList<String> datos = mArticle.consultar();
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel();
        // Llenamos la plantilla con los datos del modelo
        for ( String registro: datos){
            modelLista.addElement(registro);
        }
        // Devuelve los datos cargados en el modelo de lsita
        return modelLista;
    }
    
    public void actualizar(String new){
    }
    
    public void eliminar(){
    }
  
}
